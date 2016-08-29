/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PrestamoDAO;
import DTO.PrestamoDTO;
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
 * @author Igor
 */
public class SVL_Prestamo extends HttpServlet {

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
        PrestamoDAO aO = new PrestamoDAO();
        PrintWriter out = response.getWriter();
     String b = request.getParameter("busqueda"); 
        if(b!=null && b!=""){
           // out.print("si llego la variable "+b);
              out.print("</br><table class='table table-responsive'>"+
	    " <th>"+
               " <tr class='titulo'> "+
			"<td><strong>ID PRESTAMO<strong></td>"+
		      //"<td><strong>ID USUARIO<strong></td>"+
		      //"<td><strong>PERSONARES<strong></td>"+
                        "<td><strong>FECHA DEL PRESTAMO<strong></td>"+
                        "<td><strong>FECHA DE LA DEVOLUCION<strong></td>"+
                        "<td><strong>LUGAR<strong></td>"+
                       // "<td><strong>COMENTARIOS DEL PRESTAMO<strong></td>"+
		       //"<td><strong>COMENTARIOS DE LA DEVOLUCION<strong></td>"+
                        "<td><strong>ESTADO<strong></td>"+
		"</tr>"+
	   "</th>"+
	"<tbody>");
             List ListaResultado = aO.buscarPrestamo(b);
             for(int i=0; i<ListaResultado.size();i++){
                    PrestamoDTO prestamo = new PrestamoDTO();
                    prestamo= (PrestamoDTO)ListaResultado.get(i);
                    out.print("<tr>");
                    out.print("<td>"+prestamo.getIdPrestamo()+"</td>");
                  //  out.print("<td>"+prestamo.getIdUsuario()+"</td>");
                  //  out.print("<td>"+prestamo.getPersonaRes()+"</td>");
                    out.print("<td>"+prestamo.getFechaPrestamo()+"</td>");
                    out.print("<td>"+prestamo.getFechaDevolucion()+"</td>");
                    out.print("<td>"+prestamo.getLugar()+"</td>");
                 //   out.print("<td>"+prestamo.getComentariop()+"</td>");
                 //  out.print("<td>"+prestamo.getComentariod()+"</td>");
                    out.print("<td>"+prestamo.getEstado()+"</td>");
                    out.print("</tr>");
             }
	out.print("</tbody></table>"); 
        }else{
           //out.print("No se encontró nada");
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
