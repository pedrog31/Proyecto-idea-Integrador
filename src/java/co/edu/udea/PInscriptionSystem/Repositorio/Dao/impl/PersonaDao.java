/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl;

import co.edu.udea.PInscriptionSystem.Repositorio.Dao.InterfacePersonaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Estudiante;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Juridica;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Persona;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Profesor;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Representante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroGallego
 */
public class PersonaDao implements InterfacePersonaDao {

    @Override
    public Persona getAvalador(Connection c, int idavalador) {
        try {
            Statement s = c.createStatement();
            ResultSet resAvalador = s.executeQuery("select Nombre, Correo from `Persona` where idPersona=" + idavalador);
            resAvalador.next();
            return new Profesor(idavalador, resAvalador.getString(1), resAvalador.getString(2));
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
                    ((Juridica) es).setRepresentante(new Representante(idRepresentante, resRepresentante.getString(1), resRepresentante.getString(2)));
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
    public boolean guardarNuevaPersona(Connection c, Persona p) {
        try {
            Statement s = c.createStatement();
            String nombre = p.getNombre(), correo = p.getCorreo(), rol = p.getRol(), tipo = p.getTipo();
            int id = p.getIdPersona(), idRepresentante;
            String sql = null;
            try {
                idRepresentante = Integer.parseInt(tipo);
                guardarNuevaPersona(c, ((Juridica) p).getRepresentante());
                sql = "INSERT INTO `Persona` (`idPersona`, `Nombre`, `Correo`, `Rol`, `Tipo`, `Representante_idPersona`) VALUES (" + id + ",`" + nombre + "`,`" + correo + "`,`" + rol + "`," + "`Juridica`," + idRepresentante + ")";
            } catch (Exception e) {
                sql = "INSERT INTO `Persona` (`idPersona`, `Nombre`, `Correo`, `Rol`, `Tipo`, `Representante_idPersona`) VALUES (" + id + ",`" + nombre + "`,`" + correo + "`,`" + rol + "`,`" + tipo + "`,null)";
            } finally {
                s.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public List<Estudiante> getInscritos(Connection c, int radicado) {
        List<Estudiante> estudiantes = new ArrayList();
        Estudiante es = null;
        try {
            Statement s = c.createStatement();
            String sql = "select Persona.`idPersona`, Persona.`Nombre`, Persona.`Correo` from `Inscripcion` inner join `Persona_has_Inscripcion` inner join `Persona` on Radicado=Inscripcion_Radicado and `Persona_idPersona`=Persona.`idPersona` where Radicado =" + radicado;
            ResultSet resPostulante = s.executeQuery(sql);
            while (resPostulante.next()) {
                es = new Estudiante(resPostulante.getInt(1), resPostulante.getString(2), resPostulante.getString(3));
                estudiantes.add(es);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdeaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estudiantes;
    }
}
