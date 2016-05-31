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

    public List<Idea> getOfertaSemestre(String semestre) {
        List<Idea> ideas = null;
        Idea idea;
        int id, estudiantesxEquipo, disponibilidad, idavalador;
        String titulo, descripcion;
        Date fecha;
        List<Persona> postulante;
        Persona avalador;
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            Statement s = conexion.createStatement();
            ResultSet resIdeas = s.executeQuery("select Identificador, titulo, Descripcion, `Fecha creacion`, NroEstudiantesxEquipo, Disponibilidad, Persona_avalador_idPersona from Oferta_semestre inner join Idea   where (Semestre=" + semestre + ") and (identificador=Idea_identificador)");
            do {
                id = resIdeas.getInt(1);
                titulo = resIdeas.getString(2);
                descripcion = resIdeas.getString(3);
                fecha = resIdeas.getDate(4);
                estudiantesxEquipo = resIdeas.getInt(5);
                disponibilidad = resIdeas.getInt(6);
                idavalador = resIdeas.getInt(7);
                postulante = this.getPostulantes(s, id);
                avalador = this.getAvalador(s, idavalador);
                idea = new Idea (id,titulo,descripcion,fecha,estudiantesxEquipo,disponibilidad, postulante, avalador);
            } while (resIdeas.next());
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ideas;
    }

    public Persona getAvalador (Statement s, int idavalador) {
        try {
            ResultSet resAvalador = s.executeQuery("select Nombre, Correo from `Persona` where idPersona=" + idavalador);
            return new Persona (idavalador, resAvalador.getString(1), resAvalador.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Persona> getPostulantes(Statement s, int idIdea) {
        List<Persona> postulantes = null;
        Persona es = null;
        try {
            ResultSet resPostulante = s.executeQuery("select idPersona, Nombre, Correo, rol, Tipo, Representante_idPersona from Idea inner join Postulante_has_Idea on Idea_Identificador=identificador inner join Persona on Persona_idPersona=idPersona where identificador=" + idIdea);
            do {
                if (resPostulante.getString(4).equals("profesor"))
                    es = new Estudiante(resPostulante.getInt(1), resPostulante.getString(2), resPostulante.getString(3));
                else
                    if (resPostulante.getString(4).equals("estudiante"))
                        es = new Profesor(resPostulante.getInt(1), resPostulante.getString(2), resPostulante.getString(3));
                    else
                        if("juridica".equals(resPostulante.getString(5))) {
                            es = new Juridica (resPostulante.getInt(1), resPostulante.getString(2), resPostulante.getString(3));
                            int idRepresentante = resPostulante.getInt(6);
                            ResultSet resRepresentante = s.executeQuery("select Nombre, Correo from `Persona` where idPersona="+idRepresentante);
                            ((Juridica) es).setRepresentante(new Persona (idRepresentante,resRepresentante.getString(1),resRepresentante.getString(2)));
                        }
                if (es != null) postulantes.add(es);
            } while (resPostulante.next());
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return postulantes;
    }

}
