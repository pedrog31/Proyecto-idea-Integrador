/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Dominio;

import co.edu.udea.PIncriptionSystem.Simula_Mares.Estudiante_Mares;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Materia;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public class Valida_Requerimiento {

    public boolean validaPrerequisitos(List<Materia> prerequisitos, List<Materia> historia) {
        boolean flag = false;
        for (Materia p : prerequisitos) {
            for (Materia h : historia) {
                if (p.equals(h)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                flag = false;
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean validaCreditos (Estudiante_Mares e) {
        int creditos = e.getCreditos();
        return creditos > 100;
    }
    
    

}
