/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.getElementById('clientForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevenir la recarga de la página
    const clientRUC = document.getElementById('clientRUC').value;
    const clientName = document.getElementById('clientName').value;
    const clientLastName = document.getElementById('clientLastName').value;
    
    // Mostrar mensaje de confirmación
    alert(`Cliente registrado con RUC: ${clientRUC}, Nombre: ${clientName}, Apellido: ${clientLastName}.`);
    
    // Borrar los campos del formulario
    document.getElementById('clientRUC').value = '';
    document.getElementById('clientName').value = '';
    document.getElementById('clientLastName').value = '';
});
