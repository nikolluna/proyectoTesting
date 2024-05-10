<%-- 
    Document   : menu.jsp
    Created on : May 15, 2024, 7:31:01 PM
    Author     : saman
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	      <form action="/FacturacionNew/Controlador" method="post">
	     	 <input type="submit" name="accion" class="btn btn-primary btn-lg btn-block" value="Refrescar Factura">
	      </form>
	      </div>
            <form class="row" id ="formCabecera" action="/FacturacionNew/ControladorCabecera" method="post">
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
			  <div class="card-footer d-flex justify-content-end">
                    <div>
                        <label for="inputCantidad">Sub. Total: </label>
                        <input type="text" name ="SubTotalFactura" value="${String.format('%.2f', totalpag - (totalpag * 0.18))}" class="form-control">
                    </div>
                    <div>
                        <label for="inputCantidad">Igv(18%): </label>
                        <input type="text" name ="IGV" value="${String.format('%.2f', totalpag * 0.18)}" class="form-control">
                    </div>
                    <div>
                        <label for="inputCantidad">Total: </label>
                        <input type="text" name ="TotalFactura" value ="${String.format('%.2f', totalpag)}" class="form-control">
                    </div>
                </div>
                <div class="form-group col-md-12">
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
                  <form class="row" action="/FacturacionNew/Controlador" id="formDetalle">
	          <div class="form-group col-md-5">
	            <label for="selectDescripcion">Seleccion de productos</label>
	            <select id="selectDescripcion" name="descripcion" class="form-control">
				    <option value="0">---Seleccione---</option>
				    <% 
                                        int i;
					    List<String> descripciones = (List<String>) request.getSession().getAttribute("descripciones");
					    List<Double> precios = (List<Double>) request.getSession().getAttribute("precios");
					    if (descripciones != null && precios != null && descripciones.size() == precios.size()) {
					        for (i = 0; i < descripciones.size(); i++) { 
					    %>
					            <option value="<%= descripciones.get(i) %>"><%= descripciones.get(i) %></option>
					    <% 
					        } 
					    } 
					    %>
                    </select>
                     <button type="submit" class="btn btn-primary" name="accion" value="BuscarPrecio"> Obtener</button>
	          </div>
                  <div class="form-group col-md-2">
	            <label for="Producto">Producto</label>
	            <input type="text" name="desProducto" value="${articulo.getDescripcion()}" class = "form-control" id="inputCantidad">
                  </div>
	          <div class="form-group col-md-2">
	            <label for="inputCantidad">Cantidad</label>
	            <input type="number" name="cantidad" class = "form-control" id="inputCantidad" min="1">
                  </div>
                  <div class="form-group col-md-2">
                    <label for="inputPUnitario">P. Unit</label>
                    <input type="text" name="punit" value="${articulo.getPrecio_u()}" class="form-control" id="inputPUnitario">
                                           
                  </div>
                    
	          <div class="form-group col-md-1">
	            <button class="btn btn-warning btn-bajar" type="submit" name="accion" value="Agregar">
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
                  <c:forEach var="list" items="${lista}">
                      <tr>
                  <td>${list.getCantidad()}</td>
                  <td>${list.getDescripcion()}</td>
                  <td>${list.getPrecioUnitario()}</td>
                  <td>${list.getPrecioTotal()}</td>
                  <td>
                       <form action="Controlador" method="post">
                            <input type="hidden" name="descripcionEliminar" value="${list.getDescripcion()}">
                            <button type="submit" class="btn btn-danger" name="accion" value="Eliminar">Eliminar</button>
                        </form>
                  </td>
                      </tr>
                  
                  </c:forEach>
              </tbody>
          
	    </table>
              
	  </div>
            
	</section>
  </main>
  <script>
  function guardarFactura() {
	    // Aquí iría tu código para guardar los datos de la factura, por ejemplo:
	    // enviarDatosAlServidor(datosDeLaFactura);

	    // Suponiendo que todo va bien, muestra la alerta:
	    alert("Factura guardada correctamente");
	}

  function validateInput(input) {
    // Elimina cualquier caracter que no sea una letra del alfabeto
    input.value = input.value.replace(/[^a-zA-Z\s]/g, '');
  }
  function validateInputNumeros(input) {
	    // Elimina cualquier caracter que no sea un d�gito num�rico
	    input.value = input.value.replace(/[^0-9]/g, '');
	}
  </script>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>