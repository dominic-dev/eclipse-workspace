package nl.hva.miw.bst;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author michel.mercera
 */
public class BSTTest {
  
    BST sevenBST;
    
    //will run before every test... so each test has a fresh sevenBST instance
    @Before
    public void init(){
        sevenBST= new BST();
        sevenBST.add(6);
        sevenBST.add(10);
        sevenBST.add(3);
        sevenBST.add(5);
        sevenBST.add(8);
        sevenBST.add(1);
        sevenBST.add(4);
        
    }
  
    /**
     * Test of size method, of class BST.
     */
    @Test
    public void testZeroSize() {
        System.out.println("zero size");
        BST instance = new BST();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of size method, of class BST.
     */
    @Test
    public void testSevenSize() {
        System.out.println("seven size");
        int expResult = 7;
        int result = sevenBST.size();
        assertEquals(expResult, result);
    }


    /**
     * Test of isEmpty method, of class BST.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BST instance = new BST();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
      
    }
    
    /**
     * Test of isEmpty method, of class BST.
     */
    @Test
    public void testIsNotEmpty() {
        System.out.println("isNotEmpty");
        boolean expResult = false;
        boolean result = sevenBST.isEmpty();
        assertEquals(expResult, result);
      
    }


    /**
     * Test of contains method, of class BST.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Node node = new Node();
        node.setElement(4);
        
        boolean expResult = true;
        boolean result = sevenBST.contains(node);
        assertEquals(expResult, result);
    }

   
      /**
     * Test of contains method, of class BST.
     */
    @Test
    public void testNotContains() {
        System.out.println("Not contains");
        Node node = new Node();
        node.setElement(2);
        
        boolean expResult = false;
        boolean result = sevenBST.contains(node);
        assertEquals(expResult, result);
    }



    /**
     * Test of add method, of class BST.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Node node = new Node();
        node.setElement(2);
        BST instance = new BST();
        boolean expResult = true;
        boolean result = instance.add(node);
        assertEquals(expResult, result);
       
    }

    
     /**
     * Test of add method, of class BST.
     */
    @Test
    public void testNotAdd() {
        System.out.println("not add");
        Node node = new Node();
        node.setElement(2);
        BST instance = new BST();
        boolean expResult = false;
        instance.add(node);
        boolean result= instance.add(node);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of findMax method, of class BST.
     */
    @Test
    public void testFindMax() {
        System.out.println("findMax");
        Node expResult = new Node();
        expResult.setElement(10);
        Node result = sevenBST.findMax();
        assertEquals(expResult.getElement(), result.getElement());
    }

   

  
 
    /**
     * Test of in order iterator method, of class BST.
     */
    @Test
    public void testIterator() {
        System.out.println("inorder iterator");
        BST instance = new BST();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        fail("TODO make a test case");
    }

    
    
}
