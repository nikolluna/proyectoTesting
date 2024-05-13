package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Clientes;
import modelo.ClienteDali;
import modelo.Usuario;

/**
 * Servlet implementation class ControladorCliente
 */
@WebServlet("/ControladorCliente")
public class ControladorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCliente() {
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
		String rucCliente = request.getParameter("rucCliente");
        String nombreCliente = request.getParameter("nombreCliente");
        String direccionCliente = request.getParameter("direccionCliente");
        
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        System.out.println("Llegué a registrar cliente");
        Clientes cliente = new Clientes();
        cliente.setRucCliente(rucCliente);
        cliente.setNombreCliente(nombreCliente);
        cliente.setDireccionCliente(direccionCliente);

        ClienteDali clienteDali = new ClienteDali();
        int resultado = clienteDali.enviar(cliente, usuario);
        if (resultado > 0) {
            // Producto registrado correctamente
            response.sendRedirect("exito.jsp");
        } else {
            // Error al registrar el producto
            response.sendRedirect("error.jsp");
        }
	}

}
