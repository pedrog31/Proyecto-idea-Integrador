/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Controlador;

import co.edu.udea.PIncriptionSystem.Simula_Mares.Estudiante_Mares;
import co.edu.udea.PIncriptionSystem.Simula_Mares.Interface_Mares_facade;
import co.edu.udea.PIncriptionSystem.Simula_Mares.Mares_Facade;
import co.edu.udea.PInscriptionSystem.Dominio.Valida_Requerimiento;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.InterfaceIdeaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.IdeaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.InscritosDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Estudiante;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Idea;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Inscripcion;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PedroGallego
 */
@WebServlet(name = "Prerrequisitos", urlPatterns = {"/Prerrequisitos"})
public class Prerrequisitos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
            
            Valida_Requerimiento valre1 = new Valida_Requerimiento();
            Valida_Requerimiento valre2 = new Valida_Requerimiento();
            Valida_Requerimiento valre3 = new Valida_Requerimiento();
            /*Object c = request.getAttribute("value_radio");
            String x = c.toString();*/
            
            int codigo = Integer.parseInt((String)request.getSession().getAttribute("value_radio"));//Integer.parseInt(x);
            int semestre = Integer.parseInt((String)request.getSession().getAttribute("semestre"));
  
            IdeaDao idao = new IdeaDao();
            
            Idea idea = idao.getIdeaByID(codigo);
            
            String usuario1 = request.getParameter("u1");
            String clave1 = request.getParameter("c1");
            String usuario2 = request.getParameter("u2");
            String clave2 = request.getParameter("c2");
            String usuario3 = request.getParameter("u3");
            String clave3 = request.getParameter("c3");
            
            InscritosDao inscri = new InscritosDao();
            Inscripcion ins = new Inscripcion(codigo, inscri.contarRegistros()+1, semestre, "aprobada");
            
           
            Interface_Mares_facade val = new Mares_Facade();
            
            boolean validacion1 = val.ValidarUsuario(usuario1, clave1);
            boolean validacion2 = val.ValidarUsuario(usuario2, clave2);
            boolean validacion3 = val.ValidarUsuario(usuario3, clave3);
            
            
            Estudiante_Mares estu1 = val.getEstudiante(usuario1);
            Estudiante_Mares estu2 = val.getEstudiante(usuario2);
            Estudiante_Mares estu3 = val.getEstudiante(usuario3);
            
            List<Estudiante> lista = new ArrayList<Estudiante>();
            lista.add(new Estudiante(Integer.parseInt(estu1.getCedula()),estu1.getNombre(),""));
            lista.add(new Estudiante(Integer.parseInt(estu2.getCedula()),estu2.getNombre(),""));
            lista.add(new Estudiante(Integer.parseInt(estu3.getCedula()),estu3.getNombre(),""));
            ins.setInscritos(lista);
            
            boolean valcred1 = valre1.validaCreditos(estu1);
            boolean valcred2 = valre2.validaCreditos(estu2);
            boolean valcred3 = valre3.validaCreditos(estu3);
            
            List<Materia> histo1 = val.getHistoria(usuario1);
            List<Materia> histo2 = val.getHistoria(usuario2);
            List<Materia> histo3 = val.getHistoria(usuario3);
            
            boolean valpre1 = valre1.validaPrerequisitos(idea.getRequisitos().getAllRequisitos(), histo1);
            boolean valpre2 = valre2.validaPrerequisitos(idea.getRequisitos().getAllRequisitos(), histo2);
            boolean valpre3 = valre3.validaPrerequisitos(idea.getRequisitos().getAllRequisitos(), histo3);
            
            if(usuario1.isEmpty() || clave1.isEmpty() || usuario2.isEmpty() || clave2.isEmpty() || usuario3.isEmpty() || clave3.isEmpty()){
                response.sendRedirect("Formulario.jsp?error=Ingrese todos los datos");
            }else{
                if (validacion1 && validacion2 && validacion3){
                    if(valcred1 && valcred2 && valcred3){
                        if(valpre1 && valpre2 && valpre3){
                            
                            inscri.generarInscripcion(ins);
                            response.sendRedirect("Inscripciones.jsp");
                            
                        }else{
                            response.sendRedirect("Formulario.jsp?error=Uno o más de los integrantes no ha cursado los requisitos necesarios");
                        }                       
                    }else{
                        response.sendRedirect("Formulario.jsp?error=Uno o más de los integrantes tiene menos de 100 créditos");
                    }                  
                }else{
                    response.sendRedirect("Formulario.jsp?error=Nombre(s) de usuario o clave(s) incorrecta(s)");
                }
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
