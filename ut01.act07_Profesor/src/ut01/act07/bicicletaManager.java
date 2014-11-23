package ut01.act07;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class bicicletaManager implements InterfazFicheroBicicleta {

	final static String FICHERO = "./resources/bicicleta.dat";

	public void dummy() {

		ArrayList<Bicicleta> bicis = new ArrayList<Bicicleta>();

		bicis.add(new Bicicleta(1, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(2, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(3, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(4, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(5, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(6, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(7, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(8, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(9, true, "01/01/2014", 10));
		bicis.add(new Bicicleta(10, true, "01/01/2014", 10));

		ObjectOutputStream streamOut = null;

		try {
			streamOut = new ObjectOutputStream(new FileOutputStream(FICHERO));

			for (Bicicleta bicicleta : bicis) {
				streamOut.writeObject(bicicleta);
			}

			/*
			 * for (int i=0; i < bicis.size();i++){ bicis.get(i); }
			 */

		} catch (FileNotFoundException e) {

			System.err.println("Fichero no encotrado " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error E/S" + e.getMessage());
		} finally {
			if (streamOut != null)
				try {
					streamOut.close();
				} catch (IOException e) {
					System.err.println("Error E/S" + e.getMessage());
				}
		}
	}

	public void imprimir() {

		ObjectInputStream streamIn = null;

		try {

			streamIn = new ObjectInputStream(new FileInputStream(FICHERO));

			Bicicleta bici = null;
			while ((bici = (Bicicleta) streamIn.readObject()) != null) {
				System.out.println(bici.toString());

			}
		} catch (ClassNotFoundException e) {

		} catch (FileNotFoundException e) {

			System.err.println("Fichero no encotrado " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error E/S" + e.getMessage());
		}

		finally {
			if (streamIn != null)
				try {
					streamIn.close();
				} catch (IOException e) {
					System.err.println("Error E/S" + e.getMessage());
				}
		}

	}

	public Bicicleta[] buscarBicicleta() {

		ObjectInputStream file = null;
		ArrayList<Bicicleta> bicis = new ArrayList<Bicicleta>();

		try {
			file = new ObjectInputStream(new FileInputStream(FICHERO));

			Object obj = null;
			while ((obj = file.readObject()) != null) {
				if (obj instanceof Bicicleta) {
					bicis.add((Bicicleta) obj);
				}
			}

		} catch (EOFException e) {

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return bicis.toArray(new Bicicleta[bicis.size()]);
	}

	@Override
	public boolean guardarBici(Bicicleta bici) {

		ObjectOutputStream objOutput = null;

		try {
			objOutput = new ObjectOutputStream(new FileOutputStream(FICHERO,
					true));

			objOutput.writeObject(bici);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (objOutput != null) {
				try {
					objOutput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return true;
	}

	@Override
	public Bicicleta obtenerBici(int id) {

		return null;
	}

	@Override
	public boolean modificarBici(Bicicleta bici) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarBici(Bicicleta bici) {
		// TODO Auto-generated method stub
		return false;
	}

}
