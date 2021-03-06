/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EquipoDAO;
import DAO.PersonaDAO;
import DTO.EquipoDTO;
import Interfaces.Operaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IgorCB
 */
public class SVL_Equipo extends HttpServlet {

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
         RequestDispatcher dispatcher;
         EquipoDAO aO = new EquipoDAO();
        PrintWriter out = response.getWriter();
     String b = request.getParameter("busqueda"); 
        if(b!=null && b!=""){
             //out.print("si llego la variable "+b);
              out.print("</br><table class='table table-responsive'>"+
	    " <th>"+
               " <tr class='titulo'> "+
			"<td><strong>MARCA<strong></td>"+
			"<td><strong>SERIE<strong></td>"+
			"<td><strong>TIPO<strong></td>"+
		"</tr>"+
	   "</th>"+
	"<tbody>");
             List ListaResultado = aO.buscarPersona(b);
             for(int i=0; i<ListaResultado.size();i++){
                    EquipoDTO equipo = new EquipoDTO();
                    equipo= (EquipoDTO)ListaResultado.get(i);
                    out.print("<tr>");
                    out.print("<td>"+equipo.getMarca()+"</td>");
                    out.print("<td>"+equipo.getSerie()+"</td>");
                    out.print("<td>"+equipo.getTipo()+"</td>");
                    out.print("</tr>");
             }
	out.print("</tbody></table>"); 
        }else{
          // out.print("No se encontró nada");
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
