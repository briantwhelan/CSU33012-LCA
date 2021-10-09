import org.junit.Test;
import static org.junit.Assert.assertEquals;
/*************************************************************************
 *  {@code BinarySearchTree} test class.
 *
 *  @version 09/10/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BinarySearchTreeTest
{   	
    /**
     * Test {@code BinarySearchTree()} 
     */
	@Test
	public void testConstructor()
	{
	    new BinarySearchTree<Integer, Integer>();		     
	}

    /**
     * Test {@code size()} 
     */
	@Test
	public void testSize()
	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing size()", 0, binarySearchTree.size());
		binarySearchTree.put(5, 5);
		assertEquals("Testing size()", 1, binarySearchTree.size());	
		binarySearchTree.put(15, 15);
		assertEquals("Testing size()", 2, binarySearchTree.size());	
		binarySearchTree.put(10, 10);
		assertEquals("Testing size()", 3, binarySearchTree.size());	
	}

	/**
     * Test {@code put(Key key, Value value)}  
     */
	@Test
	public void testPut()
	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing put(Key key, Value value)", "()", binarySearchTree.printKeysInOrder());
  	    binarySearchTree.put(7, 7);   //        _7_
  	    binarySearchTree.put(8, 8);   //      /     \
  	    binarySearchTree.put(3, 3);   //    _3_      8
  	    binarySearchTree.put(1, 1);   //  /     \
  	    binarySearchTree.put(2, 2);   // 1       6
  	    binarySearchTree.put(6, 6);   //  \     /
  	    binarySearchTree.put(4, 4);   //   2   4
  	    binarySearchTree.put(5, 5);   //        \
  									  //         5
  	    assertEquals("Testing put(Key key, Value value)",
  			        "(((()1(()2()))3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
  	    binarySearchTree.put(8, 10);
  	    assertEquals("Testing put(Key key, Value value)",
  			        "(((()1(()2()))3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
  	    binarySearchTree.put(8, null);
  	    assertEquals("\"Testing put(Key key, Value value)\"",
  			            "(((()1(()2()))3((()4(()5()))6()))7())", binarySearchTree.printKeysInOrder());
	}

    /**
     * Test {@code printKeysInOrder()} 
     */
    @Test
    public void testPrintKeysInOrder() 
    {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
            
        assertEquals("Testing printKeysInOrder()", "()", binarySearchTree.printKeysInOrder());
        binarySearchTree.put(7, 7);   //        _7_
        binarySearchTree.put(8, 8);   //      /     \
        binarySearchTree.put(3, 3);   //    _3_      8
        binarySearchTree.put(1, 1);   //  /     \
        binarySearchTree.put(2, 2);   // 1       6
        binarySearchTree.put(6, 6);   //  \     /
        binarySearchTree.put(4, 4);   //   2   4
        binarySearchTree.put(5, 5);   //        \
                                                      //         5
        assertEquals("Testing printKeysInOrder()",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
    }

    /**
     * Test {@code toString()} 
     */
 	@Test
 	public void testToString() 
 	{
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
             
        assertEquals("Testing toString()", "-null\n", binarySearchTree.toString());
        binarySearchTree.put(7, 7);
        binarySearchTree.put(8, 8);       
        binarySearchTree.put(3, 3);     
        binarySearchTree.put(1, 1);      
        binarySearchTree.put(2, 2);      
        binarySearchTree.put(6, 6);     
        binarySearchTree.put(4, 4);      
        binarySearchTree.put(5, 5);       
        String expectedString = 
            "-7\n" +
            " |-3\n" + 
            " | |-1\n" +
            " | | |-null\n" + 
            " | |  -2\n" +
            " | |   |-null\n" +
            " | |    -null\n" +
            " |  -6\n" +
            " |   |-4\n" +
            " |   | |-null\n" +
            " |   |  -5\n" +
            " |   |   |-null\n" +
            " |   |    -null\n" +
            " |    -null\n" +
            "  -8\n" +
            "   |-null\n" +
            "    -null\n";
         assertEquals("Testing toString()", expectedString, binarySearchTree.toString());
    }
}
