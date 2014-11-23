
public class MainProject {
	
	final static String File5 = "./resources/textoCambiar.txt";
	final static String File9 = "./resources/insultos.txt";
	
	public static void main (String [] args) {
		
		ClaseMetodos e5 = new ClaseMetodos();
		
		
		e5.fibonacciMetodo(20);
		System.out.println("1 Hecho el ejercicio de fibonacci.");
		e5.quinielaAleatoria();
		System.out.println("2 Hecho el ejercicio de quinielas.");
		e5.alineacionEquipo();
		System.out.println("3 Hecho el ejercicio de alineacion.csv.");
		e5.lorenIpsum(6, 4);
		System.out.println("4 Hecho el ejercicio de loren ipsum.");		
		e5.sustituirPalabrasTexto(File5);
		System.out.println("5 Hecho el ejercicio de sustituir palabras.");
		e5.pasarMayusculas(File5);
		System.out.println("6 Hecho el ejercicio de pasar a mayúsculas.");
		
		
		
		e5.borrarPalabrasFeas(File9);
		System.out.println("9 Hecho el ejercicio de insultos.");
		
		
	}
}
