<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="10">   
    <title>Registro de Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body >
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
                        <a class="nav-link" href="registroCliente.jsp" >Registrar Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="registroVendedor.jsp">Registrar Vendedor</a>
                    </li>
                </ul>
            </div>
        </div>
      </nav>
    <div class="container mt-5">
        <h2 class="mb-3">Registro de Producto</h2>
        <form id="productForm" action="ControladorArticulos" method="post">
            <div class="mb-3">
                <label for="productName" class="form-label">Nombre del Producto</label>
                <input type="text" class="form-control" name="productName" pattern="[A-Za-z\s]+" id="productName" required>
                <small id="productNameHelp" class="form-text text-muted">Ingrese solo letras y espacios. Ejemplo: Zapatos deportivos</small>
            </div>
            <div class="mb-3">
                <label for="productPrice" class="form-label">Precio</label>
                <input type="text" class="form-control" name="productPrice" pattern="\d+(\.\d{1,2})?" id="productPrice" required>
                <small id="productPriceHelp" class="form-text text-muted">Ingrese un número decimal con hasta dos decimales. Ejemplo: 25.99</small>
            </div>
            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="scriptProduto.js"></script>
</body>
</html>
