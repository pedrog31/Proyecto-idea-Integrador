/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PedroGallego
 */
public class Requisito {

    private List<Materia> a1, a2, a3, a4, a5, a6, a7, a8;
    private List<String> areas;

    public Requisito(List<String> areas) {
        this.areas = areas;
    }

    public List<Materia> getA1() {
        return a1;
    }

    public void setA1(List<Materia> a1) {
        this.a1 = a1;
    }

    public List<Materia> getA2() {
        return a2;
    }

    public void setA2(List<Materia> a2) {
        this.a2 = a2;
    }

    public List<Materia> getA3() {
        return a3;
    }

    public void setA3(List<Materia> a3) {
        this.a3 = a3;
    }

    public List<Materia> getA4() {
        return a4;
    }

    public void setA4(List<Materia> a4) {
        this.a4 = a4;
    }

    public List<Materia> getA5() {
        return a5;
    }

    public void setA5(List<Materia> a5) {
        this.a5 = a5;
    }

    public List<Materia> getA6() {
        return a6;
    }

    public void setA6(List<Materia> a6) {
        this.a6 = a6;
    }

    public List<Materia> getA7() {
        return a7;
    }

    public void setA7(List<Materia> a7) {
        this.a7 = a7;
    }

    public List<Materia> getA8() {
        return a8;
    }

    public void setA8(List<Materia> a8) {
        this.a8 = a8;
    }

    public List<String> getAreas() {
        return areas;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    public List<Materia> getAllRequisitos() {
        List<Materia> materias = new ArrayList();
        if (a1 != null) materias.addAll(a1);
        if (a2 != null) materias.addAll(a2);
        if (a3 != null) materias.addAll(a3);
        if (a4 != null) materias.addAll(a4);
        if (a5 != null) materias.addAll(a5);
        if (a6 != null) materias.addAll(a6);
        if (a7 != null) materias.addAll(a7);
        if (a8 != null) materias.addAll(a8);
        return materias;
    }

    public List<List> getListasDeRequisitos() {
        List<List> salida = new ArrayList<List>();
        salida.add(this.a1);
        salida.add(this.a2);
        salida.add(this.a3);
        salida.add(this.a4);
        salida.add(this.a5);
        salida.add(this.a6);
        salida.add(this.a7);
        salida.add(this.a8);
        return salida;
    }
    
}
