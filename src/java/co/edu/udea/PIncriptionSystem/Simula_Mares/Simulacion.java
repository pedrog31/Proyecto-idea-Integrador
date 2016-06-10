package co.edu.udea.PIncriptionSystem.Simula_Mares;

import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Materia;
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mario
 */
public final class Simulacion {

    public Simulacion () {
        this.agregarMaterias();
        this.llenarlista();
    }
    
    private final Materia mat1 = new Materia("ANA. Y DISEÑ. DE SIST. II", 2508417);
    private final Materia mat2 = new Materia("ETICA PROFESIONAL", 2505562);
    private final Materia mat3 = new Materia("INTRO A LA ING DE SISTEMA", 2508102);
    private final Materia mat4 = new Materia("PROYECTO INTEGRADOR I", 2508103);
    private final Materia mat5 = new Materia("FISICA MECANICA", 2536200);
    private final Materia mat6 = new Materia("ARGUMENTACION Y LECTOESCR", 2508263);
    private final Materia mat7 = new Materia("LOGI Y REPRESENTACION III", 2508305);
    private final Materia mat8 = new Materia("BASES DE DATOS Y LABORATO", 2508525);
    private final Materia mat9 = new Materia("ARQUITECTURA DEL SOFTWARE", 2508585);
    private final Materia mat10 = new Materia("METODOS ESTADISTICOS", 2508613);
    private final Materia mat11 = new Materia("TEORIA DE LA PROB Y COLAS", 2508325);
    private final Materia mat12 = new Materia("GEOMET VECTORIAL Y ANALIT", 2555120);
    private final Materia mat13 = new Materia("ALGEBRA LINEAL", 2555220);
    private final Materia mat14 = new Materia("SISTEM OPERAT Y LABORATOR", 2508485);
    private final Materia mat15 = new Materia("ESTR FIS DE LA INF Y LABO", 2508425);
    private final Materia mat16 = new Materia("FUND SIST DE INFORMACION", 2508633);

    private final Materia[] vecmat1 = {mat1, mat9, mat16, mat4, mat6, mat12};
    private final Materia[] vecmat2 = {mat5, mat2, mat4, mat11, mat14, mat7, mat3};
    private final Materia[] vecmat3 = {mat9, mat1, mat5, mat14, mat8};
    private final Materia[] vecmat4 = {mat13, mat15, mat12, mat4};
    private final Materia[] vecmat5 = {mat6, mat9, mat1, mat9, mat15, mat2, mat13};
    private final Materia[] vecmat6 = {mat1, mat2, mat8, mat4};
    private final Materia[] vecmat7 = {mat6, mat5, mat4, mat9, mat14};
    private final Materia[] vecmat8 = {mat8, mat6, mat4};
    private final Materia[] vecmat9 = {mat16, mat3, mat9, mat7, mat14};
    private final Materia[] vecmat10 = {mat5, mat1, mat4};

    Estudiante_Mares est1 = new Estudiante_Mares(120, "mateo.gomez", "contra1", "1026542158", "Mateo Gómez Acosta");
    Estudiante_Mares est2 = new Estudiante_Mares(122, "jorge.robledo", "contra2", "1015953204", "Jorge Antonia Robledo Mesa");
    Estudiante_Mares est3 = new Estudiante_Mares(110, "angelica.restrepo", "contra3", "1102504963", "Angélica Restrepo Sánchez");
    Estudiante_Mares est4 = new Estudiante_Mares(112, "ana.garcia", "contra4", "1224306975", "Ana maría García Fernández");
    Estudiante_Mares est5 = new Estudiante_Mares(102, "luisa.trujullo", "contra5", "102124675", "Luisa Trujillo Higuita ");
    Estudiante_Mares est6 = new Estudiante_Mares(100, "antonio.lopez", "contra6", "1030485216", "Antonio López Márquez");
    Estudiante_Mares est7 = new Estudiante_Mares(126, "juan.restrepo", "contra7", "1186204370", "Juan David Restrepo Upegui");
    Estudiante_Mares est8 = new Estudiante_Mares(98, "juan.valencia", "contra8", "1163328045", "Juan Carlos Valencia Berrio");
    Estudiante_Mares est9 = new Estudiante_Mares(45, "ana.moreno", "contra9", "1217496824", "Ana Isabel Moreno García");
    Estudiante_Mares est10 = new Estudiante_Mares(130, "esteban.noreña", "contra10", "1223069751", "Esteban Noreña Acosta");

    List<Estudiante_Mares> listaestudiantes = new ArrayList();

    public void agregarMaterias() {
        est1.setVect(vecmat1);
        est2.setVect(vecmat2);
        est3.setVect(vecmat3);
        est4.setVect(vecmat4);
        est5.setVect(vecmat5);
        est6.setVect(vecmat6);
        est7.setVect(vecmat7);
        est8.setVect(vecmat8);
        est9.setVect(vecmat9);
        est10.setVect(vecmat10);
    }

    public void llenarlista() {
        listaestudiantes.add(est1);
        listaestudiantes.add(est2);
        listaestudiantes.add(est3);
        listaestudiantes.add(est4);
        listaestudiantes.add(est5);
        listaestudiantes.add(est6);
        listaestudiantes.add(est7);
        listaestudiantes.add(est8);
        listaestudiantes.add(est9);
        listaestudiantes.add(est10);
    }
    
    public List<Estudiante_Mares> getlistaestudiantes() {
        return listaestudiantes;
    }
    
}
