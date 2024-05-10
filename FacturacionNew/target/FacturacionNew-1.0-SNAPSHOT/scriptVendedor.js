/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.getElementById('sellerForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevenir la recarga de la página
    const sellerDNI = document.getElementById('sellerDNI').value;
    const sellerName = document.getElementById('sellerName').value;
    const sellerLastName = document.getElementById('sellerLastName').value;
    
    // Mostrar mensaje de confirmación
    alert(`Vendedor registrado con DNI: ${sellerDNI}, Nombre: ${sellerName}, Apellido: ${sellerLastName}.`);
    
    // Borrar los campos del formulario
    document.getElementById('sellerDNI').value = '';
    document.getElementById('sellerName').value = '';
    document.getElementById('sellerLastName').value = '';
});
