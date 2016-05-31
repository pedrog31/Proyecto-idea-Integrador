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
public class Idea {
    private int identificador, nroEstudiantesxEquipo, disponibilidad;
    private String titulo, descripcion;
    private Persona avalador;
    private List<Persona> postulante;

    public Idea(int identificador, int nroEstudiantesxEquipo, int nroEquipos, String titulo, String descripcion, Persona avalador, List<Persona> postulante) {
        this.identificador = identificador;
        this.nroEstudiantesxEquipo = nroEstudiantesxEquipo;
        this.disponibilidad = nroEquipos;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.avalador = avalador;
        this.postulante = postulante;
    }
    
    public Idea () {}

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getNroEstudiantesxEquipo() {
        return nroEstudiantesxEquipo;
    }

    public void setNroEstudiantesxEquipo(int nroEstudiantesxEquipo) {
        this.nroEstudiantesxEquipo = nroEstudiantesxEquipo;
    }

    public int getNroEquipos() {
        return disponibilidad;
    }

    public void setNroEquipos(int nroEquipos) {
        this.disponibilidad = nroEquipos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getAvalador() {
        return avalador;
    }

    public void setAvalador(Persona avalador) {
        this.avalador = avalador;
    }

    public List<Persona> getPostulante() {
        return postulante;
    }

    public void setPostulante(List <Persona> postulante) {
        this.postulante = postulante;
    }
    
    
    
}
