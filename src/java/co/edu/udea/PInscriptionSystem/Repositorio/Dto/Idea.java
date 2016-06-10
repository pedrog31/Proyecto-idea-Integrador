/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

import java.sql.*;
import java.util.List;

/**
 * @author PedroGallego
 */
public class Idea {

    private int identificador, nroEstudiantesxEquipo, disponibilidad, TotalEqupipos;
    private String titulo, descripcion;
    private Persona avalador;
    private List<Persona> postulante;
    private Date fecha;
    private Requisito requisitos;

    /**
     * 
     * @param identificador identifica unicamende cada idea
     * @param titulo titulo que el jefe de carrea 
     * @param descripcion
     * @param fecha
     * @param nroEstudiantesxEquipo
     * @param disponibilidad
     * @param totalEquipos
     * @param postulante
     * @param avalador 
     */
    public Idea(int identificador, String titulo, String descripcion, Date fecha, int nroEstudiantesxEquipo, int disponibilidad, int totalEquipos, List<Persona> postulante, Persona avalador) {
        this.identificador = identificador;
        this.nroEstudiantesxEquipo = nroEstudiantesxEquipo;
        this.disponibilidad = disponibilidad;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.avalador = avalador;
        this.postulante = postulante;
        this.fecha = fecha;
        this.TotalEqupipos = totalEquipos;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getTotalEqupipos() {
        return TotalEqupipos;
    }

    public void setTotalEqupipos(int TotalEqupipos) {
        this.TotalEqupipos = TotalEqupipos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Requisito getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Requisito requisitos) {
        this.requisitos = requisitos;
    }

    public Idea() {
    }

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

    public void setPostulante(List<Persona> postulante) {
        this.postulante = postulante;
    }

}
