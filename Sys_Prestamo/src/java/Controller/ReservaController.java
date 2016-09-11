/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Det_EquipoDAO;
import DAO.EquipoDAO;
import DAO.PersonaDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import DTO.Det_EquipoDTO;
import DTO.EquipoDTO;
import DTO.PersonaDTO;
import DTO.ReservaDTO;
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
 * @author CESAR
 */
public class ReservaController extends HttpServlet {

    ReservaDAO dao = new ReservaDAO();
    UsuarioDAO udao=new UsuarioDAO();
    PersonaDAO pdao=new PersonaDAO();
    EquipoDAO edao=new EquipoDAO();
    Det_EquipoDAO ddao=new Det_EquipoDAO();

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
        List<ReservaDTO> lista =new ArrayList();
        List<UsuarioDTO> lista2 =new ArrayList();
        List<PersonaDTO> lista3 =new ArrayList();
        List<EquipoDTO> lista4 =new ArrayList();
        List<Det_EquipoDTO> lista5 =new ArrayList();
        ArrayList lista6 =new ArrayList();
        int i=0;
        try {
            switch (gr) {
                case 1:
                    lista=dao.readall();
                    while(i<lista.size()){
                        lista2.add(udao.read(lista.get(i).getId_usuario()).get(0));
                        lista3.add(pdao.read(lista.get(i).getId_docente()).get(0));
                        lista5.add(ddao.read(lista.get(i).getId_detequipo()).get(0));
                        lista4.add(edao.read(lista5.get(i).getIdEquipo()).get(0));
                        i++;
                    }
                    lista6.add(lista);
                    lista6.add(lista2);
                    lista6.add(lista3);
                    lista6.add(lista4);
                    lista6.add(lista5);
                    session.setAttribute("lista", lista6);
                    pagina = "/vistas/reserva/listar.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    break;
                case 2:
                    pagina = "/vistas/reserva/reservar.jsp";
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    break;
                case 3:
                    pagina = "/rc?gr=1";
                    String[] parts=request.getParameter("fechas").split(" - ");
                    String fechaInicio=parts[0];
                    String fechaFinal=parts[1];
                    String docente =request.getParameter("docente");
                    int iddocente =Integer.parseInt(request.getParameter("iddocente"));
                    int iddet_equipo =ddao.readByCode(Integer.parseInt(request.getParameter("codigo"))).get(0).getIdDet_Equipo();
                    String dia =request.getParameter("dia");
                    ReservaDTO rdto=new ReservaDTO();
                    rdto.setDia(dia);
                    rdto.setFecha_inicio(fechaInicio);
                    rdto.setFecha_fin(fechaFinal);
                    rdto.setId_detequipo(iddet_equipo);
                    rdto.setId_docente(iddocente);
                    rdto.setId_usuario(1);
                    dao.create(rdto);
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                    break;
                case 4:
                    pagina="/rc?gr=1";
                    int id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
