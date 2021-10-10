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
        if(value == null)
        {
            delete(key);
        }
        else
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
     * Deletes the specified {@code Key} (if it exists) from the {@code BinarySearchTree}.
     * Uses Hibbard deletion to replace deleted {@code Node} with its predecessor.
     *
     * @param key the {@code Key} to delete from the {@code BinarySearchTree}
     */
    public void delete(Key key) 
    {
    	if(root != null)
    	{
    	    root = delete(root, key);
    	}
    }
    
    /**
     * (Recursively) Deletes the specified {@code Key} (if it exists) from the {@code BinarySearchTree} rooted at the specified {@code Node}.
     * Uses Hibbard deletion to replace deleted {@code Node} with its predecessor.
     *
     * @param node the root {@code Node}
     * @param key the {@code Key} to delete from the {@code BinarySearchTree} rooted at {@code node}
     * @return the {@code Node} that has been updated
     */
    private Node delete(Node node, Key key)
    { 
    	Node updatedNode = null;
    	if(node == null) 
    	{
    	    updatedNode = null;
    	}
    	else
    	{
	        int cmp = key.compareTo(node.key);
	        if(cmp < 0) 
	        {
	    	    node.left = delete(node.left, key);
	    	    node.size = size(node.left) + size(node.right) + 1;
	    	    updatedNode = node;
	        }
	        else if(cmp > 0) 
	        {
	    	    node.right = delete(node.right, key);
	    	    node.size = size(node.left) + size(node.right) + 1;
	    	    updatedNode = node;
	        }
	        else 
	        {
	            if(node.right == null) 
	            {
	        	    updatedNode = node.left;
	            }
	            else if(node.left == null)
	            {
	        	    updatedNode = node.right;
	            }
	            else
	            {
		            Node temp = node;
		            node = max(temp.left);
		            node.left = deleteMax(temp.left);
		            node.right = temp.right;
		            node.size = size(node.left) + size(node.right) + 1;
		    	    updatedNode = node;
	            }
	        }
        }
    	
    	return updatedNode;
    }
    
    /**
     * Deletes the maximum {@code Key} (if it exists) from the {@code BinarySearchTree}.
     */
    public void deleteMax() 
    {
    	if(root != null)
    	{
    	    root = deleteMax(root);
    	}
    }
    
    /**
     * (Recursively) Deletes the maximum {@code Key} (if it exists) from the {@code BinarySearchTree} rooted at the specified {@code Node}.
     * 
     * @param node the root {@code Node}
     * @return the {@code Node} that has been updated
     */
    private Node deleteMax(Node node)
    {
    	Node updatedNode = null;
    	if(node.right == null) 
    	{
    	    updatedNode = node.left;
    	}
    	else
    	{
    	    node.right = deleteMax(node.right);
    	    node.size = 1 + size(node.left) + size(node.right);
    	    updatedNode = node;
    	}
    	
    	return updatedNode;
    }
    
    /**
     * Returns the {@code Value} associated with the {@code Node} with the maximum {@code Key} in the {@code BinarySearchTree}.
     * 
     * @return the {@code Value} associated with the {@code Node} with the maximum {@code Key} in the {@code BinarySearchTree}
     */
    public Value max() 
    {
    	Value max = null;
    	if(root != null)
    	{
    	    max = max(root).value;
    	}
    	
    	return max;
    }
    
    /**
     * (Recursively) Returns the {@code Node} with the maximum {@code Key} in the {@code BinarySearchTree} rooted at the specified {@code Node}.
     * 
     * @param node: the root {@code Node}
     * @return the {@code Node} with the maximum {@code Key} in the {@code BinarySearchTree} rooted at {@code node}
     */
    private Node max(Node node)
    {
    	Node max;
    	if(node.right == null) 
    	{
    	    max = node;
    	}
    	else
    	{
    	    max = max(node.right);
    	}
    	
    	return max;
    }
	
	/**
     * Returns the Lowest Common Ancestor of the two specified elements (if they exist) in the {@code BinarySearchTree}.
     *
     * @param node1 the first {@code Node}
     * @param node2 the second {@code Node}
     * @return the {@code Key} corresponding to the Lowest Common Ancestor {@code Node} of {@code node1} and {@code node2} (or {@code null} if no such {@code Node exists})
     */
	public Key lowestCommonAncestor(Key node1, Key node2)
	{
		Key lca = null;
		if((node1 != null) && (node2 != null))
		{
			lca = lowestCommonAncestor(root, node1, node2);
		}
		
		return lca;
	}
	
	/**
     * (Recursively) Returns the Lowest Common Ancestor of the two specified elements (if they exist) in the {@code BinarySearchTree} rooted at the specified {@code Node}.
     *
     * @param root the root {@code Node}
     * @param node1 the first {@code Node}
     * @param node2 the second {@code Node}
     * @return the {@code Key} corresponding to the Lowest Common Ancestor {@code Node} of {@code node1} and {@code node2} (or {@code null} if no such {@code Node exists})
     */
	public Key lowestCommonAncestor(Node node, Key node1, Key node2)
	{
		Key lca = null;
        if(node != null)
        {
	        if(node.key == node1 || node.key == node2)
	        {
	        	lca = node.key;
	        }
	        else
	        {
	        	Key left = lowestCommonAncestor(node.left, node1, node2);
		        Key right = lowestCommonAncestor(node.right, node1, node2);
		 
		        if(left != null && right != null)
		        {
		        	lca = node.key;
		        }
		        else
		        {
		        	lca = (left == null) ? right : left;
		        }
	        }
		}

		return lca;
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
    
    /**
     * Gets the {@code String} representation of the {@code BinarySearchTree}.
     * 
     * @return the {@code String} representation of the {@code BinarySearchTree}
     */
    @Override
    public String toString() 
    {
    	String string = "";
    	if(root == null)
    	{
    	    string = "-null\n";
    	}
    	else
    	{
    	    string = toString(root, "");
    	}
    	
    	return string;
    }
    
    /**
     * (Recursively) Gets the {@code String} representation of the {@code BinarySearchTree} rooted at the specified {@code Node}.
     *
     * @param node the root {@code Node}
     * @param prefix the current {@code String} representation of the {@code BinarySearchTree} rooted at {@code node} 
     * @return the {@code String} representation of the {@code BinarySearchTree} rooted at {@code node}
     */
    private String toString(Node node, String prefix)
    {
    	String string = "";
    	if(node == null)
    	{
    	    string = prefix + "-null\n";
    	}
    	else
    	{
    	    string = prefix + "-" + node.key + "\n"
    						+ toString(node.left, prefix + " |")  
    						+ toString(node.right, prefix + "  ");
    	}
    	
    	return string;
    }
}

