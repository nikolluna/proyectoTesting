/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author saman
 */

public class Empleado {
    private String dni;
    private String nombreVendedor;
    private String direccion; // Añadido campo para la dirección

    // Constructor con parámetros
    public Empleado(String dni, String nombreVendedor, String direccion) {
        this.dni = dni;
        this.nombreVendedor = nombreVendedor;
        this.direccion = direccion;
    }

    // Constructor vacío
    public Empleado() {
    }

    // Getter y setter para DNI
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Getter y setter para nombre
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    // Getter y setter para dirección
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}