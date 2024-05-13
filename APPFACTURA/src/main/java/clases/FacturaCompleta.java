package clases;


public class FacturaCompleta {

	 private int num_factura;
	    private String fecha;
	    private String ruc_cliente;
	    private int codigo_vendedor;
	    private String correo;
	    private Double sub_total;
	    private Double igv;
	    private Double total_factura;
	    private int codigo_item;
	    private String descripcion_item;
	    private int cantidad;
	    private Double precio_total_c;
	    
		public FacturaCompleta() {
		}
		public FacturaCompleta(int num_factura, String fecha, String ruc_cliente, int codigo_vendedor, String correo,
				Double sub_total, Double igv, Double total_factura, int codigo_item, String descripcion_item,
				int cantidad, Double precio_total_c) {
			this.num_factura = num_factura;
			this.fecha = fecha;
			this.ruc_cliente = ruc_cliente;
			this.codigo_vendedor = codigo_vendedor;
			this.correo = correo;
			this.sub_total = sub_total;
			this.igv = igv;
			this.total_factura = total_factura;
			this.codigo_item = codigo_item;
			this.descripcion_item = descripcion_item;
			this.cantidad = cantidad;
			this.precio_total_c = precio_total_c;
		}
		public int getNum_factura() {
			return num_factura;
		}
		public void setNum_factura(int num_factura) {
			this.num_factura = num_factura;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getRuc_cliente() {
			return ruc_cliente;
		}
		public void setRuc_cliente(String ruc_cliente) {
			this.ruc_cliente = ruc_cliente;
		}
		public int getCodigo_vendedor() {
			return codigo_vendedor;
		}
		public void setCodigo_vendedor(int codigo_vendedor) {
			this.codigo_vendedor = codigo_vendedor;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public Double getSub_total() {
			return sub_total;
		}
		public void setSub_total(Double sub_total) {
			this.sub_total = sub_total;
		}
		public Double getIgv() {
			return igv;
		}
		public void setIgv(Double igv) {
			this.igv = igv;
		}
		public Double getTotal_factura() {
			return total_factura;
		}
		public void setTotal_factura(Double total_factura) {
			this.total_factura = total_factura;
		}
		public int getCodigo_item() {
			return codigo_item;
		}
		public void setCodigo_item(int codigo_item) {
			this.codigo_item = codigo_item;
		}
		public String getDescripcion_item() {
			return descripcion_item;
		}
		public void setDescripcion_item(String descripcion_item) {
			this.descripcion_item = descripcion_item;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		public Double getPrecio_total_c() {
			return precio_total_c;
		}
		public void setPrecio_total_c(Double precio_total_c) {
			this.precio_total_c = precio_total_c;
		}
	    
	    
}
