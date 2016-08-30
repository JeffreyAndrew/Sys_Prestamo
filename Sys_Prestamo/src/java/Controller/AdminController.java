/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RolDAO;
import DTO.RolDTO;
import Interfaces.Operaciones;
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
public class AdminController extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        Operaciones rol = new RolDAO();
        String op = request.getParameter("op");
        String id = request.getParameter("id");
        RolDTO r = new RolDTO();
        RequestDispatcher dispatcher;
        String pagina = "";
        try {
            switch (op) {
                case "1":
                    // link
                    pagina = "/vistas/admin/admin.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    break;
                case "2":
                    // create rol
                    r.setRol(request.getParameter("rol_name"));
                    boolean result = rol.create(r);
                    if (result) {
                        out.print("true");
                    } else {
                        out.print("false");
                    }   break;
                case "3":
                    // listar rol
                    //session.setAttribute("List_rol", rol.readall());
                    for (int i = 0; i < rol.readall().size(); i++) {
                        RolDTO role = new RolDTO();
                        role = (RolDTO) rol.readall().get(i);
                        out.println("<tr>");
                        out.println("<td>" + role.getIdrol() + "</td>");
                        out.println("<td>" + role.getRol() + "</td>");
                        out.println("<td><a href=\"#\"  onclick=\"eliminar(" + role.getIdrol() + ")\" class=\" btn btn-xs btn-danger\">Eliminar</a> || <a href=\"#\"  onclick=\"editar(" + role.getIdrol() + ")\" class=\" btn btn-xs btn-warning\">Editar</a></td>");
                        out.println("</tr>");
                }   break;
                case "delete":
                {
                    // eliminar
                    boolean resul = rol.delete(Integer.parseInt(id));
                    if (resul) {
                        out.print("true");
                    } else {
                        out.print("false");
                }       break;
                    }
                case "edit":
                {
                    // editar
                    r.setRol(request.getParameter("rol_name"));
                    r.setIdrol(Integer.parseInt(id));
                    boolean resul = rol.update(r);
                    if (resul) {
                        out.print("true");
                    } else {
                        out.print("false");
                }       break;
                }
                case "list_id":
                    // get datos por id
                    Operaciones aO = new RolDAO();
                    RolDTO ro = (RolDTO) aO.read(Integer.parseInt(id));
                    String datos = "<span class=\"input-group-addon\"><i class=\"fa fa-user fa\" aria-hidden=\"true\"></i></span>"
                            + "<input type=\"hidden\" name=\"id\" id=\"id_rol\" value=\"" + ro.getIdrol() + "\">\n"
                            + "<input type=\"text\" class=\"form-control\" value=\"" + ro.getRol() + "\" name=\"rol_name\" placeholder=\"Nombre del rol\"/>";
                    out.print(datos);
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
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
