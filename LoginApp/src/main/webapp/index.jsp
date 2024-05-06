<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginFact</title>
</head>
<body>
	<div class="container col-lg-3">
		<form action="Controlador" method="post">
			<div class="form-group">
				<img src="img/user.png" hidden="80" width="60"/>
				<p>Sistema de Ingreso</p>
			</div>
			<div class="form-group">
				<label>Correo:</label>
				<input id="txtcorreo" type="email" name="txtcorreo" placeholder="example@correo.com">
			</div>
			<div class="form-group">
				<label>Contraseña:</label>
				<input type="text" name="txtcontra" placeholder="******">
			</div>
			<input type="submit" name="accion" value="Ingresar">
		</form>
	</div>
</body>

</html>
