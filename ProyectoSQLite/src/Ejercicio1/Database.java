package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private final static String DB = "forecast.db";
	private final static String PATH = "./resources/";
	private final static String URL = "jdbc:sqlite:" + PATH + DB;

	private final static String DRIVER = "org.sqlite.JDBC";

	// Establece la conexion con la base de datos
	// a partir de métodos importados desde la librería sqlite-jdbc
	protected Connection conn;

	public Database() {

		try {
			// Carga el driver o controlador
			Class.forName(DRIVER);
			// Establece la conexión con la base de datos
			conn = DriverManager.getConnection(URL);
			
			// Nos aseguramos de que se ha conectado
			if(conn!=null) System.out.println("Conectado");
		
			 
		} catch (SQLException e) {
			System.out.println("Error al cargar el driver.");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al conectarse.");
		}
		System.out.println(URL);
	}

	public static String getUrl() {
		return URL;
	}
	
	

}
