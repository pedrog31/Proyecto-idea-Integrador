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
public class EstPost extends Persona{
    public EstPost(int idPersona, String nombre, String correo) {
        super(idPersona, nombre, correo);
    }

    @Override
    public String getRol() {
        return "Estudiante";
    }

    @Override
    public String getTipo() {
        return "Natural";
    }
    
}
