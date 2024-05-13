package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Empleado;
import modelo.EmpleadoDali;
import modelo.Usuario;

/**
 * Servlet implementation class ControladorRegistroEmpleado
 */
@WebServlet("/ControladorRegistroEmpleado")
public class ControladorRegistroEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorRegistroEmpleado() {
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
		String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        Empleado empleado = new Empleado();
        empleado.setDni(dni);
        empleado.setNombreVendedor(nombre);
      // Aseguramos que se setea la dirección correctamente

        EmpleadoDali empleadoDali = new EmpleadoDali();
        int resultado = empleadoDali.registrar(empleado,usuario);  // Método para insertar el empleado en la base de datos

        if (resultado > 0) {
            System.out.println("Empleado registrado con éxito: " + nombre);
            response.sendRedirect("exito.jsp");  // Redirige a la página de éxito
        } else {
            System.out.println("Error al registrar empleado");
            request.setAttribute("errorMessage", "Error al registrar el empleado");
            request.getRequestDispatcher("error.jsp").forward(request, response);  // Reenvía a la página de error
        }
    }

}
