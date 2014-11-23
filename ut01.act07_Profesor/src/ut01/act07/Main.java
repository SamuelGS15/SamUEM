package ut01.act07;

public class Main {
	
	public static void main(String [] args) {
		Bicicleta bici = new Bicicleta(1, true,"01/01/2014", 10);
		
		System.out.println(bici.toString());
		
		bicicletaManager bM = new bicicletaManager();
		
		bM.dummy();
		bM.imprimir();
		
		
		if(bM.guardarBici(bici)){
			System.out.println("La bicicleta se guardó correctamente.");
		}
		
	}
	

}
