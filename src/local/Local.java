package local;

import java.util.ArrayList;

public class Local {
	
	private final String nombre;
	private final ArrayList<Producto> productos;
	
	public Local(final String nombre, final ArrayList<Producto> productos) {
		this.nombre = nombre;
		this.productos = productos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void reponer(final String nombreProducto, final int cant) {
		Producto prod;
		prod = validaProducto(nombreProducto,cant);
		if(esPSLimitado(prod)) {
			((PSLimitado)prod).incrementarStock(cant);
					return;
		}
		throw new IllegalArgumentException("El producto a reponer ya es de por si de stock ILIMITADO!");
	}
	
	private Producto validaProducto(final String nombreProducto, final int cant) {
		if(cant <= 0) {
			throw new IllegalArgumentException("Debe poner una cantidad valida!");
		}
		for(final Producto prod : productos) {
			if(prod.getProductoNombre().equals(nombreProducto)) {
				return prod;
				}
		}			
		throw new IllegalArgumentException("El producto no esta en la lista de productos!");
	}
	
	public void vender(final String nombreProducto, int cant) {
		Producto prod;
		prod = validaProducto(nombreProducto,cant);
		if(esPSLimitado(prod)) {
			PSLimitado p = (PSLimitado)prod;
			if(p.getStock() - cant >= 0) {
				p.decrementarStock(cant);
				p.incrementarVendidos(cant);
				return;
			}
			throw new IllegalArgumentException("No hay suficiente stock para vender!");
		}
		prod.incrementarVendidos(cant);		
	}
	
	public void reporte() {
		String str1 = new String("");
		String str2 = new String("");
		String str3 = new String("");
		for(Producto p : productos) {
			if(p.hayStock()) {
				str1 += p.getProductoNombre()+"\n";
			} else {
			str2 += p.getProductoNombre()+"\n";
			}
			str3 += p.getProductoNombre()+" "+p.getVendidos()+"\n";
		}
		System.out.println("Productos con stock:");
		System.out.println(str1);
		System.out.println("Productos sin stock: ");
		System.out.println(str2);
		System.out.println("Productos vendidos:");
		System.out.println(str3);
		reset(productos);
		
	}
	
	private void reset(ArrayList<Producto> list) {
		for(Producto p : list) {
			p.resetVendidos();
		}
	}
	
	private boolean esPSLimitado(Producto prod) {
		if(prod.getClass() == PSLimitado.class) {
			return true;
		}
		return false;
	}
}
