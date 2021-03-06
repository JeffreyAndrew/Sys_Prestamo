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
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private UsuarioDAO uO = new UsuarioDAO();
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
        int op = Integer.parseInt(request.getParameter("op"));
        switch (op) {
            case 1:
                int idpr = Integer.parseInt(request.getParameter("id"));
                List<PersonaDTO> pta = pro.read(idpr);
                session.setAttribute("lista", pta);
                pag = "/vistas/persona/add_person.jsp";
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 2://perfil
                int id = Integer.parseInt(request.getParameter("id"));
                List<PersonaDTO> p = pro.read(id);
                session.setAttribute("lista", p);
                pag = "/vistas/persona/profile.jsp";
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
                String sexo=request.getParameter("sex");
                u = new PersonaDTO(idRol, nombre, apellidos, dni, celular, correo,sexo);
                int c = pro.add(u);
                if (idRol == 3) {
                    System.out.println(c);
                    pag = "/ci?op=2&id=" + c;
                    dispatcher = getServletContext().getRequestDispatcher(pag);
                    dispatcher.forward(request, response);
                } else {
                    UsuarioDTO d = new UsuarioDTO(c, nombre, String.valueOf(dni));
                    boolean m = uO.create(d);
                    if (m) {
                        pag = "/ci?op=2&id=" + c;
                        dispatcher = getServletContext().getRequestDispatcher(pag);
                        dispatcher.forward(request, response);
                    } else {
                        pag = "/tools/files/error.jsp";
                        dispatcher = getServletContext().getRequestDispatcher(pag);
                        dispatcher.forward(request, response);
                    }
                }
                break;
            case 4:
                pag = "/vistas/usuario/listaru.jsp";
                session.setAttribute("lista", uO.readall());
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 5:
                pag = "/ci?op=4";
                int id1 = Integer.parseInt(request.getParameter("id"));
                if (uO.delete(id1) == true) {
                    dispatcher = getServletContext().getRequestDispatcher(pag);
                    dispatcher.forward(request, response);
                } else {
                    out.println("Error al eliminar");
                }
                break;
            case 6:
                int idp = Integer.parseInt(request.getParameter("id"));
                List<PersonaDTO> pt = pro.read(idp);
                session.setAttribute("lista", pt);
                pag = "/vistas/persona/list.jsp";
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
        int op = Integer.parseInt(request.getParameter("op"));
        String pagina = "", nombre = "", apellidos = "", correo = "";
        int dni = 0, celular = 0, id = 0;
        boolean resp = false;
        int idRol = 0;
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);
        try {
            switch (op) {
                case 1:
                    id = Integer.parseInt(request.getParameter("id"));
                    idRol = Integer.parseInt(request.getParameter("idrol"));
                    nombre = request.getParameter("name");
                    apellidos = request.getParameter("last");
                    dni = Integer.parseInt(request.getParameter("dni"));
                    celular = Integer.parseInt(request.getParameter("phone"));
                    correo = request.getParameter("mail");
                    PersonaDTO P = new PersonaDTO(id, idRol, nombre, apellidos, dni, celular, correo);
                    boolean a = pro.update(P);
                    break;
                case 2://update user
                    System.out.println("llega");
                    String us = request.getParameter("user");
                    String ps = request.getParameter("pass");
                    System.out.println(us);
                    System.out.println(ps);
                    int m = Integer.parseInt(request.getParameter("id"));
                    UsuarioDTO uT = new UsuarioDTO(m, us, ps);
                    uO.update(uT);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error en el Servlet Persona-ci " + e);
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
