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

  useEffect(() => {
    // Cargar las facturas al cargar la página
    getFacturas();
  }, []);

  // Función para buscar productos
  const buscarProductos = (letras) => {
    if (letras.length >= 3) {
      Axios.get(http://localhost:3001/productos/${letras})
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