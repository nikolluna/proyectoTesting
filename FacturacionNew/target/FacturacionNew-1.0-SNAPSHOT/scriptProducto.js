/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.getElementById('productForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevenir la recarga de la página
    const productName = document.getElementById('productName').value;
    const productPrice = document.getElementById('productPrice').value;
    
    // Muestra un mensaje de confirmación
    alert(`Producto: ${productName}, Precio: $${productPrice} ha sido registrado.`);
    
    // Borrar los campos del formulario
    document.getElementById('productName').value = '';
    document.getElementById('productPrice').value = '';
});
