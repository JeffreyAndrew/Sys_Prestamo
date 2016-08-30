/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import DTO.PersonaDTO;
import DTO.UsuarioDTO;
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
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
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
        
        /*PrintWriter out = response.getWriter();
        String a, b, pagina;
        HttpSession session = request.getSession(true);
        a = request.getParameter("usuario");
        b = request.getParameter("password");
        String sql;
    
        
        
        sql = " SELECT rol.idRol"+ " from rol, persona"+" WHERE rol.idRol= persona.idRol";
//        
//        PersonaDTO ud = new PersonaDTO();
        if (!a.equals("") && !b.equals("")) {
         ud = aO.validar(a, b);
            if (ud!=null) {
                if(sql=="1" || sql=="2" ){
                    pagina = "/index.jsp";

                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    
                }
                else{
                    pagina = "/login.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
                }

//            switch (sql) {
//                case "1": {
//
//                    pagina = "/index.jsp";
//
//                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
//                    dispatcher.forward(request, response);
//                    break;
//                }
//                case "2": {
//                    pagina = "/index.jsp";
//
//                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
//                    dispatcher.forward(request, response);
//                    break;
//                }
//                default:
//                    System.out.println("usted no tiene acceso por ser docente");
//                    break;
//            }

            } else {
                pagina = "/login.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);

            }
        } else {
            pagina = "/login.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }*/
        
        
        
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
