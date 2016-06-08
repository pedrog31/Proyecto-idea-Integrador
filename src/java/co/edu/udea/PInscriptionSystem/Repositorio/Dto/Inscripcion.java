/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

import java.util.List;

/**
 *
 * @author PedroGallego
 */
public class Inscripcion {
    private List<Estudiante> inscritos;
    private Idea idea;

    public Inscripcion(List<Estudiante> inscritos, Idea idea) {
        this.inscritos = inscritos;
        this.idea = idea;
    }

    public List<Estudiante> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Estudiante> inscritos) {
        this.inscritos = inscritos;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
    
    
    
}
