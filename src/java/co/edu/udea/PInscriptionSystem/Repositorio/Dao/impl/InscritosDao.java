/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl;

import co.edu.udea.PInscriptionSystem.Repositorio.Dao.Dao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.InterfaceInscritosDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Inscripcion;
import java.sql.Connection;
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
public class InscritosDao implements InterfaceInscritosDao {

    private Dao dao;

    public InscritosDao() {
        this.dao = new Dao();
    }

    @Override
    public List<Inscripcion> getAllInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList();
        Inscripcion i;
        try {
            dao.conectar();
            Connection conexion = dao.getConexion();
            Statement s = conexion.createStatement();
            String sql;
        } catch (SQLException ex) {
            Logger.getLogger(InscritosDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InscritosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inscripciones;
    }

    @Override
    public Inscripcion getInscripcionByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generarInscripcion(Inscripcion ins) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
