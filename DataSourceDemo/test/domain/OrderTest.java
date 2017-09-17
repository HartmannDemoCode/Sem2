/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tha
 */
public class OrderTest {
    static private Order instance = null;
    public OrderTest() {
         instance = new Order(1020,1111,1000,"01-01-2010","01-02-2010");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOno method, of class Order.
     */
    @Test
    public void testGetOno() {
        System.out.println("getOno");
        Order instance = new Order(1020,1111,1000,"01-01-2010","01-02-2010");
        int expResult = 0;
        int result = instance.getOno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOno method, of class Order.
     */
    @Test
    public void testSetOno() {
        System.out.println("setOno");
        int ono = 1021;
         //Order instance = new Order(1020,1111,1000,"01-01-2010","01-02-2010");
        
        instance.setOno(ono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomer method, of class Order.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        int c = 0;
         Order instance = new Order(1020,1111,1000,"01-01-2010","01-02-2010");
        instance.setCustomer(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerNo method, of class Order.
     */
    @Test
    public void testGetCustomerNo() {
        System.out.println("getCustomerNo");
 Order instance = new Order(1020,1111,1000,"01-01-2010","01-02-2010");
        int expResult = 0;
        int result = instance.getCustomerNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployee method, of class Order.
     */
    @Test
    public void testSetEmployee() {
        System.out.println("setEmployee");
        int e = 0;
 Order instance = new Order(1020,1111,1000,"01-01-2010","01-02-2010");
        instance.setEmployee(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeNo method, of class Order.
     */
    @Test
    public void testGetEmployeeNo() {
        System.out.println("getEmployeeNo"); 
        //Order instance = new Order(1020,1111,1000,"01-01-2010","01-02-2010");
        int expResult = 1000;
        int result = instance.getEmployeeNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReceived method, of class Order.
     */
    @Test
    public void testSetReceived() {
        System.out.println("setReceived");
        String received = "";
         //Order instance = new Order(1020,1111,1000,"01-01-2010","01-02-2010");
        instance.setReceived(received);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReceived method, of class Order.
     */
    @Test
    public void testGetReceived() {
        System.out.println("getReceived");
        //Order instance = null;
        String expResult = "";
        String result = instance.getReceived();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShipped method, of class Order.
     */
    @Test
    public void testSetShipped() {
        System.out.println("setShipped");
        String shipped = "";
        //Order instance = null;
        instance.setShipped(shipped);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShipped method, of class Order.
     */
    @Test
    public void testGetShipped() {
        System.out.println("getShipped");
        //Order instance = null;
        String expResult = "";
        String result = instance.getShipped();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDetail method, of class Order.
     */
    @Test
    public void testAddDetail() {
        System.out.println("addDetail");
        OrderDetail od = null;
        //Order instance = null;
        instance.addDetail(od);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetails method, of class Order.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        //Order instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Order.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        //Order instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detailsToString method, of class Order.
     */
    @Test
    public void testDetailsToString() {
        System.out.println("detailsToString");
        //Order instance = null;
        String expResult = "";
        String result = instance.detailsToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
