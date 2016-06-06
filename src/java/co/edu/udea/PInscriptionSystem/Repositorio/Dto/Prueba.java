/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

import co.edu.udea.PInscriptionSystem.Repositorio.Dao.*;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.IdeaDao;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public class Prueba {
    public static void main (String [] arg ) {
        InterfaceIdeaDao x = new IdeaDao();
        List<Idea> prueba = x.getOfertaSemestre("20161");
        Idea prueba2 = x.getIdeaByID(2);
        System.out.println(prueba2.getAvalador().correo);
        for (int i=0; i<prueba.size(); i++) {
            System.out.println (prueba.get(i).getIdentificador());
            System.out.println (prueba.get(i).getTitulo());
            System.out.println (prueba.get(i).getRequisitos().getA4());
        }
    }
    
}
