const formDetalle = document.getElementById("formDetalle");
const inputCantidad = document.getElementById("inputCantidad");
const selectDescripcion = document.getElementById("selectDescripcion");
const inputPUnitario = document.getElementById("inputPUnitario");
const inputPTotal = document.getElementById("inputPTotal");
const cuerpoTabla = document.getElementById("cuerpoTabla");
const btnGuardar = document.getElementById("btnGuardar");
const inputNombre = document.getElementById("inputNombre");
const inputRuc = document.getElementById("inputRuc");
const inputNro = document.getElementById("inputNro");
const inputDireccion = document.getElementById("inputDireccion");
const inputFecha = document.getElementById("inputFecha");
const formCabecera = document.getElementById("formCabecera");


  let facturas = [];
 let arregloDetalle = [];
 let arregloProductos = [
    { id: 301, nombre: 'Laptop HP Envy', precio: 899.99 },
    { id: 302, nombre: 'iPhone 13 Pro', precio: 1099.99 },
    { id: 303, nombre: 'Samsung Galaxy S22', precio: 899.99 },
    { id: 304, nombre: 'Sony Bravia 4K TV', precio: 699.99 },
    { id: 305, nombre: 'MacBook Air', precio: 999.99 },
    { id: 306, nombre: 'Dell XPS 13', precio: 1099.99 }
];


const llenarProductos = () => {
    arregloProductos.forEach((p) => {
        const option = document.createElement("option");
        option.value = p.id;
        option.innerText = p.nombre;
        selectDescripcion.appendChild(option);
    });
};

llenarProductos();

const getNombreProductoById = (id) => {
    const objProducto = arregloProductos.find((p) => p.id === parseInt(id, 10));
    return objProducto ? objProducto.nombre : 'Producto no encontrado';
};


// const getPrecioProductoById = (id) => {
//     const objProducto = arregloProductos.find((p) => {
//         if (p.id === id) {
//             return p;
//         }
//     });
//     return objProducto.precio;
// };



 const redibujarTabla = () => {
    cuerpoTabla.innerHTML = ""; // Limpia el contenido actual de la tabla
    arregloDetalle.forEach((detalle) => {
      let fila = document.createElement("tr");
      fila.innerHTML = `<td>${detalle.cant}</td>
                        <td>${getNombreProductoById(detalle.descripcion)}</td>
                        <td>${detalle.pUnit}</td>
                        <td>${detalle.pTotal}</td>`;
      let tdEliminar = document.createElement("td");
      let botonEliminar = document.createElement("button");
      botonEliminar.classList.add("btn", "btn-danger");
      botonEliminar.innerText = "Eliminar";
      botonEliminar.onclick = () => {
        eliminarDetalleById(detalle.descripcion);
      };
      tdEliminar.appendChild(botonEliminar);
      fila.appendChild(tdEliminar);
      cuerpoTabla.appendChild(fila); // Agrega la fila al cuerpo de la tabla
    });
  };
  const eliminarDetalleById = (id) => {
    arregloDetalle = arregloDetalle.filter(detalle => {
        if (id !== detalle.descripcion) {
            return detalle;
        }
    });
    redibujarTabla();
};

  
const agregarDetalle = (objDetalle) =>{
    const resultado = arregloDetalle.find((detalle) => {
    if (objDetalle.descripcion === detalle.descripcion) {
        return detalle;
    }
    });

    if (resultado) {
    arregloDetalle = arregloDetalle.map((detalle) => {
        if (+detalle.descripcion === +objDetalle.descripcion) {
        return {
 cant: +detalle.cant + +objDetalle.cant,
            descripcion: detalle.descripcion,
            pUnit: detalle.pUnit,
            pTotal: (+detalle.cant + +objDetalle.cant) * +detalle.pUnit
        };
        }
        return detalle;
    });
    } else {
    arregloDetalle.push(objDetalle);
    }
}
formDetalle.onsubmit = (e) => {
    e.preventDefault();
    // Creando objeto detalle
    const objDetalle = {
        cant: inputCantidad.value,
        descripcion: selectDescripcion.value,
        pUnit: inputPUnitario.value,
        pTotal: inputPTotal.value,
    };
    agregarDetalle(objDetalle);
    redibujarTabla();
};

// Crear el objeto de la cabecera de la factura
btnGuardar.onclick = () => {
    let objFactura = {
        nombre: inputNombre.value,
        direccion: inputDireccion.value,
        fecha: inputFecha.value,
        ruc: inputRuc.value,
        nro: inputNro.value,
        detalle: arregloDetalle,
    };
    console.log(objFactura);
    facturas.push(objFactura);
    formCabecera.reset();
    formDetalle.reset();
    // guardarlo en el localStorage
    localStorage.setItem("facturas", JSON.stringify(facturas));
    arregloDetalle = [];
    redibujarTabla();
    enviarFactura(objFactura);
};

const enviarFactura = (factura) => {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/ControladorArticulos", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Datos enviados correctamente");
        }
    };
    console.log(factura);
    xhr.send(JSON.stringify(factura));
};



let preciosUnitarios = {};
arregloProductos.forEach(producto => {
    preciosUnitarios[producto.id] = producto.precio;
});

selectDescripcion.addEventListener('change', () => {
    const valor = selectDescripcion.value;
    if (valor !== '0') {
        inputPUnitario.value = preciosUnitarios[valor];
    } else {
        inputPUnitario.value = '';
    }
});

inputCantidad.addEventListener('input', calcularPrecioTotal);

function calcularPrecioTotal() {
    const cantidad = parseInt(inputCantidad.value) || 0;
    const precioUnitario = parseFloat(inputPUnitario.value) || 0;
    const precioTotal = cantidad * precioUnitario;
    inputPTotal.value = precioTotal.toFixed(2);
}
