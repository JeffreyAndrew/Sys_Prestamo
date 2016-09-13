/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PersonaDAO;
import DAO.PrestamoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LEANDRO
 */
public class PrestamoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Map<String, Object> mp = new HashMap<>();
    PrestamoDAO pD = new PrestamoDAO();
    PersonaDAO aD=new PersonaDAO();

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
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String meth = request.getParameter("mt");
        int op = Integer.parseInt(request.getParameter("op"));
        String pagina = "";
        int idusuario = 0;
        int idper = 0;
        int idrol=0;
        String hora = "";
        String lugar = "";
        String comentarioa = "";
        int idprestamo = 0;
        int idpersona = 0;
        int iddeteq = 0;
        Map<String, Object> c = new HashMap<>();
        RequestDispatcher dispatcher;
        try {
            switch (meth) {
                case "rd":
                    switch (op) {
                        case 2:
                            pagina = "/vistas/prestamo/tdevolucion.jsp";
                            dispatcher = getServletContext().getRequestDispatcher(pagina);
                            dispatcher.forward(request, response);
                            break;
                        case 3:
                            iddeteq = Integer.parseInt(request.getParameter("id"));
                            mp.put("rp", pD.returnEq(iddeteq));
                            break;
                        case 4:
                            idprestamo = Integer.parseInt(request.getParameter("id"));
                            mp.put("rp", pD.returnloan(idprestamo));
                            break;
                    }
                    break;
                case "add":
                    switch (op) {
                        case 1:
                            idusuario = Integer.parseInt(request.getParameter("iduser"));
                            idper = Integer.parseInt(request.getParameter("idpersona"));
                            hora = request.getParameter("hora");
                            lugar = request.getParameter("lugar");
                            c.put("idusuario", idusuario);
                            c.put("persona", idper);
                            c.put("hora", hora);
                            c.put("lugar", lugar);
                            mp.put("idprestamo", pD.add(c));
                            break;
                        case 2:
                            idprestamo = Integer.parseInt(request.getParameter("idprestamo"));
                            iddeteq = Integer.parseInt(request.getParameter("iddet"));
                            mp.put("resp", pD.addeqprestamo(idprestamo, iddeteq));
                            break;
                    }
                    break;
                case "list":
                    switch (op) {
                        case 1:
                            idprestamo = Integer.parseInt(request.getParameter("idp"));
                            ArrayList<Map<String, ?>> listae = pD.listareq(idprestamo);
                            mp.put("lista", listae);
                            break;
                        case 2:
                            ArrayList<Map<String, ?>> lista = pD.listared();
                            mp.put("lista", lista);
                            break;
                        case 3:
                            ArrayList<Map<String, ?>> docentes = pD.listdc();
                            mp.put("list", docentes);
                            break;
                        case 4:
                            ArrayList<Map<String, ?>> docentesh = pD.listdh();
                            mp.put("lista", docentesh);
                            break;
                        case 5:
                            idpersona = Integer.parseInt(request.getParameter("idpersona"));
                            ArrayList<Map<String, ?>> listadr = pD.listd(idpersona);
                            mp.put("lista", listadr);
                            break;
                        case 6:
                            idrol = Integer.parseInt(request.getParameter("idrol"));
                            ArrayList<Map<String, ?>> listaper = aD.listarper(idrol);
                            mp.put("lista", listaper);
                            break;
                        case 7:
                            idprestamo = Integer.parseInt(request.getParameter("idp"));
                            ArrayList<Map<String, ?>> listadl = pD.listardp(idprestamo);
                            mp.put("lista", listadl);
                            break;
                    }
                    break;
                case "update":
                    switch (op) {
                        case 1:
                            iddeteq = Integer.parseInt(request.getParameter("iddet"));
                            String est = request.getParameter("estado");
                            pD.changeestatus(est, iddeteq);
                            break;
                        case 2:
                            comentarioa = request.getParameter("com");
                            idprestamo = Integer.parseInt(request.getParameter("idprestamo"));
                            boolean m = pD.changecom(comentarioa, idprestamo);
                            mp.put("resp", m);
                    }
                    break;
                case "remove":
                    switch (op) {
                        case 1:
                            iddeteq = Integer.parseInt(request.getParameter("iddet"));
                            idprestamo = Integer.parseInt(request.getParameter("idprestamo"));
                            mp.put("rp", pD.removeeq(idprestamo, iddeteq));
                            break;
                        case 2:
                            idpersona = Integer.parseInt(request.getParameter("idpersona"));
                            mp.put("rp", aD.delete(idpersona));
                            break;
                        case 3:
                            idprestamo=Integer.parseInt(request.getParameter("id"));
                            mp.put("rp", pD.deleteloan(idprestamo));
                            break;
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            mp.put("error", e.getMessage());
        }

        Gson gson = new Gson();
        out.println(gson.toJson(mp));
        out.flush();
        out.close();
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
