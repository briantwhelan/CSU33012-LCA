import org.junit.Test;
import static org.junit.Assert.assertEquals;
/*************************************************************************
 *  {@code BinarySearchTree} test class.
 *
 *  @version 10/10/21
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
     * Test {@code delete(Key key)} 
     */
    @Test
    public void testDelete() 
    {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
        
        binarySearchTree.delete(1);
        assertEquals("Testing delete(Key key)", "()", binarySearchTree.printKeysInOrder());
        binarySearchTree.put(7, 7);   //        _7_
        binarySearchTree.put(8, 8);   //      /     \
        binarySearchTree.put(3, 3);   //    _3_      8
        binarySearchTree.put(1, 1);   //  /     \
        binarySearchTree.put(2, 2);   // 1       6
        binarySearchTree.put(6, 6);   //  \     /
        binarySearchTree.put(4, 4);   //   2   4
        binarySearchTree.put(5, 5);   //        \
                                      //         5           
        binarySearchTree.delete(9);
        assertEquals("Testing delete(Key key)",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
        binarySearchTree.delete(8);
        assertEquals("Testing delete(Key key)", "(((()1(()2()))3((()4(()5()))6()))7())", binarySearchTree.printKeysInOrder());
        binarySearchTree.delete(6);
        assertEquals("Testing delete(Key key)",
                "(((()1(()2()))3(()4(()5())))7())", binarySearchTree.printKeysInOrder());
        binarySearchTree.delete(3);
        assertEquals("Testing delete(Key key)",
                "(((()1())2(()4(()5())))7())", binarySearchTree.printKeysInOrder());
        
        binarySearchTree = new BinarySearchTree<Integer, Integer>();
        
        binarySearchTree.put(7, 7);   //        _7_
        binarySearchTree.put(8, 8);   //      /     \
        binarySearchTree.put(3, 3);   //    _3_      8
        binarySearchTree.put(1, 1);   //  /     \
        binarySearchTree.put(2, 2);   // 1       6
        binarySearchTree.put(6, 6);   //  \     /
        binarySearchTree.put(4, 4);   //   2   4
        binarySearchTree.put(5, 5);   //        \
                                      //         5
        binarySearchTree.delete(1);
        assertEquals("Testing delete(Key key)",
                "(((()2())3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
    } 

    /**
     * Test {@code deleteMax()} 
     */
    @Test
    public void testDeleteMax()
    {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
        
        binarySearchTree.deleteMax();
        assertEquals("Testing deleteMax()", "()", binarySearchTree.printKeysInOrder());
        binarySearchTree.put(7, 7);   //        _7_
        binarySearchTree.put(8, 8);   //      /     \
        binarySearchTree.put(3, 3);   //    _3_      8
        binarySearchTree.put(1, 1);   //  /     \    
        binarySearchTree.put(2, 2);   // 1       6  
        binarySearchTree.put(6, 6);   //  \     /
        binarySearchTree.put(4, 4);   //   2   4
        binarySearchTree.put(5, 5);   //        \
                                      //         5
        binarySearchTree.deleteMax();
        assertEquals("Testing deleteMax()",
                "(((()1(()2()))3((()4(()5()))6()))7())", binarySearchTree.printKeysInOrder());
        binarySearchTree.deleteMax();
        assertEquals("Testing deleteMax()",
                "((()1(()2()))3((()4(()5()))6()))", binarySearchTree.printKeysInOrder());
        binarySearchTree.deleteMax();
        assertEquals("Testing deleteMax()",
                "((()1(()2()))3(()4(()5())))", binarySearchTree.printKeysInOrder());
    }

    /**
     * Test {@code max()} 
     */
    @Test
    public void testMax()
    {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
        
        assertEquals("Testing max()", null, binarySearchTree.max());
        binarySearchTree.put(5, 5); 
        assertEquals("Testing max()", 5, (int)binarySearchTree.max());
        binarySearchTree.put(15, 15);
        assertEquals("Testing max()", 15, (int)binarySearchTree.max());
        binarySearchTree.put(10, 10); 
        assertEquals("Testing max()", 15, (int)binarySearchTree.max());
    }

    /**
     * Test {@code lowestCommonAncestor(Key node1, Key node2)}
     */
    @Test
    public void testLowestCommonAncestor()
    {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
        
        assertEquals("Testing lowestCommonAncestor(Key node1, Key node2)", null, binarySearchTree.lowestCommonAncestor(null, null));
        assertEquals("Testing lowestCommonAncestor(Key node1, Key node2)", null, binarySearchTree.lowestCommonAncestor(3, 8));
        binarySearchTree.put(7, 7);   //        _7_
        binarySearchTree.put(8, 8);   //            \
        binarySearchTree.put(9, 9);   //             8
        binarySearchTree.put(10,10);  //              \
                                      //               9
                                      //                \
                                      //                10
        assertEquals("Testing lowestCommonAncestor(Key node1, Key node2)", 8, (int)binarySearchTree.lowestCommonAncestor(8, 10));
        assertEquals("Testing lowestCommonAncestor(Key node1, Key node2)", 9, (int)binarySearchTree.lowestCommonAncestor(9, 10));
        
        
        binarySearchTree = new BinarySearchTree<Integer, Integer>();
        
        binarySearchTree.put(7, 7);   //        _7_
        binarySearchTree.put(8, 8);   //      /     \
        binarySearchTree.put(3, 3);   //    _3_      8
        binarySearchTree.put(1, 1);   //  /     \
        binarySearchTree.put(2, 2);   // 1       6
        binarySearchTree.put(6, 6);   //  \     /
        binarySearchTree.put(4, 4);   //   2   4
        binarySearchTree.put(5, 5);   //        \
                                      //         5
        assertEquals("Testing lowestCommonAncestor(Key node1, Key node2)", 7, (int)binarySearchTree.lowestCommonAncestor(3, 8));
        assertEquals("Testing lowestCommonAncestor(Key node1, Key node2)", 7, (int)binarySearchTree.lowestCommonAncestor(8, 3));
        assertEquals("Testing lowestCommonAncestor(Key node1, Key node2)", 7, (int)binarySearchTree.lowestCommonAncestor(2, 8));
        assertEquals("Testing lowestCommonAncestor(Key node1, Key node2)", 3, (int)binarySearchTree.lowestCommonAncestor(2, 5));
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

