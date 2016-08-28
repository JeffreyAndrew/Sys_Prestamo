/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Det_EquipoDAO;
import DAO.EquipoDAO;
import DTO.Det_EquipoDTO;
import DTO.EquipoDTO;
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
 * @author CESAR
 */
public class EquipoController extends HttpServlet {

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
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet EquipoController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet EquipoController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        String pag;
        Det_EquipoDAO deqdao = new Det_EquipoDAO();
        HttpSession session = request.getSession(true);
        int ge = Integer.parseInt(request.getParameter("ge"));
        switch (ge) {
            case 1:
                pag = "/vistas/equipo/listar.jsp";
                session.setAttribute("lista", deqdao.especifiedreadall());
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 2:
                pag = "/vistas/equipo/registro.jsp";
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 3:
                pag = "/vistas/equipo/editar.jsp";
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 4:
                pag = "/ec?ge=1";
                int id = Integer.parseInt(request.getParameter("id"));
                if (deqdao.delete(id) == true) {
                    dispatcher = getServletContext().getRequestDispatcher(pag);
                    dispatcher.forward(request, response);
                } else {
                    out.println("Error al eliminar");
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
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        String pag;
        EquipoDTO eq = new EquipoDTO();
        Det_EquipoDTO deq = new Det_EquipoDTO();
        EquipoDAO eqdao = new EquipoDAO();
        Det_EquipoDAO deqdao = new Det_EquipoDAO();
        List<EquipoDTO> lista = new ArrayList();
        HttpSession session = request.getSession(true);
        int ge = Integer.parseInt(request.getParameter("ge"));
        switch (ge) {
            case 1:
                pag = "/vistas/equipo/listar.jsp";
                session.setAttribute("lista", deqdao.especifiedreadall());
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 5:
                pag = "/ec?ge=1";
                eq.setNombre(request.getParameter("nombre"));
                eq.setSerie(request.getParameter("serie"));
                eq.setTipo(request.getParameter("tipo"));
                lista = eqdao.especifiedread(eq);
                if (lista.isEmpty()) {
                    if (eqdao.create(eq) == true) {
                        lista = eqdao.especifiedread(eq);
                        eq = lista.get(0);
                        deq.setDescripcion(request.getParameter("descripcion"));
                        deq.setEstado("D");
                        deq.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                        deq.setIdEquipo(eq.getIdEquipo());
                        if (deqdao.create(deq) == true) {
                            pag = "/ec?ge=1";
                            dispatcher = getServletContext().getRequestDispatcher(pag);
                            dispatcher.forward(request, response);
                        } else {
                            out.println("Error al crear Det_equipo 1");
                        }
                    } else {
                        out.println("No se crea equipo");
                    }

                } else if (lista.size() == 1) {
                    eq = lista.get(0);
                    deq.setDescripcion(request.getParameter("descripcion"));
                    deq.setEstado("D");
                    deq.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                    deq.setIdEquipo(eq.getIdEquipo());
                    if (deqdao.create(deq) == true) {
                        dispatcher = getServletContext().getRequestDispatcher(pag);
                        dispatcher.forward(request, response);
                    } else {
                        out.println("Error al crear Det_equipo");
                    }
                }
                break;
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
