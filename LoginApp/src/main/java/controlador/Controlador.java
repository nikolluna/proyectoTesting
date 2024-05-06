package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import modelo.UsuarioDali;

/**
 * Servlet implementation class Controlador
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Controlador" })

public class Controlador extends HttpServlet {
	String listar = "clases/";
	String agregar = "";
	int res;
	Usuario us = new Usuario();
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDali val = new UsuarioDali();
		response.setContentType("text/html; charset=UTF-8");
		//System.out.println("Volvi y el valor de res es "+res);
		String accion = request.getParameter("accion");
	    
	    if (accion.equals("Ingresar")) {
	        String correo = request.getParameter("txtcorreo");
	        String contra = request.getParameter("txtcontra");
	        us.setCorreo(correo);
	        us.setContrasena(contra);
	        //System.out.println("Me valido y el valor de correo es "+us.getCorreo());
	        //System.out.println("Me valido y el valor de contra es "+us.getContrasena());
	        res = val.validar(us);
	        //System.out.println("Me valido y el valor de res es "+res);
	        if (res == 1) {
	        	System.out.println("Ingrese y el valor de res es "+res);
	        	request.getSession().setAttribute("correo", correo);
	        	request.getSession().setAttribute("contra", contra);
	            request.getRequestDispatcher("menu.jsp").forward(request, response);
	        } else {
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        }
	    }
	    else {
	    	request.getRequestDispatcher("index.jsp").forward(request, response);
	    }
	}

	
	
    public Controlador() {
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
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	

}
