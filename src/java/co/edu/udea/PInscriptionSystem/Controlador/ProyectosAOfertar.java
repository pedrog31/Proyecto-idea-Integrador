/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Controlador;

import co.edu.udea.PInscriptionSystem.Repositorio.Dao.InterfaceIdeaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dao.impl.IdeaDao;
import co.edu.udea.PInscriptionSystem.Repositorio.Dto.Idea;
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
@WebServlet(name = "ProyectosAOfertar", urlPatterns = {"/ofertar"})
public class ProyectosAOfertar extends HttpServlet {

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
        
        String ideas[] = request.getParameterValues("add");
        if (ideas != null && ideas.length != 0) {
            InterfaceIdeaDao dao = new IdeaDao();
            List<Idea> listaIdeas = new ArrayList<Idea>();
            for (int i = 0; i < ideas.length; i++) {
                Idea aux = dao.getIdeaByID(Integer.parseInt(ideas[i]));
                listaIdeas.add(aux);
            }
            System.out.println("hola");
            request.setAttribute("listaIdeas", listaIdeas);
        
            request.getRequestDispatcher("/ideas.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/ideas.jsp").forward(request, response);
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
