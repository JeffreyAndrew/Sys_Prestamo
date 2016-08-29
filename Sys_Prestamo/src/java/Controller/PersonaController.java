/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PersonaDAO;
import DAO.UsuarioDAO;
import DTO.PersonaDTO;
import DTO.UsuarioDTO;
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
 * @author alum.fial1
 */
public class PersonaController extends HttpServlet {

    private static PersonaDAO aO = new PersonaDAO();
    private static UsuarioDAO uO = new UsuarioDAO();
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
//        try (PrintWriter out = response.getWriter()) {
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistas/usuario/listaru.jsp");
//            dispatcher.forward(request, response);
//        }
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
        String pag;
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);
        UsuarioDTO us = new UsuarioDTO();

        int op = Integer.parseInt(request.getParameter("op"));

        switch (op) {
            case 2:
                String id = request.getParameter("idpersona");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String dni = request.getParameter("dni");

                String idRol = request.getParameter("idRol");
                String celular = request.getParameter("celular");
                String facultad = request.getParameter("facultad");
                String escuela = request.getParameter("escuela");
                String correo = request.getParameter("correo");

                PersonaDTO u = new PersonaDTO(op, nombre, apellido, Integer.parseInt(dni), Integer.parseInt(idRol), facultad, escuela, op, correo);
                boolean r = aO.create(u);
                UsuarioDTO usu = new UsuarioDTO(Integer.parseInt(id), nombre, dni);
                boolean n = uO.create(usu);

                pag = "/ci?op=5";
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;

            case 6:
                pag = "/vistas/usuario/listaru.jsp";
                session.setAttribute("lista", uO.readall());
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;

            case 7:

                pag = "/ci?op=6";
                int id1 = Integer.parseInt(request.getParameter("id"));
                if (uO.delete(id1) == true) {
                    dispatcher = getServletContext().getRequestDispatcher(pag);
                    dispatcher.forward(request, response);
                } else {
                    out.println("Error al eliminar");
                }
                break;

            case 8:

               

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
