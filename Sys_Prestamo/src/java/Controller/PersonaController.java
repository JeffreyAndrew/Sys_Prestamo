/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PersonaDAO;
import DTO.PersonaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAT01
 */
public class PersonaController extends HttpServlet {

    private PersonaDAO pro = new PersonaDAO();

    String pagina;

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
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        String pag;
        HttpSession session = request.getSession(true);
        PersonaDTO u;
        List<PersonaDTO> lis = new ArrayList<>();
        int op = Integer.parseInt(request.getParameter("op"));
        switch (op) {
            case 1:
                pag = "/vistas/add_person/add_person.jsp";
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 3:
                int idRol = Integer.parseInt(request.getParameter("idrol"));
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellido");
                int dni = Integer.parseInt(request.getParameter("dni"));
                int celular = Integer.parseInt(request.getParameter("celular"));
                String correo = request.getParameter("correo");
                u = new PersonaDTO(idRol, nombre, apellidos, dni, celular, correo);
                int c = pro.create(u);
                if (c > 0) {
                    pag = "/index.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pag);
                    dispatcher.forward(request, response);
                } else {
                    pag = "/.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pag);
                    dispatcher.forward(request, response);
                }

                break;

        }
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
