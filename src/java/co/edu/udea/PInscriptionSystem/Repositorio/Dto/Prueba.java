/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

import co.edu.udea.PInscriptionSystem.Repositorio.Dao.*;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.IdeaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.InscritosDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public class Prueba {
    public static void main (String [] arg ) throws ParseException {
        InterfaceInscritosDao inscritos = new InscritosDao();
        Inscripcion i = inscritos.getInscripcionByRadicado(2);
        inscritos.generarInscripcion(i);
    }
    
}
