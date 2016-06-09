/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao;

import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Estudiante;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Persona;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public interface InterfacePersonaDao {

    public boolean guardarNuevaPersona(Connection c, Persona p);

    public List<Persona> getPostulantes(Connection c, int idIdea);
    
    public List<Estudiante> getInscritos (Connection c, int radicado);

    public Persona getAvalador(Connection c, int idavalador);

}
