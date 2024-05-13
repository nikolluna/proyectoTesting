<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginFact</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    .form-container {
        background: #f7f7f7;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        width: 40%;
        margin: auto;
    }
    .form-control {
        font-size: 16px;
        height: 50px;
    }
    .btn-ingresar {
        background-color: blue; /* Cambiado a azul */
        color: white;
        border: none;
        width: 100%;
        height: 50px;
    }
    .btn-registrar {
        background-color: #4caf50;
        border-color: #3e8e41;
        color: white;
        width: 80%; /* Reducido al 80% del ancho */
        height: 40px; /* Altura reducida */
    }
    .btn-registrar:hover {
        background-color: #45a049;
        border-color: #369636;
    }
    .center-btn {
        display: flex;
        justify-content: center;
        width: 100%;
    }
</style>
</head>
<body>
<div class="container mt-5">
    <div class="form-container">
        <form action="Controlador" method="post">
            <div class="form-group">
                <p class="font-weight-bold h2">Inicio de Sesión</p>
            </div>
            <div class="form-group">
                <label for="txtcorreo">Correo:</label>
                <input type="email" id="txtcorreo" name="txtcorreo" class="form-control" placeholder="example@correo.com" required>
            </div>
            <div class="form-group">
                <label for="txtcontra">Contraseña:</label>
                <input type="password" id="txtcontra" name="txtcontra" class="form-control" placeholder="******" required>
            </div>
            <div class="form-group">
                <button type="submit" name="accion" value= "Ingresar" class="btn btn-ingresar">Ingresar</button>
		<% 
		// Comprueba primero si el atributo "error" no es null y luego si es igual a un espacio en blanco
		if (request.getAttribute("error") != null && !request.getAttribute("error").equals(" ") &&
		request.getAttribute("error").equals("Usuario Invalido")) { 
		%>
		    <div style="color: red;"><%= request.getAttribute("error") %></div>
		<% 
		} 
		%>

        </form>
        <form action="registrate.jsp">
            <div class="form-group text-center">
                <p>No tienes una cuenta?</p>
                <div class="center-btn">
                    <button type="submit" class="btn btn-registrar">Registrar</button>
                </div>
            </div>
       
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    