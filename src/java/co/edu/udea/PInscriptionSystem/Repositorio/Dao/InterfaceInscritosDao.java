/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao;

import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Inscripcion;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public interface InterfaceInscritosDao {
    
    public List<Inscripcion> getAllInscripciones ();
    
    public Inscripcion getInscripcionByID (int id);
    
    public void generarInscripcion (Inscripcion ins);    
}
