package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;

//Encapsulates code to connect to DB
//hau

public class DBConnector {
	  private static String id = "tha";						//Insert ORACLE id and password
	  private static String pw = "tha";
          private static String localDriver = "org.apache.derby.jdbc.ClientDriver";
          private static String remoteDriver = "oracle.jdbc.driver.OracleDriver";
          private static String localURL = "jdbc:derby://localhost:1527/Test";
          private static String remoteURL = "jdbc:oracle:thin:@delfi.lyngbyes.dk:1521:KNORD";
	 
	  public Connection getConnection()
	  {
	    Connection con = null;
	    try 
	    {  
	      Class.forName(localDriver);
	      con = DriverManager.getConnection(localURL, id,  pw );  
	    }
	    catch (Exception e) 
	    {   
	    	System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
	    	System.out.println("\n*** Remember to point to the location of the jdbc driver! ***\n");
	    	
                System.out.println("eror in DBConnector.getConnection()");
	        System.out.println(e); 	     
	    }    

	    return con;
	  }
	  
	  public void releaseConnection(Connection con)
	  {
	      try{
	          con.close();
	      }
	      catch (Exception e)
	      { System.err.println(e);}
	  }
}
