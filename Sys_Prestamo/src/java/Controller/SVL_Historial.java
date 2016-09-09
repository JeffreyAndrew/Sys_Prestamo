/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.HistorialDAO;
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
 * @author Igor
 */
public class SVL_Historial extends HttpServlet {
      // private PersonaDAO pro = new PersonaDAO();
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
        HistorialDAO HistoEqui = new HistorialDAO();
        PersonaDTO u;
        List<PersonaDTO> lis = new ArrayList<>();
       // Det_EquipoDAO HistoEqui = new Det_EquipoDAO();
        HttpSession session = request.getSession(true);
        int histo = Integer.parseInt(request.getParameter("histo"));
        switch (histo) {
            case 1:
                pag = "/vistas/historial/HistoProduct.jsp";
                session.setAttribute("lista", HistoEqui.listarHistoProduct());
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 2:
               // int idpersona=Integer.parseInt(request.getParameter("idpersona"));
               //  List<PersonaDTO> p = pro.read(idpersona);
                pag = "/vistas/historial/HistoDocent.jsp";
                
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
              
                break;
                
              
            case 3:
                pag = "/vistas/historial/HistoGeneral.jsp";
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
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
