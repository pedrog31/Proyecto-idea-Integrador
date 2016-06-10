/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PIncriptionSystem.Simula_Mares;

import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Materia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pedro Gallego
 */
public class Mares_Facade implements Interface_Mares_facade {

    private Simulacion repositorio;

    public Mares_Facade() {
        repositorio = new Simulacion();
    }

    @Override
    public List<Materia> getHistoria(String id) {
        List<Materia> historia;
        Estudiante_Mares estudiante = this.getEstudiante(id);
        Materia[] materiasEnVector = estudiante.getVect();
        historia = new ArrayList<Materia>(Arrays.asList(materiasEnVector));
        return historia;
    }

    @Override
    public boolean ValidarUsuario(String usuario, String contraeña) {
        List<Estudiante_Mares> lista = repositorio.getlistaestudiantes();
        for (Estudiante_Mares estudiante : lista) {
            if (estudiante.getUsuario().equals(usuario) && estudiante.getContraseña().equals(contraeña)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Estudiante_Mares getEstudiante(String id) {
        List <Estudiante_Mares> estudiantes = repositorio.getlistaestudiantes();
        for (Estudiante_Mares estudiante:estudiantes) {
            if (estudiante.getCedula().equals(id)) return estudiante;
        }
        return null;
    }
}
