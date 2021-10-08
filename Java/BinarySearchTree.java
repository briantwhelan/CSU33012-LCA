/*************************************************************************
 *  {@code BinarySearchTree} class.
 *  Adapted from Sedgewick and Wayne's Algorithms Textbook.
 *  @see <a href="https://algs4.cs.princeton.edu/">Algorithms Textbook</a>
 *
 *  @version 08/08/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BinarySearchTree<Key extends Comparable<Key>, Value> 
{
    private Node root;             

    private class Node 
    {
        private final Key key;       
        private Value value;      	
        private Node left, right; 	
        private int size;

        public Node(Key key, Value value, int size) 
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    
    public BinarySearchTree()
    {

    }

    public int size() 
    { 
	return 0;
    }

    public void put(Key key, Value value) 
    {

    }

    public Value get(Key key) 
    { 
    	return new Value;
    }
    
    @Override
    public String toString() 
    {
	return "";
    }
}
