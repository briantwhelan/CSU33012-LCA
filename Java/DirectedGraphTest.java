import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.HashSet;
/*************************************************************************
 *  {@code DirectedGraph} test class.
 *
 *  @version 31/10/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DirectedGraphTest
{   	
    /**
     * Test constructor for valid input 
     */
    @Test
    public void testConstructor()
    {
        new DirectedGraph(10);
    }

	/**
     * Test constructor for invalid input
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException()
    {
    	new DirectedGraph(-1);
    }
    
    /**
     * Test {@code isValidVertex(int vertex)} 
     */
    @Test
    public void testIsValidVertex()
    {
        DirectedGraph graph = new DirectedGraph(2);
        
        assertEquals("Testing isValidVertex(int vertex) - Checking for an invalid vertex", false, graph.isValidVertex(2));
        assertEquals("Testing isValidVertex(int vertex) - Checking for an invalid vertex", false, graph.isValidVertex(-1)); 
        assertEquals("Testing isValidVertex(int vertex) - Checking for a valid vertex", true, graph.isValidVertex(0));
        assertEquals("Testing isValidVertex(int vertex) - Checking for a valid vertex", true, graph.isValidVertex(1));
    }
	
    /**
     * Test {@code addEdge(int vertex1, int vertex2)} 
     */
    @Test
    public void testAddEdge()
    {
		DirectedGraph graph = new DirectedGraph(3);
    	
    	graph.addEdge(1, 5);
    	assertEquals("Testing addEdge(int vertex1, int vertex2) - Adding an invalid edge", 0, graph.getNumberOfEdges());
    	graph.addEdge(4, 1);
    	assertEquals("Testing addEdge(int vertex1, int vertex2) - Adding an invalid edge", 0, graph.getNumberOfEdges());
    	graph.addEdge(1, -2);
    	assertEquals("Testing addEdge(int vertex1, int vertex2) - Adding an invalid edge", 0, graph.getNumberOfEdges());
    	graph.addEdge(-1, 1);
    	assertEquals("Testing addEdge(int vertex1, int vertex2) - Adding an invalid edge", 0, graph.getNumberOfEdges());
    	graph.addEdge(1, 2);
    	assertEquals("Testing addEdge(int vertex1, int vertex2) - Adding a valid edge", 1, graph.getNumberOfEdges());
    	graph.addEdge(1, 2);
    	assertEquals("Testing addEdge(int vertex1, int vertex2) - Adding a duplicate edge", 1, graph.getNumberOfEdges());     		     
    }

	/**
     * Test {@code getAdjacencyList(int vertex)}
     */
    @Test
    public void testGetAdjacencyList()
    {
    	DirectedGraph graph = new DirectedGraph(3);
    	
    	assertEquals("Testing getAdjacencyList(int vertex) - Getting adjacency matrix for an invalid vertex", null, graph.getAdjacencyList(4));
    	assertEquals("Testing getAdjacencyList(int vertex) - Getting adjacency matrix for an invalid vertex", null, graph.getAdjacencyList(-1));
    	assertEquals("Testing getAdjacencyList(int vertex) - Getting adjacency matrix for a valid vertex", new HashSet<Integer>(), graph.getAdjacencyList(0));
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	assertEquals("Testing getAdjacencyList(int vertex) - Getting adjacency matrix for a valid vertex", new HashSet<Integer>(Arrays.asList(1, 2)), graph.getAdjacencyList(0));    
    }

	/**
     * Test {@code getOutdegree(int vertex)}
     */
    @Test
    public void testGetOutdegree()
    {
    	DirectedGraph graph = new DirectedGraph(3);
    	
    	assertEquals("Testing getOutdegree(int vertex) - Getting the outdegree for an invalid vertex", -1, graph.getOutdegree(4));
    	assertEquals("Testing getOutdegree(int vertex) - Getting the outdegree for an invalid vertex", -1, graph.getOutdegree(-1));
    	assertEquals("Testing getOutdegree(int vertex) - Getting the outdegree for a valid vertex", 0, graph.getOutdegree(0));
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	assertEquals("Testing getOutdegree(int vertex) - Getting the outdegree for a valid vertex", 2, graph.getOutdegree(0));    
    }

    /**
     * Test {@code getIndegree(int vertex)}
     */
    @Test
    public void testGetIndegree()
    {
    	DirectedGraph graph = new DirectedGraph(3);
    	
    	assertEquals("Testing getIndegree(int vertex) - Getting the indegree for an invalid vertex", -1, graph.getIndegree(4));
    	assertEquals("Testing getIndegree(int vertex) - Getting the indegree for an invalid vertex", -1, graph.getIndegree(-1));
    	assertEquals("Testing getIndegree(int vertex) - Getting the indegree for a valid vertex", 0, graph.getIndegree(0));
    	graph.addEdge(0, 2);
    	graph.addEdge(1, 2);
    	assertEquals("Testing getIndegree(int vertex) - Getting the indegree for a valid vertex", 2, graph.getIndegree(2));    
    }

    /**
     * Test {@code lowestCommonAncestor(int vertex1, int vertex2)}
     */
    @Test
    public void testLowestCommonAncestor()
    {
        DirectedGraph graph = new DirectedGraph(4);
        
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA of invalid vertex", null, graph.lowestCommonAncestor(-1, 2));    
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA of invalid vertex", null, graph.lowestCommonAncestor(3, 8));
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on an empty graph", null, graph.lowestCommonAncestor(0, 2));
        graph.addEdge(0, 1);    //      _0_
        graph.addEdge(1, 2);    //         \
        graph.addEdge(2, 3);    //          1
                                //           \
                                //            2
                                //             \
                                //              3
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on a non-empty graph", new int[]{1}, graph.lowestCommonAncestor(1, 3));
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on a non-empty graph", new int[]{2}, graph.lowestCommonAncestor(2, 3));
    

        graph = new DirectedGraph(8);

        graph.addEdge(6, 7);    //      _6_
        graph.addEdge(6, 2);    //     /   \
        graph.addEdge(2, 0);    //   _2_    7
        graph.addEdge(2, 5);    //  /   \
        graph.addEdge(0, 1);    // 0     5
        graph.addEdge(5, 3);    //  \   /
        graph.addEdge(3, 4);    //   1 3
                                //      \
                                //       4
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on a non-empty graph", new int[]{6}, graph.lowestCommonAncestor(2, 7));
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on a non-empty graph", new int[]{6}, graph.lowestCommonAncestor(7, 2));
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on a non-empty graph", new int[]{6}, graph.lowestCommonAncestor(1, 7));
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on a non-empty graph", new int[]{2}, graph.lowestCommonAncestor(1, 4));
    
        graph = new DirectedGraph(9);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);
        graph.addEdge(3, 6);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on a non-empty graph", new int[]{1, 2}, graph.lowestCommonAncestor(4, 7)); 
        assertArrayEquals("Testing lowestCommonAncestor(int vertex1, int vertex2) - Getting LCA on a non-empty graph", new int[]{1, 2}, graph.lowestCommonAncestor(7, 4)); 
    }       

    /**
     * Test {@code toString()} 
     */
    @Test
    public void testToString() 
    {
    	DirectedGraph graph = new DirectedGraph(0);
    	assertEquals("Testing toString()", "0 vertices, 0 edges\n", graph.toString());
    	
        graph = new DirectedGraph(3);
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	assertEquals("Testing toString()", "3 vertices, 2 edges\n0: 1 2 \n1: \n2: \n", graph.toString());  
    }
}

