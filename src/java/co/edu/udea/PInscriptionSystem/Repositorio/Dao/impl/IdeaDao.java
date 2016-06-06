/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl;

import co.edu.udea.PInscriptionSystem.Repositorio.Dao.*;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroGallego
 */
public class IdeaDao implements InterfaceIdeaDao {

    Dao dao;

    public IdeaDao() {
        dao = new Dao();
    }

    @Override
    public List<Idea> getOfertaSemestre(String sem) {
        List<Idea> ideas = new ArrayList();
        Idea idea;
        int id, estudiantesxEquipo, disponibilidad, idavalador, totalEquipos;
        String titulo, descripcion;
        Date fecha;
        List<Persona> postulante;
        Persona avalador;
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            Statement s = conexion.createStatement();
            String sql;
            if (sem == null) {
                sql = "select Identificador, titulo, Descripcion, `Fecha_creacion`, NroEstudiantesxEquipo,NroEquipos, Persona_avalador_idPersona from Idea";
            } else {
                sql = "select Identificador, titulo, Descripcion, `Fecha_creacion`, NroEstudiantesxEquipo, Disponibilidad, NroEquipos, Persona_avalador_idPersona from Oferta_semestre inner join Idea   where (Semestre=" + sem + ") and (identificador=Idea_identificador)";
            }
            ResultSet resIdeas = s.executeQuery(sql);
            while (resIdeas.next()) {
                id = resIdeas.getInt(1);
                titulo = resIdeas.getString(2);
                descripcion = resIdeas.getString(3);
                fecha = resIdeas.getDate(4);
                estudiantesxEquipo = resIdeas.getInt(5);
                disponibilidad = resIdeas.getInt(5);
                idavalador = resIdeas.getInt(7);
                postulante = this.getPostulantes(conexion, id);
                avalador = this.getAvalador(conexion, idavalador);
                totalEquipos = resIdeas.getInt(7);
                idea = new Idea(id, titulo, descripcion, fecha, estudiantesxEquipo, disponibilidad, totalEquipos, postulante, avalador);
                idea.setRequisitos(this.getRequisitos(conexion, id));
                ideas.add(idea);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ideas;
    }

    @Override
    public Persona getAvalador(Connection c, int idavalador) {
        try {
            Statement s = c.createStatement();
            ResultSet resAvalador = s.executeQuery("select Nombre, Correo from `Persona` where idPersona=" + idavalador);
            resAvalador.next();
            return new Persona(idavalador, resAvalador.getString(1), resAvalador.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Persona> getPostulantes(Connection c, int idIdea) {
        List<Persona> postulantes = new ArrayList();
        Persona es = null;
        try {
            Statement s = c.createStatement();
            ResultSet resPostulante = s.executeQuery("select idPersona, Nombre, Correo, rol, Tipo, Representante_idPersona from Idea inner join Postulante_has_Idea on Idea_Identificador=identificador inner join Persona on Persona_idPersona=idPersona where identificador=" + idIdea);
            while (resPostulante.next()) {
                if (resPostulante.getString(4).equals("profesor")) {
                    es = new Profesor(resPostulante.getInt(1), resPostulante.getString(2), resPostulante.getString(3));
                } else if (resPostulante.getString(4).equals("estudiante")) {
                    es = new Estudiante(resPostulante.getInt(1), resPostulante.getString(2), resPostulante.getString(3));
                } else if ("juridica".equals(resPostulante.getString(5))) {
                    es = new Juridica(resPostulante.getInt(1), resPostulante.getString(2), resPostulante.getString(3));
                    int idRepresentante = resPostulante.getInt(6);
                    ResultSet resRepresentante = s.executeQuery("select Nombre, Correo from `Persona` where idPersona=" + idRepresentante);
                    ((Juridica) es).setRepresentante(new Persona(idRepresentante, resRepresentante.getString(1), resRepresentante.getString(2)));
                }
                if (es != null) {
                    postulantes.add(es);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return postulantes;
    }

    @Override
    public Idea getIdeaByID(int id) {
        Idea idea = null;
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            Statement s = conexion.createStatement();
            ResultSet resIdeas = s.executeQuery("select Identificador, titulo, Descripcion, `Fecha_creacion`, NroEstudiantesxEquipo,NroEquipos, Persona_avalador_idPersona from Idea where Identificador=" + id);
            resIdeas.next();
            id = resIdeas.getInt(1);
            String titulo = resIdeas.getString(2);
            String descripcion = resIdeas.getString(3);
            Date fecha = resIdeas.getDate(4);
            int estudiantesxEquipo = resIdeas.getInt(5);
            int disponibilidad = resIdeas.getInt(6);
            int idavalador = resIdeas.getInt(7);
            List<Persona> postulante = this.getPostulantes(conexion, id);
            Persona avalador = this.getAvalador(conexion, idavalador);
            int totalEquipos = resIdeas.getInt(7);
            idea = new Idea(id, titulo, descripcion, fecha, estudiantesxEquipo, disponibilidad, totalEquipos, postulante, avalador);
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idea;
    }

    @Override
    public Requisito getRequisitos(Connection c, int idIdea) {
        Statement s, x;
        Requisito req = null;
        try {
            s = c.createStatement();
            x = c.createStatement();
            ResultSet resArea = x.executeQuery("Select Nombre from Area");
            ResultSet resRequisito = s.executeQuery("select Codigo,Nombre,Area_Codigo from Materia inner join Prerequisito where Codigo=Codigo_Materia and Prerequisito.Idea_Identificador = " + idIdea);
            List<String> areas = new ArrayList();
            while (resArea.next()) {
                areas.add(resArea.getString(1));
            }
            int codMateria, codArea;
            String nombre;
            req = new Requisito(areas);
            List<String> a1 = null, a2 = null, a3 = null, a4 = null, a5 = null, a6 = null, a7 = null, a8 = null;
            while (resRequisito.next()) {
                codMateria = resRequisito.getInt(1);
                nombre = resRequisito.getString(2);
                codArea = resRequisito.getInt(3);
                switch (codArea) {
                    case 1:
                        if (a1 == null) {
                            a1 = new ArrayList();
                        }
                        a1.add(resRequisito.getString(1));
                        break;
                    case 2:
                        if (a2 == null) {
                            a2 = new ArrayList();
                        }
                        a2.add(resRequisito.getString(1));
                        break;
                    case 3:
                        if (a3 == null) {
                            a3 = new ArrayList();
                        }
                        a3.add(resRequisito.getString(1));
                        break;
                    case 4:
                        if (a4 == null) {
                            a4 = new ArrayList();
                        }
                        a4.add(resRequisito.getString(1));
                        break;
                    case 5:
                        if (a5 == null) {
                            a5 = new ArrayList();
                        }
                        a5.add(resRequisito.getString(1));
                        break;
                    case 6:
                        if (a6 == null) {
                            a6 = new ArrayList();
                        }
                        a6.add(resRequisito.getString(1));
                        break;
                    case 7:
                        if (a7 == null) {
                            a7 = new ArrayList();
                        }
                        a7.add(resRequisito.getString(1));
                        break;
                    case 8:
                        if (a7 == null) {
                            a7 = new ArrayList();
                        }
                        a7.add(resRequisito.getString(1));
                        break;
                }
                req.setA1(a1);
                req.setA2(a2);
                req.setA3(a3);
                req.setA4(a4);
                req.setA5(a5);
                req.setA6(a6);
                req.setA7(a7);
                req.setA8(a8);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return req;
    }
}
