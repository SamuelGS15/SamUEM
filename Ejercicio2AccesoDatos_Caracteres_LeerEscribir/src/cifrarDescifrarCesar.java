import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cifrarDescifrarCesar {
	static String charMin = "abcdefghijklmnopqrstuvwxyz";
	static String charMay = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static BufferedReader bf = new BufferedReader(new InputStreamReader(
			System.in));

	// Método principal
	public static void main(String[] args) {
		String salida = " ";
		int n = 0;
		try {
			
			String texto = "";
			System.out.print(":.Escribe el texto a cifrar.:");
			System.out.println("");
			texto = bf.readLine();
			System.out
					.print("Desplazamiento para el cifrado.(numero entero).: ");
			n = Integer.parseInt(bf.readLine());
			System.out.println(n);
			System.out.println("Texto: " + texto);
			salida = cifCesar(texto, n);
			System.out.println("Texto cifrado: " + salida);
			System.out.println("");
		} catch (Exception e) {
			System.out.print("Valor no valido.");
		}
		// descifrar(CadenaCifrada, Desplazamiento);
		try {
			String texto = "";
			System.out.print(":.Escribe el texto a descifrar.:");
			System.out.println("");
			texto = bf.readLine();
			System.out
					.print("Desplazamiento para el descifrado.(numero entero).: ");
			n = Integer.parseInt(bf.readLine());
			System.out.println(n);
			System.out.println("Texto: " + texto);
			salida = descifrar(salida, n);
			System.out.println("Texto descifrado: " + salida);
			System.out.println("");
		} catch (Exception e) {
			System.out.print("Valor no valido.");
		}
	}

	/**
	 * 7 Cifrado Cesar
	 * 
	 * @param entrada
	 * @param desp
	 * @return
	 */
	private static String cifCesar(String entrada, int desp) {
		String salida = "";
		for (int i = 0; i < entrada.length(); i++) {
			if ((charMin.indexOf(entrada.charAt(i)) != -1)
					|| (charMay.indexOf(entrada.charAt(i)) != -1))
				salida += (charMin.indexOf(entrada.charAt(i)) != -1) ? charMin
						.charAt(((charMin.indexOf(entrada.charAt(i))) + desp)
								% charMin.length()) : charMay.charAt((charMay
						.indexOf(entrada.charAt(i)) + desp) % charMay.length());
			else
				salida += entrada.charAt(i);
		}
		return salida;
	}

	/**
	 * 8 Descifrado Cesar
	 * 
	 * @param Cadena
	 * @param Desplazamiento
	 */
	public static String descifrar(String Cadena, int Desplazamiento) {
		int VInt = 0;
		String DCifrado = "";
		for (int i = 0; i < Cadena.length(); i++) {
			if ((Cadena.codePointAt(i) >= 65 && Cadena.codePointAt(i) <= 90)
					|| (Cadena.codePointAt(i) >= 97 && Cadena.codePointAt(i) <= 122)) {
				VInt = Cadena.codePointAt(i) - Desplazamiento;
				DCifrado = DCifrado + new Character((char) VInt).toString();
			} else {
				DCifrado = DCifrado + Cadena.charAt(i);
			}
		}
		return DCifrado;
	}
}
