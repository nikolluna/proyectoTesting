package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.CabeceraFactura;
import modelo.CabeceraDali;

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
        
		String fecha = request.getParameter("inputFechae");
		String rucClienteStr = request.getParameter("inputRuce");
		String codigoVendedorStr = request.getParameter("inputNroe");
		long codigoVendedor = 0;
		
		if(codigoVendedorStr != null && !codigoVendedorStr.isEmpty()) {
		    codigoVendedor = Long.parseLong(codigoVendedorStr);
		}

        CabeceraFactura cabeceraFactura = new CabeceraFactura();
        cabeceraFactura.setFecha(fecha);
        cabeceraFactura.setRuc_cliente(rucClienteStr);
        cabeceraFactura.setCodigo_vendedor(codigoVendedor);

        CabeceraDali cabeceraDali = new CabeceraDali();
        int resultado = cabeceraDali.enviar(cabeceraFactura);

        if (resultado > 0) {
            response.sendRedirect("exito.jsp");
        } else {
        	request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
	}
