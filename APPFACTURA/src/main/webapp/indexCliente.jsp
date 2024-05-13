<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Clientes</title>
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
                        <a class="nav-link" href="" onclick="showSection('registerProduct')">Registrar Producto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="" onclick="showSection('registerClient')">Registrar Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="" onclick="showSection('registerSeller')">Registrar Vendedor</a>
                    </li>
                </ul>
            </div>
        </div>
      </nav>
    <div class="container mt-5">
        <h2 class="mb-3">Registro de Clientes</h2>
        <form id="clientForm">
            <div class="mb-3">
                <label for="clientRUC" class="form-label">RUC</label>
                <input type="text" class="form-control" id="clientRUC" pattern="\\d{11}" title="El RUC debe contener 11 dígitos." required>
            </div>
            <div class="mb-3">
                <label for="clientName" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="clientName" pattern="[a-zA-ZÀ-ÿ\s]+" title="El nombre no debe contener números o caracteres especiales." required>
            </div>
            <div class="mb-3">
                <label for="clientLastName" class="form-label">Apellido</label>
                <input type="text" class="form-control" id="clientLastName" pattern="[a-zA-ZÀ-ÿ\s]+" title="El apellido no debe contener números o caracteres especiales." required>
            </div>
            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="scriptCliente.js"></script>
</body>
</html>
    