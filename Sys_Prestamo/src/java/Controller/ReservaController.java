/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Det_EquipoDAO;
import DAO.Det_ReservaDAO;
import DAO.EquipoDAO;
import DAO.PersonaDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import DTO.Det_EquipoDTO;
import DTO.Det_ReservaDTO;
import DTO.EquipoDTO;
import DTO.PersonaDTO;
import DTO.ReservaDTO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ReservaController extends HttpServlet {

    ReservaDAO rdao = new ReservaDAO();
    UsuarioDAO udao = new UsuarioDAO();
    PersonaDAO pdao = new PersonaDAO();
    EquipoDAO edao = new EquipoDAO();
    Det_EquipoDAO ddao = new Det_EquipoDAO();
    Det_ReservaDAO drdao = new Det_ReservaDAO();

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
        RequestDispatcher dispatcher;
        String pagina = "";
        HttpSession session = request.getSession(true);

        int gr = Integer.parseInt(request.getParameter("gr"));
        List<ReservaDTO> lista = new ArrayList();
        List<UsuarioDTO> lista2 = new ArrayList();
        List<PersonaDTO> lista3 = new ArrayList();
        List<EquipoDTO> lista4 = new ArrayList();
        List<Det_EquipoDTO> lista5 = new ArrayList();
        ArrayList lista6 = new ArrayList();
        int i = 0;
        try {
            switch (gr) {
                case 1:
                    lista = rdao.readall();
                    while (i < lista.size()) {
                        lista2.add(udao.read(lista.get(i).getId_usuario()).get(0));
                        lista3.add(pdao.read(lista.get(i).getId_docente()).get(0));
                        //lista5.add(ddao.read(lista.get(i).getId_detequipo()).get(0));
//                        lista4.add(edao.read(lista5.get(i).getIdEquipo()).get(0));
                        i++;
                    }
                    lista6.add(lista);
                    lista6.add(lista2);
                    lista6.add(lista3);
//                    lista6.add(lista4);
//                    lista6.add(lista5);
                    session.setAttribute("lista", lista6);
                    pagina = "/vistas/reserva/listar.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    break;
                case 2:
                    pagina = "/vistas/reserva/reservar.jsp";
                    int idp = Integer.parseInt(request.getParameter("id"));
                    List<PersonaDTO> listdoc = rdao.docvalidated();
                    List<UsuarioDTO> listp = new ArrayList();
                    ArrayList listdeq = ddao.especifiedreadall();
                    ResultSet rs = udao.list(idp);
                    while (rs.next()) {
                        UsuarioDTO udto = new UsuarioDTO();
                        udto.setIdusuario(rs.getInt("idUsuario"));
                        udto.setIdpersona(rs.getInt("idPersona"));
                        udto.setUser(rs.getString("usuario"));
                        udto.setPassword(rs.getString("clave"));
                        listp.add(udto);
                    }
                    session.setAttribute("listp", listp);
                    session.setAttribute("listdoc", listdoc);
                    session.setAttribute("listdeq", listdeq);
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    break;
                case 3:
                    pagina = "rc?gr=1";
                    String[] parts = request.getParameter("fechas").split(" - ");
                    String fechaInicio = parts[0];
                    String fechaFinal = parts[1];
                    int idocente = Integer.parseInt(request.getParameter("idocente"));
                    int idprest = Integer.parseInt(request.getParameter("idprest"));
                    String[] ideqsel = request.getParameterValues("eqsel[]");
                    String dia = request.getParameter("dia");
                    String hinicio = request.getParameter("hinicio");
                    String hfinal = request.getParameter("hfinal");
                    ReservaDTO rdto = new ReservaDTO();
                    rdto.setDia(dia);
                    rdto.setId_usuario(idprest);
                    rdto.setId_docente(idocente);
                    rdto.setFecha_inicio(fechaInicio);
                    rdto.setFecha_fin(fechaFinal);
                    rdto.setHora_ini(hinicio);
                    rdto.setHora_fin(hfinal);
                    System.out.println("fecha " + fechaInicio + " hasta " + fechaFinal);
                    System.out.println("dia " + dia);
                    System.out.println("id de docente " + idocente);
                    System.out.println("id de prestamsta " + idprest);
                    System.out.println("hora inicio " + hinicio);
                    System.out.println("hora inicio " + hfinal);
                    rdao.create(rdto);
                    int idreserva = rdao.especifiedread(rdto).get(0);
                    for (i = 0; i < ideqsel.length; i++) {
                        Det_ReservaDTO drdto = new Det_ReservaDTO(Integer.parseInt(ideqsel[i]), idreserva);
                        System.out.println("ideqsels: "+Integer.parseInt(ideqsel[i]));
                        drdao.create(drdto);
                    }
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(pagina);
                    break;
                case 4:
                    pagina = "/rc?gr=1";
                    int id = Integer.parseInt(request.getParameter("id"));
                    rdao.delete(id);
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
            }
        } catch (ServletException | IOException | NumberFormatException | SQLException e) {
            System.out.println("Errooooor: "+e);
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
