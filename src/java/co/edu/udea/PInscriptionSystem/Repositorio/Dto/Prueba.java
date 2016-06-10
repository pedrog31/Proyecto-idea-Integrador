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
        Valida_Requerimiento v = new Valida_Requerimiento();
        Simulacion r = new Simulacion ();
        InterfaceIdeaDao i = new IdeaDao();
        Idea idea = i.getIdeaByID(5);
        Estudiante_Mares repositorio = r.getlistaestudiantes().get(7);
        Materia [] matRepo = repositorio.getVect();
        ArrayList matRepoList = new ArrayList<Materia>(Arrays.asList(matRepo));
        System.out.println(v.validaCreditos(repositorio));
        System.out.println(v.validaPrerequisitos(idea.getRequisitos().getAllRequisitos(),matRepoList));
        
    }
    
}
