import './App.css';
import { useState, useEffect } from "react";
import Axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';
import Swal from 'sweetalert2';

function App() {
  const [producto, setProducto] = useState("");
  const [cantidad, setCantidad] = useState(0);
  const [precio, setPrecio] = useState(0);
  const [facturasList, setFacturasList] = useState([]);
  const [impuesto, setImpuesto] = useState(0.18);
  const [productosEncontrados, setProductosEncontrados] = useState([]);
  const [facturaActual, setFacturaActual] = useState(null);

  useEffect(() => {
    // Cargar las facturas al cargar la página
    getFacturas();
  }, []);

  // Función para buscar productos
  const buscarProductos = (letras) => {
    if (letras.length >= 3) {
      Axios.get(`http://localhost:3001/productos/${letras}`)
        .then((response) => {
          setProductosEncontrados(response.data);
        })
        .catch((error) => {
          console.error("Error al buscar productos:", error);
        });
    }
  };

  const addFactura = () => {
    // Verificar que se haya seleccionado un producto y que la cantidad y el precio sean válidos
    if (producto.trim() === "" || cantidad <= 0 || precio <= 0) {
      Swal.fire({
        title: "Error",
        text: "Por favor, complete todos los campos correctamente.",
        icon: "error",
        timer: 2000
      });
      return;
    }

    // Calcular subtotal y total
    const subtotal = cantidad * precio;
    const total = subtotal * (1 + impuesto);

    // Crear objeto de factura
    const nuevaFactura = {
      producto: producto,
      cantidad: cantidad,
      precio: precio,
      impuesto: impuesto,
      subtotal: subtotal,
      total: total
    };

    // Guardar la factura en la base de datos
    Axios.post("http://localhost:3001/createFactura", nuevaFactura)
      .then(() => {
        // Actualizar la lista de facturas después de agregar una factura
        getFacturas();
        // Establecer la factura actualmente agregada
        setFacturaActual(nuevaFactura);
        // Limpiar los campos
        limpiarCampos();
        // Mostrar mensaje de éxito
        Swal.fire({
          title: "Factura agregada",
          text: "La factura se ha agregado correctamente.",
          icon: "success",
          timer: 2000
        });
      })
      .catch((error) => {
        // Mostrar mensaje de error
        console.error("Error al agregar factura:", error);
        Swal.fire({
          title: "Error",
          text: "Hubo un error al agregar la factura. Inténtelo de nuevo más tarde.",
          icon: "error",
          timer: 2000
        });
      });
  };

  const getFacturas = () => {
    // Obtener la lista de facturas desde la base de datos
    Axios.get("http://localhost:3001/facturas")
      .then((response) => {
        setFacturasList(response.data);
      })
      .catch((error) => {
        console.error("Error al obtener facturas:", error);
      });
  };

  const limpiarCampos = () => {
    setProducto("");
    setCantidad(0);
    setPrecio(0);
  };

  return (
    <div className="container">
      <div className="card text-center">
        <div className="card-body">
          <div className="input-group mb-3">
            <span className="input-group-text">Producto</span>
            <input
              type="text"
              className="form-control"
              value={producto}
              onChange={(e) => {
                setProducto(e.target.value);
                buscarProductos(e.target.value);
              }}
              placeholder="Nombre del producto"
            />
            <span className="input-group-text">Cantidad</span>
            <input
              type="number"
              className="form-control"
              value={cantidad}
              onChange={(e) => setCantidad(parseInt(e.target.value))}
              placeholder="Cantidad"
            />
            <span className="input-group-text">Precio</span>
            <input
              type="number"
              className="form-control"
              value={precio}
              onChange={(e) => setPrecio(parseFloat(e.target.value))}
              placeholder="Precio"
            />
            <button
              className="btn btn-success"
              onClick={addFactura}
            >
              Agregar
            </button>
          </div>
        </div>
      </div>
      {facturaActual && (
        <div className="card text-center mt-4">
          <div className="card-body">
            <h5 className="card-title">Factura Agregada</h5>
            <p className="card-text">Producto: {facturaActual.producto}</p>
            <p className="card-text">Cantidad: {facturaActual.cantidad}</p>
            <p className="card-text">Precio: {facturaActual.precio}</p>
            <p className="card-text">Impuesto: {facturaActual.impuesto}</p>
            <p className="card-text">Subtotal: {facturaActual.subtotal}</p>
            <p className="card-text">Total: {facturaActual.total}</p>
          </div>
        </div>
      )}
      <table className="table table-striped mt-4">
        <thead>
          <tr>
            <th scope="col">Producto</th>
            <th scope="col">Cantidad</th>
            <th scope="col">Precio</th>
            <th scope="col">Impuesto</th>
            <th scope="col">Subtotal</th>
            <th scope="col">Total</th>
          </tr>
        </thead>
        <tbody>
          {facturasList.map((factura, index) => (
            <tr key={index}>
              <td>{factura.producto}</td>
              <td>{factura.cantidad}</td>
              <td>{factura.precio}</td>
              <td>{factura.impuesto}</td>
              <td>{factura.subtotal}</td>
              <td>{factura.total}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
