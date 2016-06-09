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

    private Dao dao;

    public IdeaDao() {
        dao = new Dao();
    }

    /**
     *
     * @param sem Es el semestre del cual se obtendra la lista de ideas, null
     * para enviar todas las ideas existentes
     * @return Lista con ideas de proyecto del semestre enviado como parametro.
     */
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
                InterfacePersonaDao persona = new PersonaDao();
                postulante = persona.getPostulantes(conexion, id);
                avalador = persona.getAvalador(conexion, idavalador);
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
            InterfacePersonaDao persona = new PersonaDao();
            List<Persona> postulante = persona.getPostulantes(conexion, id);
            Persona avalador = persona.getAvalador(conexion, idavalador);
            int totalEquipos = resIdeas.getInt(7);
            idea = new Idea(id, titulo, descripcion, fecha, estudiantesxEquipo, disponibilidad, totalEquipos, postulante, avalador);
            idea.setRequisitos(this.getRequisitos(conexion, id));
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
            List<Materia> a1 = null, a2 = null, a3 = null, a4 = null, a5 = null, a6 = null, a7 = null, a8 = null;
            Materia mat;
            while (resRequisito.next()) {
                codMateria = resRequisito.getInt(1);
                nombre = resRequisito.getString(2);
                codArea = resRequisito.getInt(3);
                mat = new Materia(nombre, codMateria);
                switch (codArea) {
                    case 1:
                        if (a1 == null) {
                            a1 = new ArrayList();
                        }
                        a1.add(mat);
                        break;
                    case 2:
                        if (a2 == null) {
                            a2 = new ArrayList();
                        }
                        a2.add(mat);
                        break;
                    case 3:
                        if (a3 == null) {
                            a3 = new ArrayList();
                        }
                        a3.add(mat);
                        break;
                    case 4:
                        if (a4 == null) {
                            a4 = new ArrayList();
                        }
                        a4.add(mat);
                        break;
                    case 5:
                        if (a5 == null) {
                            a5 = new ArrayList();
                        }
                        a5.add(mat);
                        break;
                    case 6:
                        if (a6 == null) {
                            a6 = new ArrayList();
                        }
                        a6.add(mat);
                        break;
                    case 7:
                        if (a7 == null) {
                            a7 = new ArrayList();
                        }
                        a7.add(mat);
                        break;
                    case 8:
                        if (a8 == null) {
                            a8 = new ArrayList();
                        }
                        a8.add(mat);
                        break;
                }
            }
            req.setA1(a1);
            req.setA2(a2);
            req.setA3(a3);
            req.setA4(a4);
            req.setA5(a5);
            req.setA6(a6);
            req.setA7(a7);
            req.setA8(a8);
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return req;
    }

    @Override
    public void guardarIdea(Idea d) {
        int id = d.getIdentificador(), estudiantesxEquipo = d.getNroEstudiantesxEquipo();
        int totalEquipos = d.getNroEquipos();
        String titulo = d.getTitulo(), descripcion = d.getDescripcion(), sql;
        Persona avalador = d.getAvalador();
        List<Persona> postulante = d.getPostulante();
        String fecha = d.getFecha().toString();
        List<String> requisitos = d.getRequisitos().getAllCodigosRequisitos();
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            Statement s = conexion.createStatement();
            InterfacePersonaDao persona = new PersonaDao();
            persona.guardarNuevaPersona(conexion, avalador);
            for (Persona post : postulante) {
                persona.guardarNuevaPersona(conexion, post);
                sql = "INSERT INTO `Postulante_has_Idea` (`Persona_idPersona`, `Idea_Identificador`) VALUES (" + post.getIdPersona() + "," + id + ")";
                s.executeUpdate(sql);
            }
            sql = "INSERT INTO `Idea` (`Identificador`, `titulo`, `Descripcion`, `Fecha_creacion`, `NroEstudiantesxEquipo`, `NroEquipos`, `Persona_avalador_idPersona`)VALUES (" + id + ",\"" + titulo + "\",\"" + descripcion + "\",\"" + fecha + "\"," + estudiantesxEquipo + "," + totalEquipos + "," + avalador.getIdPersona() + ")";
            s.executeUpdate(sql);
            for (String requisito : requisitos) {
                sql = "INSERT INTO `Prerequisito` (`Idea_Identificador`, `Codigo_Materia`)VALUES (" + id + "," + requisito + ")";
                s.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void guardarOferta(Idea d, String semestre) {
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            String sql = "INSERT INTO `Oferta_semestre` (`Idea_Identificador`, `Semestre`, `Disponibilidad`)VALUES (" + d.getIdentificador() + "," + semestre + "," + d.getDisponibilidad() + ")";
            Statement s = conexion.createStatement();
            s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
