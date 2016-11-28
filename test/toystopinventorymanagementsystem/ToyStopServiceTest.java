/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toystopinventorymanagementsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Salman
 */
public class ToyStopServiceTest {
    
    public ToyStopServiceTest() {
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
     * Test of initEmployees method, of class ToyStopService.
     */
    @Test
    public void testInitEmployees() {
        System.out.println("initEmployees");
        ToyStopService instance = new ToyStopService();
        instance.initEmployees();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of initStores method, of class ToyStopService.
     */
 

    /**
     * Test of initToys method, of class ToyStopService.
     */

    /**
     * Test of addEmployee method, of class ToyStopService.
     */
    
 
    /**
     * Test of addStore method, of class ToyStopService.
  

    /**
     * Test of addToy method, of class ToyStopService.
     */
   
    /**
     * Test of checkemployee method, of class ToyStopService.
     */
    @Test
    public void testCheckemployee() {
        System.out.println("checkemployee");
        ToyStopService instance = new ToyStopService();
        instance.checkemployee();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toyslist method, of class ToyStopService.
     */
    @Test
    public void testToyslist() {
        System.out.println("toyslist");
        ToyStopService instance = new ToyStopService();
        instance.toyslist();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getstore method, of class ToyStopService.
     */
    @Test
    public void testGetstore() {
        System.out.println("getstore");
        int UID = 0;
        ToyStopService instance = new ToyStopService();
        instance.getstore(UID);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getemployee method, of class ToyStopService.
     */
    @Test
    public void testGetemployee() {
        System.out.println("getemployee");
        int UID = 0;
        ToyStopService instance = new ToyStopService();
        instance.getemployee(UID);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeemployee method, of class ToyStopService.
     */
    @Test
    public void testRemoveemployee() {
        System.out.println("removeemployee");
        int ID = 0;
        ToyStopService instance = new ToyStopService();
        instance.removeemployee(ID);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
