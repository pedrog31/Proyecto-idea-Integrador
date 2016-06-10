/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PIncriptionSystem.Simula_Mares;

import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Materia;
import java.util.List;

/**
 *
 * @author Pedro Gallego
 */
public interface Interface_Mares_facade {
    
    public List<Materia> getHistoria (String id);
    
    public boolean ValidarUsuario(String usuario, String contraeña);
    
    public Estudiante_Mares getEstudiante (String id);
    
}
