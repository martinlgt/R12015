package local;

import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		
		ArrayList<Producto> productos = new ArrayList<>();
		PSLimitado prod1 = new PSLimitado("coca-cola",5);
		PSIlimitado prod2 = new PSIlimitado("Don-Satur");
		PSLimitado prod3 = new PSLimitado("Fernet Branca",35);
		productos.add(prod1);
		productos.add(prod2);
		productos.add(prod3);
		Local local = new Local("Super-Chino",productos);
		
		local.reponer("coca-cola", 6);
		local.vender("Fernet Branca", 23);
		local.vender("coca-cola", 11);
		local.reporte();
		

	}

}
