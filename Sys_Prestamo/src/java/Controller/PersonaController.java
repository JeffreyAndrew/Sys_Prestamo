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
        List<PersonaDTO> lis = new ArrayList<>();
        int op = Integer.parseInt(request.getParameter("op"));
        switch (op) {
            case 1:
                pag = "/vistas/persona/add_person.jsp";
                dispatcher = getServletContext().getRequestDispatcher(pag);
                dispatcher.forward(request, response);
                break;
            case 2://perfil
                int id=Integer.parseInt(request.getParameter("id"));
                session.setAttribute("lista", pro.read(id));
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
                u = new PersonaDTO(idRol, nombre, apellidos, dni, celular, correo);
                boolean c = pro.create(u);
                if (c) {

//                Agregar Usuario
                    PersonaDAO perDAO = new PersonaDAO();
                    int ID = perDAO.buscarIDPersona(dni);
                    UsuarioDTO usu = new UsuarioDTO(ID, nombre, Integer.toString(dni));
                    boolean n = uO.create(usu);

                    pag = "/index.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pag);
                    dispatcher.forward(request, response);
                } else {
                    pag = "/.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pag);
                    dispatcher.forward(request, response);
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
        String pagina = "";
        String nombre = "";
        String apellidos = "";
        String correo = "";
        int dni = 0;
        int celular = 0;
        int id = 0;
        boolean resp = false;
        int idRol = 0;
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession(true);
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
                resp = pro.update(P);
                if (resp) {
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
