package local;

public abstract class Producto {
	
	private final String nombre;
	private int vendidos = 0;
	
	public Producto(final String nombre) {
		this.nombre = nombre;
	}
	
	public String getProductoNombre() {
		return nombre;
	}
	
	public void incrementarVendidos(final int cant) {
		vendidos += cant;
	}
	
	public int getVendidos() {
		return vendidos;
	}
	
	public void resetVendidos() {
		vendidos = 0;
	}
	
	public abstract boolean hayStock();
}
