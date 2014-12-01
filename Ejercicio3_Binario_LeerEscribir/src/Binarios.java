

	import java.io.*;
	import java.util.Scanner;


	public class Binarios {
		final static String File = "./resources/Double.bin"; 
		static Scanner teclado = new Scanner(System.in);
		
		public void guardarFichero (String ruta) {
			
			File file = new File(ruta);
			
			FileOutputStream fileout = null;
			int i;
			
			try {
				fileout = new FileOutputStream(file);
				
				//for(int i=0; i<100; i++) {
				do {
					System.out.println("Escribe un número:");
					i = teclado.nextInt();
					fileout.write(i);
				}while(i != -1);
					
				//}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fileout != null) {
					try {
						fileout.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		public void leerfichero(String ruta) {
			
			int i;
			File file = new File(ruta);
			
			FileInputStream filein = null;
			
			try {
				filein = new FileInputStream(file);
				
				while((i = filein.read()) != -1) {
					if(i != 255) {
						System.out.println(i);
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(filein != null) {
					try {
						filein.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		public static void main (String [] args) {
			
			Binarios e = new Binarios();
			
			e.guardarFichero (File);
			e.leerfichero(File);
		}

	}


