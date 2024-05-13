<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
  .centrado {
    text-align: center;
    font-weight: bold;  
  }
  .btn-bajar {
    margin-top: 23px; 
  }
</style>
</head>
<body class="bg-light container">
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="#" onclick="showSection('home')">Inicio</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="registroProducto.jsp">Registrar Producto</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="registroCliente.jsp" >Registrar Cliente</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="registroVendedor.jsp">Registrar Vendedor</a>
				</li>
			</ul>
		</div>
	</div>
  </nav>
  <h1 class="centrado">Factura</h1>
  <hr />
  <main>
    <section class="row">
      <div class="col">
        <div class="card">
          <div class="card-header bg-success text-white">
            <h3 class="card-title ">Cabecera</h3>
          </div>
          <div class="card-body">
          <div>
	      <form action="Controlador" method="post">
	     	 <input type="submit" name="accion" class="btn btn-primary btn-lg btn-block" value="Refrescar Factura">
	      </form>
	      </div>
            <form class="row" id ="formCabecera" action="ControladorCabecera" method="post">
			  <div class="form-group col-md-4">
			    <label for="cliente">Cliente:</label>
			    <input type="text" class="form-control" placeholder="Nombre del cliente" id="inputNombre"  oninput="validateInput(this)" />
			  </div>
			  <div class="form-group col-md-8">
			    <label for="inputDireccion">Direccion del Cliente:</label>
			    <input type="text" class="form-control" placeholder="Ejm: Carlos Marx 107" id="inputDireccion" />
			  </div>
			  <div class="form-group col-md-4">
			    <label for="inputRuc">RUC:</label>
			    <input type="text" class="form-control" maxlength="11" placeholder="Ejm: 10445523254" id="inputRuc" name="inputRuce" oninput="validateInputNumeros(this)" >
			  </div>
			  <div class="form-group col-md-4">
			    <label for="inputFecha">Fecha:</label>
			    <input type="date" class="form-control" id="inputFecha" name="inputFechae" />
			  </div>
			  <div class="form-group col-md-4">
			    <label for="inputNro">Codigo de Vendedor:</label>
			    <input type="text" class="form-control" placeholder="Ejm: 002" maxlength="8" id="inputNro" name="inputNroe" oninput="validateInputNumeros(this)"/>
			  </div>
			  <div class="form-group col-md-12">
			        <input type="submit" class="btn btn-primary btn-lg btn-block" name="accion1" value="Enviar">
			        <button class="btn btn-dark btn-lg" id ="btnGuardar"  name="accion1" value="Enviar2" onclick="guardarFactura()">Guardar Factura </button>
			    </div>
			</form>
          </div>
        </div>
      </div>
    </section>
    <section class="row mt-4" >
	  <div class="col-12">
	    <div class="card">
	      <div class="card-header bg-success text-white">
            <h3 class="card-title">Ingresar Productos</h3>
          </div>
	      <div class="card-body">
	        <form class="row" id="formDetalle">
	          <div class="form-group col-md-5">
	            <label for="selectDescripcion">Seleccion de productos</label>
	            <select id="selectDescripcion" name="descripcion" class="form-control">
				    <option value="0">---Seleccione---</option>
				    <% 
					    List<String> descripciones = (List<String>) request.getSession().getAttribute("descripciones");
					    List<Double> precios = (List<Double>) request.getSession().getAttribute("precios");
					    if (descripciones != null && precios != null && descripciones.size() == precios.size()) {
					        for (int i = 0; i < descripciones.size(); i++) { 
					    %>
					            <option value="<%= descripciones.get(i) %>"><%= descripciones.get(i) %></option>
					    <% 
					        } 
					    } 
					    %>
				</select>
				
	          </div>
	          <div class="form-group col-md-2">
	            <label for="inputCantidad">Cantidad</label>
	            <input type="number" name="cantidad" class = "form-control" id="inputCantidad">
	          </div>
	          
				<div class="form-group col-md-2">
				    <label for="inputPUnitario">P. Unit</label>
				    <input type="number" name="punit" value="${articulo.getPrecio_u()}" class="form-control" id="inputPUnitario" disabled>
				    <button type="button" class="btn btn-primary" onclick="generarPrecioAleatorio()"> Obtener</button>
				</div>

	          <div class="form-group col-md-1">
	            <button class="btn btn-warning btn-bajar" type="button" onclick="agregarProducto()">
				    Agregar producto
				</button>

	          </div>
	        </form>
	      </div>
	    </div>
	  </div>
	</section>
	<section class="row mt-4">
	  <div class="col">
	    <table class="table text-center">
	      <thead>
	        <tr>
	          <th>Cantidad</th>
	          <th>Descripcion</th>
	          <th>P. Unitario</th>
	          <th>P. Total</th>
              <th></th>
	        </tr>
	      </thead>
          <tbody id="cuerpoTabla">
          
          </tbody>
	    </table>
	  </div>
	</section>
  </main>
  <script>
  function agregarProducto() {
	    var descripcionSelect = document.getElementById('selectDescripcion');
	    var descripcion = descripcionSelect.options[descripcionSelect.selectedIndex].text;
	    var cantidad = parseFloat(document.getElementById('inputCantidad').value);
	    var precioUnitario = parseFloat(document.getElementById('inputPUnitario').value);

	    // Validación básica de los inputs
	    if (cantidad < 1 || isNaN(cantidad)) {
	        alert("Por favor, ingrese una cantidad válida.");
	        return;
	    }

	    if (descripcion === "---Seleccione---") {
	        alert("Por favor, seleccione un producto.");
	        return;
	    }

	    var tabla = document.getElementById('cuerpoTabla');
	    var productoExistente = false;

	    // Buscar si el producto ya existe en la tabla
	    for (let i = 0; i < tabla.rows.length; i++) {
	        let fila = tabla.rows[i];
	        if (fila.cells[1].innerHTML === descripcion) {
	            let cantidadExistente = parseFloat(fila.cells[0].innerHTML);
	            let nuevaCantidad = cantidadExistente + cantidad;
	            fila.cells[0].innerHTML = nuevaCantidad; // Actualizar cantidad
	            fila.cells[3].innerHTML = (nuevaCantidad * precioUnitario).toFixed(2); // Actualizar precio total
	            productoExistente = true;
	            break;
	        }
	    }

	    // Si el producto no existe, agregar nueva fila
	    if (!productoExistente) {
	        var nuevaFila = tabla.insertRow(-1);
	        var celdaCantidad = nuevaFila.insertCell(0);
	        var celdaDescripcion = nuevaFila.insertCell(1);
	        var celdaPrecioUnitario = nuevaFila.insertCell(2);
	        var celdaPrecioTotal = nuevaFila.insertCell(3);
	        var celdaAcciones = nuevaFila.insertCell(4);

	        celdaCantidad.innerHTML = cantidad;
	        celdaDescripcion.innerHTML = descripcion;
	        celdaPrecioUnitario.innerHTML = precioUnitario.toFixed(2);
	        celdaPrecioTotal.innerHTML = (cantidad * precioUnitario).toFixed(2);
	        celdaAcciones.innerHTML = '<button onclick="eliminarProducto(this)" class="btn btn-danger">Eliminar</button>';
	    }
	}


  function generarPrecioAleatorio() {
	    // Generar un precio aleatorio entre 1 y 10
	    var precioAleatorio = (Math.random() * (10 - 1) + 1).toFixed(2); // Redondear a 2 decimales

	    // Asignar el precio aleatorio al campo del precio unitario
	    document.getElementById('inputPUnitario').value = precioAleatorio;
	}


  function eliminarProducto(btn) {
	    var fila = btn.parentNode.parentNode;
	    fila.parentNode.removeChild(fila);
	}
  function guardarFactura() {
	    // Aquí iría tu código para guardar los datos de la factura, por ejemplo:
	    // enviarDatosAlServidor(datosDeLaFactura);

	    // Suponiendo que todo va bien, muestra la alerta:
	    alert("Factura guardada correctamente");
	}

  function validateInput(input) {
    // Elimina cualquier car�cter que no sea una letra del alfabeto
    input.value = input.value.replace(/[^a-zA-Z\s]/g, '');
  }
  function validateInputNumeros(input) {
	    // Elimina cualquier car�cter que no sea un d�gito num�rico
	    input.value = input.value.replace(/[^0-9]/g, '');
	}
  </script>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript" src="Recrso.js"></script>
</body>
</html>