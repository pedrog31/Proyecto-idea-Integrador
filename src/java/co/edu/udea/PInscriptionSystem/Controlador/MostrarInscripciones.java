/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Controlador;

import co.edu.udea.PInscriptionSystem.Repositorio.Dao.InterfaceIdeaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.InterfaceInscritosDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.IdeaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.InscritosDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Idea;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Inscripcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dani
 */
@WebServlet(name = "MostrarInscripciones", urlPatterns = {"/inscripciones"})
public class MostrarInscripciones extends HttpServlet {

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
        
        String semestre = request.getParameter("semestre");
        
        if (semestre == null) {
            request.getRequestDispatcher("/semestreInscripciones.jsp").forward(request, response);
        } else {
            InterfaceInscritosDao dao = new InscritosDao();
            InterfaceIdeaDao daoIdea = new IdeaDao();
            
            List<Inscripcion> inscripciones = dao.getAllInscripciones(semestre);
            List<String> ideas = new ArrayList<String>();
            
            for (Inscripcion inscripcion : inscripciones) {
                int aux = inscripcion.getIdIdea();
                ideas.add(daoIdea.getIdeaByID(aux).getTitulo());
            }
            
            request.setAttribute("inscripciones", inscripciones);
            request.setAttribute("ideas", ideas);
            
            request.getRequestDispatcher("/muestraInscripciones.jsp").forward(request, response);
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
