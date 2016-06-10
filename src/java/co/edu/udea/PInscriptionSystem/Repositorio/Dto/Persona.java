/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

/**
 * @version 1.0
 * @author PedroGallego
 */
public abstract class Persona {
    private int idPersona;
    private String nombre,correo;
    
    /**
     * @param idPersona identificacion de la persona puede ser cedula, ti, pasaporte o CE
     * @param nombre nombre completo de la persona
     * @param correo correo electronico de la persona
     */
    public Persona(int idPersona, String nombre, String correo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public abstract String getRol ();
    
    public abstract String getTipo ();
    
}
