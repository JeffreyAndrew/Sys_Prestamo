/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PersonaDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class MainController extends HttpServlet {

    PersonaDAO pD = new PersonaDAO();
    UsuarioDAO aO = new UsuarioDAO();

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
        String pagina = "";
        int idpersona = 0;
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);
        int op = Integer.parseInt(request.getParameter("op"));
        System.out.println(op);
        try {
            switch (op) {
                case 1:
                    idpersona = Integer.parseInt(request.getParameter("id"));
                    pagina = "/vistas/prestamo/tprestamo.jsp";
                    session.setAttribute("ipersona", pD.read(idpersona));
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    break;
                case 2:
                    idpersona = Integer.parseInt(request.getParameter("id"));
                    session.setAttribute("lista", pD.read(idpersona));
                    pagina = "/index.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (NumberFormatException | ServletException | IOException e) {
            System.out.println("Error en el servlet main " + e);
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
