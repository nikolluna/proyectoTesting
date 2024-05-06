<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrarse</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Registrarse</h1>
    <form action="ControladorRegistrar" method="post" onsubmit="return validarFormulario()">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="correo" required>
        </div>
        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="contra" required>
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirmar Contraseña:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>
        </div>
        <div class="form-group">
            <button type="submit">Registrarse</button>
        </div>
    </form>
</body>
<script>
        function validarFormulario() {
            var password = document.getElementById("contra").value;
            var confirmarPassword = document.getElementById("confirm_password").value;

            if (password != confirmarPassword) {
                alert("Las contraseñas no coinciden");
                return false;
            }

            return true;
        }
</script>
</html>
