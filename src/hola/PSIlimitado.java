package local;

public class PSIlimitado extends Producto {
	
	public PSIlimitado(final String nombre) {
		super(nombre);
	}
	
	public boolean hayStock() {
		return true;
	}
}
