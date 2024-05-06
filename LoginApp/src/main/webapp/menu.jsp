<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			    <input type="text" class="form-control" placeholder="Ejm: 002" id="inputNro" name="inputNroe" oninput="validateInputNumeros(this)"/>
			  </div>
			  <div class="form-group col-md-12">
			        <input type="submit" class="btn btn-primary btn-lg btn-block" value="Enviar">
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
	          <div class="form-group col-md-2">
	            <label for="inputCantidad">Cantidad</label>
	            <input type="number" class = "form-control" id="inputCantidad">
	          </div>
	          <div class="form-group col-md-5">
	            <label for="selectDescripcion">Descripcion</label>
	            <select id="selectDescripcion" class="form-control">
	            	<option value="0">---Seleccione---</option>
	            	<!-- <option value="1">Producto 1</option>
	            	<option value="2">Producto 3</option>
	            	<option value="3">Producto 4</option>
	            	<option value="4">Producto 5</option>
	            	<option value="5">Producto 6</option> -->
	            </select>
	          </div>
	          <div class="form-group col-md-2">
	            <label for="inputPUnitario">P. Unit</label>
	            <input type="number" class = "form-control" id="inputPUnitario"
                disabled
                />
	          </div>
	          <div class="form-group col-md-2">
	            <label for="inputPTotal">P. Total</label>
	            <input type="number" class = "form-control" id="inputPTotal"
                disabled
                />
	          </div>
	          <div class="form-group col-md-1">
	            <button class="btn btn-warning btn-bajar" type="submit">
				  Agregar 
				</button>
	          </div>
	        </form>
	      </div>
	    </div>
	  </div>
	  <div class="col mt-4">
    <button class="btn btn-dark btn-lg" id ="btnGuardar">Guardar Factura</button>
	</div>
	</section>
	<section class="row mt-4">
	  <div class="col">
	    <table class="table text-center">
	      <thead>
	        <tr>
	          <th>Cantidad</th>
	          <th>Descripción</th>
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
  function validateInput(input) {
    // Elimina cualquier carácter que no sea una letra del alfabeto
    input.value = input.value.replace(/[^a-zA-Z\s]/g, '');
  }
  function validateInputNumeros(input) {
	    // Elimina cualquier carácter que no sea un dígito numérico
	    input.value = input.value.replace(/[^0-9]/g, '');
	}
  </script>
  <script type="text/javascript" src="Recurso.js"></script>
</body>
</html>