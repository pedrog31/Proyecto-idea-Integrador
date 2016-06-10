/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

import co.edu.udea.PIncriptionSystem.Simula_Mares.Estudiante_Mares;
import co.edu.udea.PIncriptionSystem.Simula_Mares.Simulacion;
import co.edu.udea.PInscriptionSystem.Dominio.Valida_Requerimiento;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.*;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.IdeaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.InscritosDao;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public class Prueba {
    public static void main (String [] arg ) throws ParseException {
        InterfaceInscritosDao  in = new InscritosDao();
        Inscripcion inscripcion = new Inscripcion (5, 1, 20161, "Aprobado");
        List<Estudiante> estudiantes = new ArrayList();
        estudiantes.add(new Estudiante(1034, "pedro", "sjjisa"));
        estudiantes.add(new Estudiante(1035, "pedro", "sjjisa"));
        estudiantes.add(new Estudiante(1056, "pedro", "sjjisa"));
        inscripcion.setInscritos(estudiantes);
        in.generarInscripcion(inscripcion);
    }
    
}
