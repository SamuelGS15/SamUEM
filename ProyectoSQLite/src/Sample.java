
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    // load the sqlite-JDBC driver using the current class loader
	// Carga el driver de jbc espec�fico para jdbc y as� java sabe como trabajar
    Class.forName("org.sqlite.JDBC");

    // Conexi�n
    Connection connection = null;
    
    // Esto puede generar excepciones de SQLException
    try
    {
      // create a database connection
    	// Establece conexi�n con la base de datos
      connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
      
      // Con este objeto hacemos consultas de SQL
      Statement statement = connection.createStatement();
      // No es obligatorio pero es bueno para dejar de buscar la BBDD
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      //executeUpdate para todas menos las de SELECT
      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate("create table person (id integer, name string)");
      statement.executeUpdate("insert into person values(1, 'leo')");
      statement.executeUpdate("insert into person values(2, 'yui')");
      
      // Guarda consultas de bbdd      
      ResultSet rs = statement.executeQuery("select * from person");
      
      
      while(rs.next())
      {
        // read the result set
        System.out.println("name = " + rs.getString("name"));
        System.out.println("id = " + rs.getInt("id"));
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
    	  
    	  // Hay que cerrar la conexi�n
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