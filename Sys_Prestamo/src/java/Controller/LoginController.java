/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import DTO.PersonaDTO;
import DTO.UsuarioDTO;
import config.conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LEANDRO
 */
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    UsuarioDAO aO = new UsuarioDAO();

    UsuarioDTO tr = new UsuarioDTO();
    PersonaDTO ud = new PersonaDTO();

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
        String op = request.getParameter("act");
        RequestDispatcher dispatcher;
        try {
            dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            switch (op) {
                case "in":
                    dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "out":
                    Connection cn = conexion.cerrar();
                    if (cn == null) {
                        dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        dispatcher = getServletContext().getRequestDispatcher("/tools/files/error.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
            }
        } catch (ServletException | IOException e) {
            dispatcher = getServletContext().getRequestDispatcher("/tools/files/error.jsp");
            dispatcher.forward(request, response);
            System.out.println("Error Servlet login " + e);
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
        String pagina = "";
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        if (user.equals("") && pass.equals("")) {
            pagina = "/login.jsp";
            dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        } else {
            List<PersonaDTO> p = aO.validar(user, pass);
            if (p.size() > 0) {
                session.setAttribute("lista", p);
                pagina = "/index.jsp";
                dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            } else {
                pagina = "/login.jsp";
                dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
        }
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
