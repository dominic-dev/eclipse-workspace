package nl.hva.miw.bst;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author michel.mercera
 */
public class IteratorTest {
 
    BST sevenBST;

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
    
    @Test
    public void testHasNext(){
        boolean result= sevenBST.iterator().hasNext();
        boolean expected = true;
        assertEquals(expected, result); 
    }
    
    @Test
    public void testNext(){
        Node result= sevenBST.iterator().next();
        Integer expected = 1;
        assertEquals(expected, result); 
    }
    @Test
    public void testNextNext(){
        sevenBST.iterator().next();
        Node result= sevenBST.iterator().next();
        Integer expected = 3;
        assertEquals(expected, result); 
    }
    
    @Test
    public void testNextNextNext(){
        sevenBST.iterator().next();
        Node result= sevenBST.iterator().next();
        Integer expected = 4;
        assertEquals(expected, result); 
    }
    
}
