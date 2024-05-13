package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Articulo;
import clases.FacturaCompleta;
import modelo.ArticuloDali;
import modelo.Usuario;
import modelo.UsuarioDali;

/**
 * Servlet implementation class Controlador
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Controlador" })


public class Controlador extends HttpServlet {
	int res;
	Usuario us = new Usuario();
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDali val = new UsuarioDali();
		Articulo articulos= new Articulo();
		response.setContentType("text/html; charset=UTF-8");
		//System.out.println("Volvi y el valor de res es "+res);
		String accion = request.getParameter("accion");
		FacturaCompleta cuerpo = new FacturaCompleta();
		List<FacturaCompleta> lista = new ArrayList<>();
	    int codigo_item;
	    String descripcion_item;
	    int cantidad =0;
	    Double precio_total_c=0.0;
	    
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
	            request.getRequestDispatcher("menu.jsp").forward(request, response);
	           
	        } else {
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        }
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
            request.getRequestDispatcher("menu.jsp").forward(request, response);
	    }
	    if(accion.equals("Buscar")) {
	    	HttpSession session = request.getSession();
	    	String descripcion = request.getParameter("descripcion");
	    	System.out.println("desnueva: "+descripcion);
	    	articulos=val.buscarArticuloPorDescripcion(us,descripcion);
	    	System.out.println("cantidad" + request.getParameter("cantidad"));
	    	request.setAttribute("articulo", articulos);
	    	session.setAttribute("usuario", us);
	    	request.getRequestDispatcher("menu.jsp").forward(request, response);
	    }
	    
	    if(accion.equals("Guardar")) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("usuario", us);
	    	request.getRequestDispatcher("exito.jsp").forward(request, response);
	    	
	    }
	    else {
	    	request.getRequestDispatcher("index.jsp").forward(request, response);
	    }
	}
	protected void obtenerDatos (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}

	
	
    public Controlador() {
        
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
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	

}
