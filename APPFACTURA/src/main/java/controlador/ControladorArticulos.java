package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import clases.CuerpoFactura;
import clases.Factura;
import modelo.ArticuloDali;
import modelo.Usuario;
import clases.Articulo;
import clases.CuerpoFactDali;

/**
 * Servlet implementation class ControladorArticulos
 */
@WebServlet("/ControladorArticulos")
public class ControladorArticulos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorArticulos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            // Producto registrado correctamente
            response.sendRedirect("exito.jsp");
        } else {
            // Error al registrar el producto
            response.sendRedirect("error.jsp");
        }
	}


}
