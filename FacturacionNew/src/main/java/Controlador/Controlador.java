/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Articulo;
import Modelo.Usuario;
import Modelo.UsuarioDali;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Modelo.DetalleFactura;
/**
 *
 * @author saman
 */
public class Controlador extends HttpServlet {
    int res;
    Usuario us = new Usuario();
    UsuarioDali val = new UsuarioDali();
    Articulo articulos= new Articulo();
    DetalleFactura dFac = new DetalleFactura();
    List<DetalleFactura> lista = new ArrayList();
    String descripcion;
    double precioUnitario=0.0;
    int cantidad;
    double precioTotal;
    double TotalFac;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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

		response.setContentType("text/html; charset=UTF-8");
		//System.out.println("Volvi y el valor de res es "+res);
		String accion = request.getParameter("accion");
                if (accion.equals("Ingresar")) {
                    String correo = request.getParameter("txtcorreo");
                    String contra = request.getParameter("txtcontra");
                    us.setCorreo(correo);
                    us.setContrasena(contra);
                    System.out.println("Me valido y el valor de correo es "+us.getCorreo());
                    System.out.println("Me valido y el valor de contra es "+us.getContrasena());
                    res = val.validar(us);
                    //System.out.println("Me valido y el valor de res es "+res);
                    if (res == 1) {
                            System.out.println("Ingrese y el valor de res es "+res);
                            request.getSession().setAttribute("correo", correo);
                            request.getSession().setAttribute("contra", contra);
                            HttpSession session = request.getSession();
                        List<Articulo> listaArticulos = val.listarArticulos(us);
                     // Después de obtener la lista de artículos
                        List<String> descripciones = new ArrayList<>();
                        List<Double> precios = new ArrayList<>();
                        for (Articulo articulo : listaArticulos) {
                            System.out.println("ARTICULO: "+articulo.getDescripcion());
                            descripciones.add(articulo.getDescripcion());
                            precios.add(articulo.getPrecio_u());
                        }

                        session.setAttribute("usuario", us);
                        session.setAttribute("descripciones", descripciones);
                        session.setAttribute("precios", precios);
                        response.sendRedirect(request.getContextPath() + "/menu.jsp");

                    } else {
                       request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }
                if(accion.equals("BuscarPrecio")){
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", us);
                    System.out.println("Buscar");
                    String des = request.getParameter("descripcion");
                    articulos = val.buscarArticuloPorDescripcion(us, des);
                    request.setAttribute("articulo", articulos);
                    session.setAttribute("usuario", us);
                    request.setAttribute("totalpag", TotalFac);
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("/menu.jsp").forward(request, response);
                }
                if(accion.equals("Agregar")){
                    System.out.println("Agregandooo");
                    TotalFac =0.0;
                    descripcion = request.getParameter("desProducto");
                    System.out.println(descripcion);
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                     System.out.println(cantidad);
                      System.out.println(request.getParameter("punit"));
                    if ((request.getParameter("punit")) != null) {
                         precioUnitario = Double.parseDouble(request.getParameter("punit"));
                    }
                    precioTotal = precioUnitario*cantidad;
                    
                    boolean encontrado = false;
                    for (DetalleFactura detalle : lista) {
                        if (detalle.getDescripcion().equals(descripcion)) {
                            // El producto ya existe, actualizar cantidad y precio total
                            detalle.setCantidad(detalle.getCantidad() + cantidad);
                            detalle.setPrecioTotal(detalle.getPrecioTotal() + precioTotal);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                    dFac = new DetalleFactura();
                    dFac.setCantidad(cantidad);
                    dFac.setDescripcion(descripcion);
                    dFac.setPrecioTotal(precioTotal);
                    dFac.setPrecioUnitario(precioUnitario);
                    System.out.println("Cantidad: " + dFac.getCantidad());
                    System.out.println("Descripción: " + dFac.getDescripcion());
                    System.out.println("Precio Total: " + dFac.getPrecioTotal());
                    System.out.println("Precio Unitario: " + dFac.getPrecioUnitario());
                    lista.add(dFac);
                    }
                    for (int i = 0; i < lista.size(); i++) {
                        TotalFac = TotalFac + lista.get(i).getPrecioTotal();
                    }
                    request.setAttribute("totalpag", TotalFac);
                    request.setAttribute("lista", lista);
                    
                    request.getRequestDispatcher("/menu.jsp").forward(request, response);
                }
                if (accion.equals("Eliminar")) {
                    String descripcionEliminar = request.getParameter("descripcionEliminar");
                    for (int i = 0; i < lista.size(); i++) {
                        DetalleFactura detalle = lista.get(i);
                        if (detalle.getDescripcion().equals(descripcionEliminar)) {
                            lista.remove(i);
                            break;
                        }
                    }
                    double TotalFac = 0.0;
                    for (DetalleFactura detalle : lista) {
                        TotalFac += detalle.getPrecioTotal();
                    }
                    request.setAttribute("totalpag", TotalFac);
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("/menu.jsp").forward(request, response);
                }
                if(accion.equals("Refrescar Factura")) {
                    HttpSession session = request.getSession();
                    List<Articulo> listaArticulos = val.listarArticulos(us);
                    List<Double> precios = new ArrayList<>();
                    List<String> descripciones = new ArrayList<>();
                    for (Articulo articulo : listaArticulos) {
                        System.out.println("ARTICULO: "+articulo.getDescripcion());
                        descripciones.add(articulo.getDescripcion());
                        precios.add(articulo.getPrecio_u());
                    }
                    session.setAttribute("usuario", us);
                    session.setAttribute("descripciones", descripciones);
                    session.setAttribute("precios", precios);
                    request.getRequestDispatcher("/menu.jsp").forward(request, response);
                }
        }
    }

