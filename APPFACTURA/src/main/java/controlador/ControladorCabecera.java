package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.CabeceraFactura;
import modelo.CabeceraDali;
import modelo.Usuario;
import clases.Articulo;


/**
 * Servlet implementation class ControladorCabecera
 */
@WebServlet("/ControladorCabecera")
public class ControladorCabecera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCabecera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion1");
		if (accion.equals("Enviar")) {
			HttpSession session = request.getSession();
		    Usuario usuario = (Usuario) session.getAttribute("usuario");
			String fecha = request.getParameter("inputFechae");
			String rucClienteStr = request.getParameter("inputRuce");
			String codigoVendedor = request.getParameter("inputNroe");
			
	        CabeceraFactura cabeceraFactura = new CabeceraFactura();
	        cabeceraFactura.setFecha(fecha);
	        cabeceraFactura.setRuc_cliente(rucClienteStr);
	        cabeceraFactura.setCodigo_vendedor(codigoVendedor);

	        CabeceraDali cabeceraDali = new CabeceraDali();
	        int resultado = cabeceraDali.enviar(cabeceraFactura, usuario);
	        

	        if (resultado > 0) {
	        	System.out.println("Correo"+usuario.getCorreo());
	            response.sendRedirect("exito.jsp");
	        } else {
	        	request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
		}
		if (accion.equals("Enviar2")) {
			HttpSession session = request.getSession();
		    Usuario usuario = (Usuario) session.getAttribute("usuario");
			String fecha = request.getParameter("inputFechae");
			String rucClienteStr = request.getParameter("inputRuce");
			String codigoVendedor = request.getParameter("inputNroe");
			
	        CabeceraFactura cabeceraFactura = new CabeceraFactura();
	        cabeceraFactura.setFecha(fecha);
	        cabeceraFactura.setRuc_cliente(rucClienteStr);
	        cabeceraFactura.setCodigo_vendedor(codigoVendedor);

	        CabeceraDali cabeceraDali = new CabeceraDali();
	       
	        int res = cabeceraDali.guardar(cabeceraFactura, usuario);

	        if (res > 0) {
	        	System.out.println("Correo"+usuario.getCorreo());
	            response.sendRedirect("exito.jsp");
	        } else {
	        	request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
		}
    }
	}
