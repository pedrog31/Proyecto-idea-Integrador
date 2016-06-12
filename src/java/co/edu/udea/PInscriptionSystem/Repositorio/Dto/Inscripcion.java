/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

import co.edu.udea.PIncriptionSystem.Simula_Mares.Estudiante_Mares;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public class Inscripcion {
    private List<Estudiante> inscritos;
    private int idIdea, radicado,semestre;
    private String estado;

    public Inscripcion(int idIdea, int radicado, int semestre, String estado) {
        this.idIdea = idIdea;
        this.radicado = radicado;
        this.semestre = semestre;
        this.estado = estado;
    }

    public List<Estudiante> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Estudiante> inscritos) {
        this.inscritos = inscritos;
    }

    public int getIdIdea() {
        return idIdea;
    }

    public void setIdIdea(int idIdea) {
        this.idIdea = idIdea;
    }

    public int getRadicado() {
        return radicado;
    }

    public void setRadicado(int radicado) {
        this.radicado = radicado;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
