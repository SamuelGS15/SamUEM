

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioSQL {
	public static void main(String[] args) throws ClassNotFoundException
	
	  {
	    // load the sqlite-JDBC driver using the current class loader
		// Carga el driver de jbc específico para jdbc y así java sabe como trabajar
	    Class.forName("org.sqlite.JDBC");

	    // Conexión
	    Connection connection = null;
	    
	    // Esto puede generar excepciones de SQLException
	    try
	    {
	      // create a database connection
	    	// Establece conexión con la base de datos
	      connection = DriverManager.getConnection("jdbc:sqlite:./resources/TablaTemp.db");
	      
	      // Con este objeto hacemos consultas de SQL
	      Statement statement = connection.createStatement();
	      // No es obligatorio pero es bueno para dejar de buscar la BBDD
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.

	      //executeUpdate para todas menos las de SELECT
	      statement.executeUpdate("drop table if exists tiempo");
	      statement.executeUpdate("create table tiempo (id integer PRIMARY KEY, "
	      		+ "fecha String NOT NULL, min Float NOT NULL, max Float NOT NULL, "
	      		+ "humedad FLOAT NOT NULL, presion Float NOT NULL)");
	      statement.executeUpdate("insert into tiempo values(1, '20141110',13,25,0,1029)");
	      //statement.executeUpdate("insert into person values(2, 'yui')");
	      
	      // Guarda consultas de bbdd      
	      ResultSet rs = statement.executeQuery("select * from tiempo");
	      
	      
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("id = " + rs.getString("id"));
	        System.out.println("fecha = " + rs.getInt("fecha"));
	        System.out.println("tempMax = " + rs.getInt("max"));
	      }
	      rs.close();
	      statement.close();
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	    	  
	    	  // Hay que cerrar la conexión
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	  }

}
