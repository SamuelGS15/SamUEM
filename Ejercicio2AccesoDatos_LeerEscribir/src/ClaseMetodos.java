import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;


public class ClaseMetodos {
	
	/**
	 * 1
	 * Metodo para crear los números de fibonacci 
	 * y la subrutina para utilizarlo
	 * @param number
	 * @return
	 */
	public static int fibonacci(int number) { 
		
		int n = 0;
		if ((number == 0) || (number == 1)) 
			n = number; 
		else 
			n = fibonacci(number - 1) + fibonacci(number - 2);
		return n;
		}
	
	public void fibonacciMetodo(int numero) {
		String File = "./resources/fibonacci.txt";
		
		FileWriter archivo=null;
		String resultado;
		
		try {
			archivo = new FileWriter(File);
			
			for (int counter = 1; counter <= numero; counter++){ 
				resultado = String.valueOf(fibonacci(counter)).concat(" ");
				archivo.write(resultado);
			}
			
			
			
		} catch (IOException e) {
			System.out.println("Error de lectura de datos.");
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					System.out.println("Error de lectura de datos.");
				}
			}
		}
		
		
	}
	
	/**
	 * 2
	 * Este método genera una quiniela aleatoria.
	 */
	public void quinielaAleatoria() {
		String File = "./resources/quiniela.txt";
		
		FileWriter archivo = null;
		int contador =1;
		Random numAleatorio = new Random();
		
		try {
			archivo = new FileWriter(File);
			
			for (int i=1; i<=15;i++) {
				
				StringBuffer texto = new StringBuffer();
				int num = numAleatorio.nextInt(2);
				String resultado=" ";
				if ((num == 0)) {
					resultado = "1";
				} else if (num == 1) {
					resultado = "X";
				} else if (num == 2) {
					resultado = "2";
				}
				
				texto.append("El resultado del partido "+contador).append(" es: ").append(resultado).append("\n");
				
				archivo.write(texto.toString());
				
				contador++;
			}	
			
			
		} catch (IOException e) {
			System.out.println("Error de lectura de datos.");
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					System.out.println("Error de lectura de datos.");
				}
			}
		}
	}
	
	/**
	 * 3
	 * Crear un archivo (CSV) con la alineación de tu equipo favorito
	 * 
	 */
	public void alineacionEquipo() {
		
		String [] alineacion = {"Casillas","Pepe","Sergio Ramos","Arbeloa", "Marcelo","Coentrao","Bale",
				"Kedhira","Kross","Cristiano Ronaldo", "Benzema"};
		
		String File = "./resources/RealMadrid.csv";
		
		
		FileWriter archivo = null;
		
		try {
			archivo = new FileWriter(File);
			
			for (int i=0; i<alineacion.length;i++) {
				StringBuffer texto = new StringBuffer();
				
				texto.append(alineacion[i]).append(";");
				
				archivo.write(texto.toString());
				
				
			}
			
		} catch (IOException e) {
			System.out.println("Error de lectura\\escritura del archivo");
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					System.out.println("Error de lectura\\escritura del archivo");
				}
			}
		}
	}
	
	/**
	 * 4
	 * Crear un fichero con n palabras loren ipsum y m líneas 
	 */
	public void lorenIpsum(int palabras, int lineas) {
		
		String File = "./resources/loreIpsum.txt";
		
		FileWriter archivo = null;
		
		
		
		try {
			archivo = new FileWriter(File);
			
			for (int i=0; i<lineas;i++){
				StringBuffer sb = new StringBuffer();
				for(int j=0;j<palabras;j++) {
					sb.append("loren ipsum ");
				}
				sb.append("\n");
				archivo.write(sb.toString());
			}
			
		} catch (IOException e) {
			System.out.println("Error de lextura\\escritura del archivo");
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					System.out.println("Error de lextura\\escritura del archivo");
				}
			}
		}
		
	}
	/**
	 * 5
	 * Pasa todas las palabras de un texto a otro
	 * @param ruta
	 */
	
	public void sustituirPalabrasTexto(String ruta) {
		
		
		BufferedReader archivo=null;
		String linea;
		
		String ruta2 = "./resources/textoCambiar2.txt";
		FileWriter archivo2 = null;
		
		String texto, texto2;
		
		try {
			
			archivo = new BufferedReader(new FileReader(ruta));
			archivo2 = new FileWriter(ruta2);
			
			
			
			while((linea=archivo.readLine()) != null) {
				
				texto = linea.replaceAll("Enviar","Autor");
				texto2 = texto.replaceAll("frase"," ");
				archivo2.write(texto2+"\n");			
				
				
			}
			
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		} finally {
			
			if(archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(archivo2 != null) {
				try {
					archivo2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/*
		File file = null;
		File file2 = null;
		
		file = new File(ruta);		
		file2 = new File(ruta2);
		
		
		file2.renameTo(file);
		boolean success = file2.renameTo(file);
        if (!success) {
            System.out.println("Error intentando cambiar el nombre de fichero");
        }
        
		file.delete();
		*/
	}
	/**
	 * 6
	 * Pasar a mayúsculas un texto
	 * @param ruta
	 */
	
	public void pasarMayusculas(String ruta) {
		
		BufferedReader archivo = null;
		String linea;
		String texto;
		
		FileWriter archivo2 = null;
		String ruta2 = "./resources/textoCambiar3.txt";
		
		try {
			archivo = new BufferedReader(new FileReader(ruta));
			archivo2 = new FileWriter(ruta2);
			
			while((linea = archivo.readLine()) != null) {
				
				texto = linea.toUpperCase();
				archivo2.write(texto+"\n");
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		} finally {
		
			if(archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(archivo2 != null) {
				try {
					archivo2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	

	
	/**
	 * 9-
	 * Este método borra las palabras feas de un texto
	 * @param ruta
	 */
	public void borrarPalabrasFeas(String ruta) {
		
		String File = "./resources/insultos2.txt";
		
		BufferedReader archivo = null;
		String linea=" ";
		String texto = " ";
		String texto1 = " ";
		
		FileWriter archivo2 = null;
		String [] insultos = {"feo","fea", "tonta", "tonto"};
		boolean comparativo = false;
		int contador = 1;
		
		
		
		try {
			archivo = new BufferedReader(new FileReader(ruta));
			archivo2 = new FileWriter(File);
			
			while ((linea = archivo.readLine()) != null) {
				texto1 = linea;
				
				contador = 1;
				
				for (int i=0;i<insultos.length;i++) {
					
					texto = linea.replaceAll(insultos[i], "######");

					if (texto.equals(texto1) && (contador == 1)) {
						archivo2.write(texto1+"\n");
						contador++;
					} else if ((!texto.equals(texto1)) && (contador == 1)) {
						
						archivo2.write(texto+"\n");
						contador++;
						
					}
					
				}
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado.");
		} catch (IOException e) {
			System.out.println("Error de entrada de datos.");
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					System.out.println("Error de entrada de datos.");
				}
			}
			
			if (archivo2 != null) {
				try {
					archivo2.close();
				} catch (IOException e) {
					System.out.println("Error de entrada de datos.");
				}
			}
		}
		
		
		
	}
	

	

}
