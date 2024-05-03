const express = require("express");
const app = express();
const mysql = require("mysql");
const cors = require("cors");

app.use(cors());
app.use(express.json());

const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "facturacion_crud" 
});

app.post("/createFactura", (req, res) => {
  const { producto, cantidad, precio, impuesto, subtotal, total } = req.body;

  db.query(
    "INSERT INTO Facturas (producto, cantidad, precio, impuesto, subtotal, total) VALUES (?, ?, ?, ?, ?, ?)",
    [producto, cantidad, precio, impuesto, subtotal, total],
    (err, result) => {
      if (err) {
        console.log(err);
        res.status(500).json({ error: "Error al agregar la factura" });
      } else {
        res.status(201).json({ message: "Factura agregada correctamente" });
      }
    }
  );
});

// Ruta para obtener la lista de productos
app.get("/productos/:letras", (req, res) => {
    const letras = req.params.letras.toLowerCase() + "%"; 
  
    db.query(
      "SELECT * FROM Productos WHERE nombre LIKE ?",
      [letras],
      (err, result) => {
        if (err) {
          console.log(err);
          res.status(500).json({ error: "Error al buscar productos" });
        } else {
          res.status(200).json(result);
        }
      }
    );
  });
app.listen(3001, () => {
  console.log("Servidor corriendo en el puerto 3001");
});