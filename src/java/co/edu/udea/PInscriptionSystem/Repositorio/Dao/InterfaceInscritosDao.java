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
    
    public List<Inscripcion> getAllInscripciones (String semestre);
    
    public Inscripcion getInscripcionByRadicado (int radicado);
    
    public void generarInscripcion (Inscripcion ins);    
}
