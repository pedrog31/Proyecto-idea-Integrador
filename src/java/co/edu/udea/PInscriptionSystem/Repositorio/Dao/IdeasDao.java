/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao;

import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Idea;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public interface IdeasDao {
    
    public List<Idea> getOfertaSemestre ();
    
    public Idea getIdeaByID ();
    
    
    
}
