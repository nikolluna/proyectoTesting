package clases;

public class DetalleFactura {
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private double precioTotal;

    // Getters y setters

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "DetalleFactura [descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + ", cantidad="
                + cantidad + ", precioTotal=" + precioTotal + "]";
    }
}
