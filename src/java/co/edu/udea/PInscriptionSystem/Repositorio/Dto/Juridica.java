/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

/**
 *
 * @author PedroGallego
 */
public class Juridica  extends Persona{
    private Representante representante = null;
    
    public Juridica(int idPersona, String nombre, String correo) {
        super(idPersona, nombre, correo);
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    @Override
    public String getRol() {
        return null;
    }

    @Override
    public String getTipo() {
        return ((Integer)representante.getIdPersona()).toString();
    }
}
