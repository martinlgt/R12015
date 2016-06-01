package local;

public class PSLimitado extends Producto {
	
	private int stock;
	
	public PSLimitado(final String nombre, final int stock) {
		super(nombre);
		if(stock <= 0) {
			throw new IllegalArgumentException();
		}
		this.stock = stock;
	}
	
	
	public int getStock() {
		return stock;
	}
	
	public void incrementarStock(int cant) {
		stock += cant;
	}
	
	public void decrementarStock(int cant) {
		stock -= cant;
	}
	
	public boolean hayStock() {
		if(stock > 0) {
			return true;
		}
		return false;
	}
}
