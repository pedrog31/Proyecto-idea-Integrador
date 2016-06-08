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

    public List<String> getAllCodigosRequisitos() {
        List<String> codigos = new ArrayList();
        if (a1 != null) {
            for (Materia mat : a1) {
                codigos.add(mat.getCodigo() + "");
            }
        }
        if (a2 != null) {
            for (Materia mat : a2) {
                codigos.add(mat.getCodigo() + "");
            }
        }
        if (a3 != null) {
            for (Materia mat : a3) {
                codigos.add(mat.getCodigo() + "");
            }
        }
        if (a4 != null) {
            for (Materia mat : a4) {
                codigos.add(mat.getCodigo() + "");
            }
        }
        if (a5 != null) {
            for (Materia mat : a5) {
                codigos.add(mat.getCodigo() + "");
            }
        }
        if (a6 != null) {
            for (Materia mat : a6) {
                codigos.add(mat.getCodigo() + "");
            }
        }
        if (a7 != null) {
            for (Materia mat : a7) {
                codigos.add(mat.getCodigo() + "");
            }
        }
        if (a8 != null) {
            for (Materia mat : a8) {
                codigos.add(mat.getCodigo() + "");
            }
        }
        return codigos;
    }

}
