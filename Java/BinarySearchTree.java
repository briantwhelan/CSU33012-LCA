/*************************************************************************
 *  {@code BinarySearchTree} class.
 *  Adapted from Sedgewick and Wayne's Algorithms Textbook.
 *  @see <a href="https://algs4.cs.princeton.edu/">Algorithms Textbook</a>
 *
 *  @version 09/10/21
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

		/**
         * Creates a {@code Node} with the specified attributes.
         * @param key the {@code Key} to be stored within the {@code Node}
         * @param value the {@code Value} to be associated with {@code key} 
         * @param size the size of the {@code BinarySearchTree} with its {@code root} at this {@code Node}
         */
        public Node(Key key, Value value, int size) 
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    
	/**
     * Creates an empty {@code BinarySearchTree}.
     */
    public BinarySearchTree()
    {
		root = null;
    }

    /**
     * Returns the size of the {@code BinarySearchTree}. 
     * That is, the number of {@code Key}-{@code Value} pairs/{@code Node} elements in the {@code BinarySearchTree}.
     * 
     * @return the size of the {@code BinarySearchTree}
     */
    public int size() 
    { 
    	return size(root); 
    }

    /**
     * Returns the size of the {@code BinarySearchTree} rooted at the specified {@code Node}. 
     * 
     * @param node the root {@code Node}
     * @return the size of the {@code BinarySearchTree} rooted at {@code node}
     */
    private int size(Node node) 
    {
    	int size = 0;
        if(node != null) 
        {
            size = node.size;
        }
        
        return size;
    }
	
	/**
     *  Puts the specified {@code Key}-{@code Value} pair into the {@code BinarySearchTree}.
     *  If the specified {@code Key} already exists, update its {@code Value}.
     *
     *  @param key the {@code Key} to insert/update in the {@code BinarySearchTree}
     *  @param value the {@code Value} to be associated with {@code key}
     */
    public void put(Key key, Value value) 
    {
        if(value != null) 
        {
            root = put(root, key, value);
        }
    }

    /**
     *  (Recursively) Puts the specified {@code Key}-{@code Value} pair into the {@code BinarySearchTree} rooted at the specified {@code Node}.
     *  If the specified {@code Key} already exists, update its {@code Value}.
     *
     *  @param node the root {@code Node}
     *  @param key the {@code Key} to insert/update in the {@code BinarySearchTree} rooted at {@code node}
     *  @param value the {@code Value} to be associated with {@code key} 
     *  @return the {@code Node} that has been added/updated
     */
    private Node put(Node node, Key key, Value value) 
    {
        if(node == null) 
        {
            node = new Node(key, value, 1);
        }
        else
        {
            int cmp = key.compareTo(node.key);
            if(cmp < 0) 
	        {
	            node.left = put(node.left, key, value);
	        }
	        else if(cmp > 0) 
	        {
	            node.right = put(node.right, key, value);
	        }
	        else
	        {
	            node.value = value;
	        }
	        node.size = 1 + size(node.left) + size(node.right);
        }
        
        return node;
    }

     /**
     * Returns the {@code String} containing all {@code Key} elements in the {@code BinarySearchTree} in-order with parentheses.
     * That is, for each {@code Node}, the {@code Key} elements in the left subtree appear before the {@code Key} in the {@code Node} 
     * and the {@code Key} elements in the right subtree appear after the {@code Key} in the {@code Node}).
     *
     * @return the {@code String} containing all {@code Key} elements of the {@code BinarySearchTree} in-order with parentheses
     */
    public String printKeysInOrder() 
    {
    	String keysInOrder = "";
    	if(root == null)
    	{
    	    keysInOrder = "()";
    	}
    	else
    	{
    	    keysInOrder = printKeysInOrder(root);
    	}
    	
    	return keysInOrder;
    }
    
    /**
     * (Recursively) Returns the {@code String} containing all {@code Key} elements in the {@code BinarySearchTree} rooted at the specified {@code Node} in-order with parentheses.
     * That is, for each {@code Node}, the {@code Key} elements in the left subtree appear before the {@code Key} in the {@code Node} 
     * and the {@code Key} elements in the right subtree appear after the {@code Key} in the {@code Node}).
   ` *
     * @param node the root {@code Node}
     * @return the {@code String} containing all {@code Key} elements of the {@code BinarySearchTree} rooted at {@code node} in-order with parentheses
     */
    private String printKeysInOrder(Node node)
    {
    	String keysInOrder = "";
    	if(node == null)
    	{
    	    keysInOrder = "()";
    	}
    	else
    	{
    	    keysInOrder = "(" + printKeysInOrder(node.left) + node.key + printKeysInOrder(node.right) + ")";
    	}
    	
    	return keysInOrder;
    }
    
    @Override
    public String toString() 
    {
	return "";
    }
}
