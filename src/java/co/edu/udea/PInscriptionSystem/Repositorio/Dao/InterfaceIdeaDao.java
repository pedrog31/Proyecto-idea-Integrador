/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao;

import co.edu.udea.PInscriptionSystem.Repositorio.Dto.*;
import java.sql.*;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public interface InterfaceIdeaDao {
    
    public List<Idea> getOfertaSemestre (String semestre);
    
    public Idea getIdeaByID (int id);
        
    public Requisito getRequisitos (Connection c, int idIdea);
    
    public void guardarIdea (Idea d);
    
    public void guardarOferta (Idea d,String semestre);
}
