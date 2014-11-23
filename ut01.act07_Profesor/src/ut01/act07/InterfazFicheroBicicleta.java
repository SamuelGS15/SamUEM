package ut01.act07;

public interface InterfazFicheroBicicleta {
	
	public boolean guardarBici(Bicicleta bici);
	
	public Bicicleta obtenerBici(int id);
	
	public boolean modificarBici(Bicicleta bici);
	
	public boolean eliminarBici(Bicicleta bici);
	

}
