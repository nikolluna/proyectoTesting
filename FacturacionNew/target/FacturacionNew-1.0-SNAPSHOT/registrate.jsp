<%-- 
    Document   : registrate
    Created on : May 15, 2024, 6:15:48 PM
    Author     : saman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de Usuario Factura</title>
<!-- Agregar Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    .form-container {
        background: #f7f7f7;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        width: 40%; /* Aproximadamente como en la imagen */
        margin: auto;
    }
    .form-control, .btn-custom {
        font-size: 16px; /* Tamaño de letra como en la imagen */
        height: 50px; /* Altura de los inputs y botón */
    }
    .btn-custom {
        background-color: #4caf50;
        border-color: #3e8e41;
        color: white;
        width: 100%; /* Hacer que el botón sea de ancho completo */
    }
    .btn-custom:hover {
        background-color: #45a049;
        border-color: #369636;
    }
</style>
</head>
<body>
<div class="container mt-5">
    <div class="form-container">
        <form action="/FacturacionNew/ControladorRegistrar" method="post" onsubmit="return validarFormulario()">
			<div class="form-group">
			    <p class="font-weight-bold h2">Registrate</p>
			</div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="correo" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="contra" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirmar Contraseña:</label>
                <input type="password" id="confirm_password" name="confirm_password" class="form-control" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-custom">Confirmar</button>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    function validarFormulario() {
        var password = document.getElementById("password").value;
        var confirmarPassword = document.getElementById("confirm_password").value;

        if (password != confirmarPassword) {
            alert("Las contraseñas no coinciden");
            return false;
        }

        return true;
    }
</script>
<!-- Agregar Bootstrap JS y dependencias -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>