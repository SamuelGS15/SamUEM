

public class Main {
	
	final static String PATH_TEXT_FILE = "./resources/QUIJOTE_OTRO.txt";
	final static String PATH_TEXT_FILE_END = "./resources/QUIJOTEpep.txt";

			public static void main(String [] args) {
				
				Ejercicio4 e4 = new Ejercicio4();
				
				long startTime = System.currentTimeMillis();
				
				//1
				System.out.println("N�mero de caracteres: "+ e4.contarCaracteres(PATH_TEXT_FILE));
				long stopTime = System.currentTimeMillis();
				long elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
/**/			//2
				startTime = System.currentTimeMillis();
				System.out.println("N�mero de palabras: "+e4.contarPalabras(PATH_TEXT_FILE));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//3
				startTime = System.currentTimeMillis();
				System.out.println("N�mero de l�neas: "+e4.countLines(PATH_TEXT_FILE));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//4
				startTime = System.currentTimeMillis();
				System.out.println("N�mero de letras: "+e4.contarLetrasAbc(PATH_TEXT_FILE));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//5
				startTime = System.currentTimeMillis();
				System.out.println("N�mero de letras min�sculas: "+e4.contarLetrasMin(PATH_TEXT_FILE));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//6
				startTime = System.currentTimeMillis();
				System.out.println("N�mero de letras vocales: "+e4.contarLetrasVocales(PATH_TEXT_FILE));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//7
				startTime = System.currentTimeMillis();
				System.out.println("N�mero de letras min�sculas puras (sin acentuar, etc): "+e4.letrasMinPuras(PATH_TEXT_FILE));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//8
				startTime = System.currentTimeMillis();
				System.out.println("N�mero de letras may�sculas: "+e4.letrasMay(PATH_TEXT_FILE));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//9		
				startTime = System.currentTimeMillis();
				System.out.println("Palabras con sufijo ion:"+e4.contarPalabrasSufijo((PATH_TEXT_FILE), "i�n"));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//10
				startTime = System.currentTimeMillis();
				System.out.println("Crea un archivo nuevo");
				e4.writeUppercaseFile(PATH_TEXT_FILE, PATH_TEXT_FILE_END);
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				//11
				startTime = System.currentTimeMillis();
				System.out.println("N�mero de diptongos:"+e4.contarDiptongo((PATH_TEXT_FILE)));
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("Tiempo tardado por el proceso: "+elapsedTime+" milisegundos");
				System.out.println("");
				
				
			}
}
