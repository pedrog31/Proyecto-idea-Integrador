/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl;

import co.edu.udea.PInscriptionSystem.Repositorio.Dao.Dao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.InterfaceInscritosDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.InterfacePersonaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Estudiante;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Inscripcion;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroGallego
 */
public class InscritosDao implements InterfaceInscritosDao {

    private Dao dao;

    public InscritosDao() {
        this.dao = new Dao();
    }

    @Override
    public List<Inscripcion> getAllInscripciones(String sem) {
        List<Inscripcion> inscripciones = new ArrayList();
        Inscripcion inscripcion;
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            Statement s = conexion.createStatement();
            int idIdea, radicado, semestre;
            String estado, sql;
            ResultSet resultInscripcion;
            List<Estudiante> estudiantes;
            if (sem != null) {
                sql = "select `Radicado`, `Estado`, `Oferta_semestre_Idea_Identificador`, `Oferta_semestre_Semestre` from Inscripcion where `Oferta_semestre_Semestre` =" + sem;
                resultInscripcion = s.executeQuery(sql);
            } else {
                sql = "select `Radicado`, `Estado`, `Oferta_semestre_Idea_Identificador`, `Oferta_semestre_Semestre` from Inscripcion";
                resultInscripcion = s.executeQuery(sql);
            }
            while (resultInscripcion.next()) {
                idIdea = resultInscripcion.getInt(3);
                radicado = resultInscripcion.getInt(1);
                semestre = resultInscripcion.getInt(4);
                estado = resultInscripcion.getString(2);
                InterfacePersonaDao per = new PersonaDao();
                estudiantes = per.getInscritos(conexion, radicado);
                inscripcion = new Inscripcion(idIdea, radicado, semestre, estado);
                inscripcion.setInscritos(estudiantes);
                inscripciones.add(inscripcion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscritosDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InscritosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inscripciones;
    }

    @Override
    public Inscripcion getInscripcionByRadicado(int radicado) {
        Inscripcion inscripcion = null;
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            Statement s = conexion.createStatement();
            int idIdea, semestre;
            String estado, sql;
            ResultSet resultInscripcion;
            List<Estudiante> estudiantes;
            sql = "select `Estado`, `Oferta_semestre_Idea_Identificador`, `Oferta_semestre_Semestre` from Inscripcion where Radicado =" + radicado;
            resultInscripcion = s.executeQuery(sql);
            resultInscripcion.next();
            idIdea = resultInscripcion.getInt(2);
            semestre = resultInscripcion.getInt(3);
            estado = resultInscripcion.getString(1);
            InterfacePersonaDao per = new PersonaDao();
            estudiantes = per.getInscritos(conexion, radicado);
            inscripcion = new Inscripcion(idIdea, radicado, semestre, estado);
            inscripcion.setInscritos(estudiantes);
        } catch (SQLException ex) {
            Logger.getLogger(InscritosDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InscritosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inscripcion;
    }

    @Override
    public void generarInscripcion(Inscripcion ins) {
        String estado = ins.getEstado(), sql;
        int idIdea = ins.getIdIdea();
        int radicado = ins.getRadicado();
        int semestre = ins.getSemestre();
        List<Estudiante> estudiantes = ins.getInscritos();
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            Statement s = conexion.createStatement();
            InterfacePersonaDao persona = new PersonaDao();
            sql = "INSERT INTO `Inscripcion` (`Radicado`, `Estado`, `Oferta_semestre_Idea_Identificador`, `Oferta_semestre_Semestre`) VALUES (" + radicado + ",\"" + estado + "\"," + idIdea + "," + semestre + ")";
            System.out.println(sql);
            s.executeUpdate(sql);
            for (Estudiante e : estudiantes) {
                persona.guardarNuevaPersona(conexion,e);
                sql = "INSERT INTO `Persona_has_Inscripcion` (`Persona_idPersona`, `Inscripcion_Radicado`) VALUES ("+e.getIdPersona()+","+radicado+")";
                s.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
