package co.edu.udea.PIncriptionSystem.Simula_Mares;


import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Materia;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario
 */
public class Estudiante_Mares {
    private int creditos;
    private String usuario,contraseña,cedula,nombre;
    private Materia[] vect;

    
    public Estudiante_Mares(int creditos, String usuario, String contraseña, String cedula, String nombre){
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.creditos = creditos;
        this.nombre = nombre;
        this.usuario = usuario;
        this.vect = vect;
    }

    /**
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the vect
     */
    public Materia[] getVect() {
        return vect;
    }

    /**
     * @param vect the vect to set
     */
    public void setVect(Materia[] vect) {
        this.vect = vect;
    }


    
    
}
