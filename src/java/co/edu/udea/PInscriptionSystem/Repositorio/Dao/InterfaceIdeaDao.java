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
    
    public List<Persona> getPostulantes (Connection c,int idIdea);
    
    public Persona getAvalador (Connection c,int idavalador);
    
    public Requisito getRequisitos (Connection c, int idIdea);
    
    public boolean guardarIdea (Idea d,String semestre);
    
    public boolean guardarNuevaPersona (Connection c,Persona p);
}
