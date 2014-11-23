package ut01.act07;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bicicleta implements Serializable {
	
	private int id;
	private boolean disponible;
	private Date fechaRevision;
	private int idTotem; // Donde está la bicicleta
	
	private SimpleDateFormat dateFormat;
	private static final String FORMATO_FECHA = "dd/MM/YYYY";
	
	public Bicicleta() {
		dateFormat = new SimpleDateFormat(FORMATO_FECHA);
	}	

	public Bicicleta(int id, boolean disponible, String fechaRevision, int idTotem) {
		this();
		this.id = id;
		this.disponible = disponible;
		setFechaRevision(fechaRevision);
		this.idTotem = idTotem;
		dateFormat = new SimpleDateFormat(FORMATO_FECHA);
	}


		// Setters y getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getFechaRevision() {
		return dateFormat.format(fechaRevision);
	}

	public void setFechaRevision(String fechaRevision2) {
		
		try {
			// transforma una fecha en formato dd/MM/YYYY 
			this.fechaRevision = dateFormat.parse(fechaRevision2);
			
		} catch (ParseException e) {
			try {
				// si el formato está mal ponemos una fecha por defecto
				this.fechaRevision = dateFormat.parse("01/01/1900");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
	}

	public int getIdTotem() {
		return idTotem;
	}

	public void setIdTotem(int idTotem) {
		this.idTotem = idTotem;
	}

	@Override
	public String toString() {
		return "Bicicleta [id=" + id + ", disponible=" + disponible
				+ ", fechaRevision=" + fechaRevision + ", idTotem=" + idTotem
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (disponible ? 1231 : 1237);
		result = prime * result
				+ ((fechaRevision == null) ? 0 : fechaRevision.hashCode());
		result = prime * result + id;
		result = prime * result + idTotem;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicicleta other = (Bicicleta) obj;
		if (disponible != other.disponible)
			return false;
		if (fechaRevision == null) {
			if (other.fechaRevision != null)
				return false;
		} else if (!fechaRevision.equals(other.fechaRevision))
			return false;
		if (id != other.id)
			return false;
		if (idTotem != other.idTotem)
			return false;
		return true;
	}
	
	
	
	

}
