import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {

	
	private final static String ERROR_FILE_NOT_FOUND ="Fichero no encontrado";
	private final static String ERROR_LECTURE ="Error de lectura";
	/*
	 * Utilizando el fichero proporcionado �QUIJOTE.TXT� que contiene letras
	 * may�sculas y min�sculas, con o sin acento o di�resis, cifras y dem�s
	 * caracteres imprimibles posibles, adem�s de fines de l�nea y fin de
	 * fichero. Contar y mostrar en pantalla el n�mero de caracteres.
	 */
	/*
	 * 
	 * Method that counts all the characters of a given file
	 */

	public int countCharacter(String pathTextFile) {

		FileReader readStream = null;
		int numberCharacters = 0;

		try {
			readStream = new FileReader(new File(pathTextFile));

			while (readStream.read() != -1) {
				++numberCharacters;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (readStream != null) {
				try {
					if (readStream != null)
						readStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return numberCharacters;
	}

	// El ejercicio anterior con un bufferedreader
	static final int TAM_BUFFER = 1024;

	public int countCharacter(String pathTextFile, int n) {

		BufferedReader readStream = null;
		String buffer;
		int numberCharacters = 0;

		try {
			// Es un tama�o de control del buffer, es bueno seccionar para que
			// todas las l�neas
			// las pueda leer
			BufferedReader readstream = new BufferedReader(new FileReader(
					pathTextFile), TAM_BUFFER);

			while ((buffer = readStream.readLine()) != null) {
				numberCharacters += buffer.length() + 1;
			}
			// quitamos el �ltimo caracter
			--numberCharacters;
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (readStream != null) {
				try {
					if (readStream != null)
						readStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;
	}

	// Ejercicio 1. Contar caracteres

	public int contarCaracteres(String pathTextFile) {

		// Utilizo la clase FileReader para leer un archivo .txt, inicializo el
		// objeto como 'vac�o'
		FileReader archivo = null;
		// inicializo un contador para poder contar los caracteres que hay
		int numcaracteres = 0;

		try {
			// Introduzco todo el archivo .txt mediante una direcci�n que
			// introduzco
			// por par�metro en el m�todo en la variable tipo FileReader
			// denominada archivo
			archivo = new FileReader(pathTextFile);

			// Utilizo un bucle cuya condici�n es que si no hay m�s valores se
			// mostrar� el valor de
			// -1 para salir del bucle
			// mientras haya caracteres se aumentar� el valor del contador
			while (archivo.read() != -1) {
				numcaracteres++;
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		return numcaracteres;
	}

	/*
	 * Esto es para comprobar que es una letra.
	 * 
	 * public boolean isLetter (char c) { char letter =
	 * Character.toLowerCase(c); boolean isLetter = false; if ((letter > 'a' &&
	 * letter < 'z') || (letter == '�') || (letter == '�')) ...) { isLetter =
	 * true; } }
	 */

	/**
	 * Method that counts all the characters of a given file
	 * 
	 * @param pathTextFile
	 * @return
	 */
	// Contar el n�mero de caracteres
	public int countWords(String pathTextFile) {

		BufferedReader readStream = null;
		String buffer;
		int numberWords = 0;

		boolean readingWord = false;
		char letter;

		try {
			// Es un tama�o de control del buffer, es bueno seccionar para que
			// todas las l�neas
			// las pueda leer
			readStream = new BufferedReader(new FileReader(pathTextFile),
					TAM_BUFFER);

			while ((buffer = readStream.readLine()) != null) {

				for (int i = 0; i < buffer.length(); i++) {
					// recorro la l�nea caracter a caracter
					letter = buffer.charAt(i);
					if (!readingWord && Character.isLetter(letter)) {
						readingWord = true;
					} else if (readingWord && Character.isLetter(letter)) {
						// do nothing
					} else if (readingWord && !Character.isLetter(letter)) {
						readingWord = false;
						++numberWords;
					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (readStream != null) {
				try {
					if (readStream != null)
						readStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return numberWords;
	}

	/**
	 * Method that counts all the words of a given file
	 * 
	 * @param pathTextFile
	 * @return
	 */
	// Contar el n�mero de caracteres
	public int count(String pathTextFile) {

		BufferedReader readStream = null;
		String buffer;
		int numberWords = 0;

		boolean readingWord = false;
		char letter;

		try {
			// Es un tama�o de control del buffer, es bueno seccionar para que
			// todas las l�neas
			// las pueda leer
			readStream = new BufferedReader(new FileReader(pathTextFile),
					TAM_BUFFER);

			while ((buffer = readStream.readLine()) != null) {

				for (int i = 0; i < buffer.length(); i++) {
					// recorro la l�nea caracter a caracter
					letter = buffer.charAt(i);
					if (!readingWord && Character.isLetter(letter)) {
						readingWord = true;
					} else if (readingWord && Character.isLetter(letter)) {
						// do nothing
					} else if (readingWord && !Character.isLetter(letter)) {
						readingWord = false;
						++numberWords;
					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (readStream != null) {
				try {
					if (readStream != null)
						readStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return numberWords;
	}

	/**
	 * M�todo que cuenta el n�mero de filas desde un fichero introducido como
	 * par�metro, este par�metro se introduce en el programa principal
	 * 
	 * @param path
	 * @return
	 */
	public int countLines(String path) {

		/*
		 * Declaramos un objeto de la clase BufferedReader, porque tiene un
		 * m�todo que lee l�nea a l�nea. Esto lo hacemos porque vamos a contar
		 * l�neas enteras del fichero.
		 */
		BufferedReader flujo = null;

		int linesCounted = 0;

		int numletra;
		char caracter;
		try {
			/*
			 * Creamos el objeto de la clase BufferedReader pas�ndole un objeto
			 * del tipo FileReader al que se le ha pasado el par�metro del
			 * m�todo Este objeto est� en rojo en un principio porque tiene que
			 * estar rodeado de un try-catch
			 */
			flujo = new BufferedReader(new FileReader(path));

			/*
			 * Pongo un while, donde el objeto flujo utiliza el m�todo
			 * readLine() Este m�todo va leyendo l�nea a liena gracias al bucle
			 * while
			 */
			while (flujo.readLine() != null) {

				/*
				 * Una vez que estoy en una l�nea, lo recorro con un bucle while
				 * caracter a caracter saldr� de este bucle cuando no haya
				 * ning�n caracter en la l�nea cuyo valor ser� -1 volviendo al
				 * bucle while anterior. Cada caracter es almacenado en la
				 * variable numletra
				 */
				//while ((numletra = flujo.read()) != -1) {
					/*
					 * Como la variable numletra es un n�mero entero en formato
					 * UNICODE, debo convertirlo a caracter, por eso hago un
					 * casting de numletra a caracter
					 */
					//caracter = (char) numletra;
					/*
					 * Si la varible caracter corresponde con un retorno de
					 * carro \r o salto de l�nea \n contar� que hay una l�nea
					 */

					//if ((caracter == '\r') || (caracter == '\n'))
						linesCounted++;

				//}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*
			 * En este finally el programa siempre va a entrar tras una
			 * estructura try-catch Con el siguiente if comprobamos que el
			 * objeto flujo, que era BufferedReader no est� vac�o, porque si
			 * estaba lleno se ha operado con �l y como hay que cerrarlo para
			 * que otro usuario u otro programa pueda utilizarlo se cierra con
			 * el m�todo flujo.close()
			 */
			if (flujo != null) {
				try {

					if (flujo != null)
						flujo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return linesCounted;
	}

	/**
	 * Contar el n�mero de letras (todas incluidas min�sculas, may�sculas,
	 * acentuadas, etc., pero no los signos de puntuaci�n, cifras y otros
	 * caracteres).
	 * 
	 */
	public int contarLetrasAbc(String ruta) {

		BufferedReader flujo = null;

		String cadena;
		int contadorLetras = 0;
		char caracter;

		try {
			flujo = new BufferedReader(new FileReader(ruta));

			while ((cadena = flujo.readLine()) != null) {

				for (int i = 0; i < cadena.length(); i++) {
					caracter = cadena.charAt(i);

					if (String.valueOf(caracter).matches("[a-zA-Z�-��-�]")) {
						contadorLetras++;
					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flujo != null) {
				try {
					flujo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return contadorLetras;

	}

	/**
	 * Cuenta las letras que solo est�n en min�sculas
	 * 
	 * @param ruta
	 * @return
	 */
	public int contarLetrasMin(String ruta) {

		BufferedReader flujo = null;

		String cadena;
		int contadorLetras = 0;
		char caracter;

		try {
			flujo = new BufferedReader(new FileReader(ruta));

			while ((cadena = flujo.readLine()) != null) {

				for (int i = 0; i < cadena.length(); i++) {
					caracter = cadena.charAt(i);

					if ((String.valueOf(caracter).matches("[a-z]"))
							|| (String.valueOf(caracter).matches("[�-�]"))) {
						contadorLetras++;
					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flujo != null) {
				try {
					flujo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return contadorLetras;

	}

	/**
	 * Cuenta la frecuencia de las letras que son vocales
	 * 
	 * @param ruta
	 * @return
	 */
	public String contarLetrasVocales(String ruta) {

		BufferedReader flujo = null;

		String solucion = "a";

		String cadena;
		int contadorA = 0;
		int contadorE = 0;
		int contadorI = 0;
		int contadorO = 0;
		int contadorU = 0;
		char caracter;

		try {
			flujo = new BufferedReader(new FileReader(ruta));

			while ((cadena = flujo.readLine()) != null) {

				for (int i = 0; i < cadena.length(); i++) {
					caracter = cadena.charAt(i);

					if (String.valueOf(caracter).matches("[aA]")) {
						contadorA++;
					}
					if (String.valueOf(caracter).matches("[eE]")) {
						contadorE++;
					}
					if (String.valueOf(caracter).matches("[iI]")) {
						contadorI++;
					}
					if (String.valueOf(caracter).matches("[oO]")) {
						contadorO++;
					}
					if (String.valueOf(caracter).matches("[uU]")) {
						contadorU++;
					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flujo != null) {
				try {
					flujo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		solucion = "La vocal A est� " + Integer.toString(contadorA)
				+ ". La vocal E est� " + Integer.toString(contadorE)
				+ ". La vocal I est� " + Integer.toString(contadorI)
				+ ". La vocal O est� " + Integer.toString(contadorO)
				+ ". La vocal U est� " + Integer.toString(contadorU);
		return solucion;

	}

	/**
	 * Contar las letras min�sculas puras
	 * 
	 * @param ruta
	 * @return
	 */

	public int letrasMinPuras(String ruta) {

		FileReader archivo = null;
		int c;
		char dato;
		int sol = 0;

		try {
			archivo = new FileReader(ruta);

			while ((c = archivo.read()) != -1) {
				dato = (char) c;
				if (String.valueOf(dato).matches("[a-z]")) {
					sol++;
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		return sol;
	}

	/**
	 * Contar letras may�sculas
	 * 
	 * @param ruta
	 * @return
	 */
	public int letrasMay(String ruta) {

		FileReader archivo = null;
		int c;
		char dato;
		int sol = 0;

		try {
			archivo = new FileReader(ruta);

			while ((c = archivo.read()) != -1) {
				dato = (char) c;
				if ((String.valueOf(dato).matches("[A-Z]"))
						|| String.valueOf(dato).matches("[�-�]")) {
					sol++;
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		return sol;
	}

	/**
	 * Contar palabras
	 * 
	 * @param ruta
	 * @return
	 */

	public int contarPalabras(String ruta) {

		FileReader archivo = null;
		int c;
		int sol = 0;

		try {
			archivo = new FileReader(ruta);

			while ((c = archivo.read()) != -1) {
				char dato = (char) c;

				if (dato == ' ') {
					sol++;
				}
			}

			sol++;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		return sol;
	}

	/**
	 * Este m�todo cuenta las palabras que acaban en i�n
	 * 
	 * @param ruta
	 * @return
	 */

	public int contarPalabrasSufijo(String ruta, String suffix){
		
		BufferedReader archivo=null;
		String word= "";
		int contador = 0;
		int cuenta = 0;
		
		
		
		try {
			archivo=new BufferedReader(new FileReader(ruta));
			String linea;
			char caracter;
			
					
			while((linea=archivo.readLine()) != null) {
				
				
				for(int i=0; i<linea.length();i++) {
					caracter = linea.charAt(i);
					if((String.valueOf(caracter).matches("[A-Za-z�-��-�]"))) {
						word += caracter;
						
					} else {
						if (word.endsWith(suffix)){
							contador++;
						}
						word = "";
					}
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			System.err.println(ERROR_FILE_NOT_FOUND);
		} catch (IOException e) {
			System.err.println(ERROR_LECTURE);
		} finally {
			if (archivo!=null) {
				try {
					archivo.close();
				} catch (IOException e) {
					System.err.println(ERROR_LECTURE);
				}
			}
		}
		
		
		
		return contador;
	}

	/**
	 * Elimina los acentos de una l�nea
	 *
	 * @param line
	 * @return
	 */
	private String replaceAllAccents(String line) {
		return line.replaceAll("�", "A").replaceAll("�", "E")
				.replaceAll("�", "I").replaceAll("�", "O").replaceAll("�", "U")
				.replaceAll("�", "U");
	}

	public void writeUppercaseFile(final String path, final String pathUppercase) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				BufferedReader streamIn = null;
				BufferedWriter streamOut = null;
				String line;
				try {
					streamIn = new BufferedReader(new FileReader(path));
					streamOut = new BufferedWriter(
							new FileWriter(pathUppercase));
					while ((line = streamIn.readLine()) != null) {
						line = replaceAllAccents(line.toUpperCase());
						streamOut.write(line);
						streamOut.newLine();
					}
				} catch (FileNotFoundException e) {
					System.err.println(ERROR_FILE_NOT_FOUND);
				} catch (IOException e) {
					System.err.println("Error I/O");
				} finally {
					if (streamIn != null) {
						try {
							streamIn.close();
						} catch (IOException e) {
							System.err.println("Error I/O");
						}
					}
					if (streamOut != null) {
						try {
							streamOut.close();
						} catch (IOException e) {
							System.err.println("Error I/O");
						}
					}
				}
			}
		});
		t.start();
	}
	
	/**
	 * Cuenta diptongos
	 * @param path
	 * @return
	 */
	public int contarDiptongo(String path) {
		
		int contador=0;
		
		BufferedReader file = null;
		String line;
		char character;
		String word = "";
		String [] diptongo = {"ai","ia","au","ua","ei","ie","eu","ue","oi","io","ou","uo","iu","ui"};		
			
		
		try {
			file= new BufferedReader(new FileReader(path));
			
			while((line=file.readLine()) != null) {
				
				for(int i=0; i<line.length();i++){
					
					character=line.charAt(i);
					
					if(character != ' ') {
						word += String.valueOf(character);
						
						for(int j=0;j<diptongo.length;j++) {
							
							
							
							if((word.indexOf(diptongo[j])) != -1){
								contador++;
								word = "";
							}
						}
						
					} else {
						word = "";
					}
					
				}
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.err.println(ERROR_FILE_NOT_FOUND);
		} catch (IOException e) {
			System.err.println(ERROR_LECTURE);
		} finally {
			if(file != null) {
				try {
					file.close();
				} catch (IOException e) {
					System.err.println(ERROR_LECTURE);
				}
			}
		}
		
		return contador;
	}
	
	

/**
 * 
 * Encontrar el primer triptongo
 * @param path
 * @return
 */


public int contarTriptongo(String path) {
	
	int contador=0;
	
	BufferedReader file = null;
	String line;
	char character;
	String word = "";
	String [] diptongo = {"ai","ia","au","ua","ei","ie","eu","ue","oi","io","ou","uo","iu","ui"};		
		
	
	try {
		file= new BufferedReader(new FileReader(path));
		
		while((line=file.readLine()) != null) {
			
			for(int i=0; i<line.length();i++){
				
				character=line.charAt(i);
				
				if(character != ' ') {
					word += String.valueOf(character);
					
					for(int j=0;j<diptongo.length;j++) {
						
						
						
						if((word.indexOf(diptongo[j])) != -1){
							contador++;
							word = "";
						}
					}
					
				} else {
					word = "";
				}
				
			}
			
		}
		
		
		
	} catch (FileNotFoundException e) {
		System.err.println(ERROR_FILE_NOT_FOUND);
	} catch (IOException e) {
		System.err.println(ERROR_LECTURE);
	} finally {
		if(file != null) {
			try {
				file.close();
			} catch (IOException e) {
				System.err.println(ERROR_LECTURE);
			}
		}
	}
	
	return contador;
}



}
