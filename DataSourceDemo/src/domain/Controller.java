package domain;

import java.util.ArrayList;
import dataSource.*;
//=== hau
	public class Controller
	{
	  private Order currentOrder;       // Order in focus
	  private DBFacade dbf;
	  
	  public Controller()
	  {
	    currentOrder = null;
	    dbf = DBFacade.getInstance();
	  }
	 
	  public Order getOrder(int ono)
	  {
	    currentOrder = dbf.getOrder(ono);
	    return currentOrder;
	  }
	  
	  public Order createNewOrder(int cno, int eno, String rec, String ship)
	  {
	      //== create order object with ono=0
	      currentOrder = new Order(0, cno, eno, rec, ship);
	      
	      //== save and get DB-generated unique ono
	      boolean status = dbf.saveNewOrder(currentOrder);
	      if (!status) //fail!
	        currentOrder = null;

	      return currentOrder;
	  } 
	  public boolean addOrderDetail(int partNo, int qty)
	  {
	    boolean status = false;
	    if (currentOrder != null)
	    {
	      OrderDetail od = new OrderDetail(currentOrder.getOno(),partNo, qty);
	      currentOrder.addDetail(od);
	      status = dbf.saveNewOrderDetail(od);
	    }
	    return status;
	  }

	  public String getOrderDetailsToString()
	  {
	    if (currentOrder != null)
	      return currentOrder.detailsToString();
	    else
	      return null;
	  }


}
