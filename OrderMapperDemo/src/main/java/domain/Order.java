package domain;

import java.util.ArrayList;
import java.util.Date;
//=== hau
public class Order
{

	  private int ono; 
	  private int cno; // A FK that should be mapped to a reference
	  private int eno; // A FK that should be mapped to a reference
	  private Date received;
	  private Date shipped;
	  private ArrayList<OrderDetail> orderDetails;
	
	  public Order(int c, int e)
	  {
	    cno = c;
	    eno = e;
	    orderDetails = new ArrayList();
	  }

    public Order(int ono, int cno, int eno, Date received, Date shipped) {
        this.ono = ono;
        this.cno = cno;
        this.eno = eno;
        this.received = received;
        this.shipped = shipped;
        this.orderDetails = new ArrayList();
    }
          
	  
	  //== accessors
	  public int getOno()
	  {
	    return ono;
	  }
	  public void setOno(int ono)
	  {
	    this.ono = ono;
	  }
	
	  public void setCustomer(int c)
	  {
	    this.cno = c;
	  }
	
	  public int getCustomerNo()
	  {
	    return cno;
	  }
	
	  public void setEmployee(int e)
	  {
	    this.eno = e;
	  }
	
	  public int getEmployeeNo()
	  {
	    return eno;
	  }
	
	  public void setReceived(Date received)
	  {
	    this.received = received;
	  }
	
	  public Date getReceived()
	  {
	    return received;
	  }
	
	  public void setShipped(Date shipped)
	  {
	    this.shipped = shipped;
	  }
	
	  public Date getShipped()
	  {
	    return shipped;
	  }
	  public void addDetail(OrderDetail od)
	   {
            od.setOno(this.ono);
	    orderDetails.add(od);
	  }
          public ArrayList<OrderDetail> getDetails()
          {
              return orderDetails;
          }
          @Override
	  public String toString()
	  {
	    return ono + " " + cno + " " + eno + " " + received + " " + shipped +"\n"+ detailsToString();
	  }
	
	  String detailsToString()
	  {
	    String res = "";
	    for (int i = 0; i < orderDetails.size(); i++) 
	    {
	      res += orderDetails.get(i).toString() + "\n";
	    }
	    return res;
	  }
}
