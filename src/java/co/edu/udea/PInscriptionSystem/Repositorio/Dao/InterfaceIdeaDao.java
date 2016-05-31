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
    
    public Idea getIdeaByID ();
    
    public List<Idea> getTotalLista ();
    
    public int getNideas (String semestre);
    
    public int getTotalIdeas ();
    
    public List<Persona> getPostulantes (Statement s,int idIdea);
    
    public Persona getAvalador (Statement s,int idavalador);
    
    
    
}
