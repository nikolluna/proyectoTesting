<%-- 
    Document   : registroVendedor
    Created on : May 16, 2024, 4:42:44?AM
    Author     : saman
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Vendedor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>	
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="menu.jsp" onclick="showSection('home')">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="registroProducto.jsp">Registrar Producto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="registroCliente.jsp">Registrar Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="" onclick="showSection('registerSeller')">Registrar Vendedor</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        <h2 class="mb-3">Registro de Vendedor</h2>
        <form id="sellerForm" action="/FacturacionNew/ControladorVendedor" method="post">
            <div class="mb-3">
                <label for="sellerDNI" class="form-label">DNI</label>
                <input type="text" class="form-control" name="dni"  id="sellerDNI" maxlength="8" oninput="validateInputNumeros(this)" title="El DNI debe contener 8 dígitos." required>
            </div>
            <div class="mb-3">
                <label for="sellerName" class="form-label">Nombres</label>
                <input type="text" class="form-control" name="nombre" id="sellerName" oninput="validateInput(this)" title="El nombre no debe contener números o caracteres especiales." required>
            </div>
            
            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
    </div>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script ></script>
</body>
</html>