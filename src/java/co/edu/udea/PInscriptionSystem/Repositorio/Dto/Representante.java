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
public class Representante extends Persona{
        public Representante (int idPersona, String nombre, String correo) {
        super(idPersona, nombre, correo);
    }

    @Override
    public String getRol() {
        return "Representante";
    }

    @Override
    public String getTipo() {
        return "natural";
    }
}
