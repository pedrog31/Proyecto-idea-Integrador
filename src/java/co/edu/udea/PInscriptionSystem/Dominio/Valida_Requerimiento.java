/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Dominio;

import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Materia;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public class Valida_Requerimiento {
    
    public boolean validaPrerequisitos (List<Materia> prerequisitos, List<Materia> historia) {
        return true;
    }
}
