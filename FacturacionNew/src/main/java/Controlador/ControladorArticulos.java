/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Articulo;
import Modelo.ArticuloDali;
import Modelo.Usuario;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author saman
 */
public class ControladorArticulos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          Double precioProducto=0.0;
		String precioProductostr = request.getParameter("productPrice");
		if (precioProductostr != null) {
			precioProducto = Double.parseDouble(precioProductostr);
		}
		String nombreProducto = request.getParameter("productName");
        
		HttpSession session = request.getSession();
	    Usuario usuario = (Usuario) session.getAttribute("usuario");
	    
	    System.out.println("Lllegueeee");
        Articulo producto = new Articulo();
        System.out.println("des: "+nombreProducto);
        System.out.println("pre: "+precioProducto);

        producto.setDescripcion(nombreProducto);
        producto.setPrecio_u(precioProducto);
        System.out.println("usuario: "+usuario.getCorreo());
        ArticuloDali productoDali = new ArticuloDali();
        int resultado = productoDali.enviar(producto,usuario);
        
        List<Articulo> listaArticulos = productoDali.listarArticulos(usuario);
        for (Articulo articulo : listaArticulos) {
            System.out.println("ID: " + articulo.getId_articulo());
            System.out.println("Descripción: " + articulo.getDescripcion());
            System.out.println("Precio: " + articulo.getPrecio_u());
            System.out.println("-----------------------");
        }

        
        if (resultado > 0) {
            request.setAttribute("articulo", listaArticulos);
            response.sendRedirect("menu.jsp");
        } else {
            // Error al registrar el producto
            response.sendRedirect("error.jsp");
        }
	}
        
    }

