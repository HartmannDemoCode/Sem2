package dataSource;

import java.sql.Connection;
import domain.*;

public class DBFacade {
	  private OrderMapper om; 
	  private Connection con;
	  private static DBFacade instance;
	 
	  private DBFacade() {
		  con = new DBConnector().getConnection();  // the connection will be released upon program 
		  om = new OrderMapper(con);
		  											  // termination by the garbage collector		  
	  }
	  public static DBFacade getInstance()
	  {
		  if(instance == null)
                  instance = new DBFacade();
		  return instance;
	  }
	  
	  public Order getOrder(int ono) throws Exception 
	  {
		  return om.getOrder(ono);	      
	  }
	  
	  public Order saveNewOrder(Order o)
	  { 
	    return om.saveNewOrder(o);
	  }
	  
	  public boolean saveNewOrderDetail(OrderDetail od)
	  {
	    return om.saveNewOrderDetail(od);
	  }
          
	
}
