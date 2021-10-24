import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.HashSet;
/*************************************************************************
 *  {@code DirectedGraph} test class.
 *
 *  @version 24/10/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DirectedGraphTest
{   	
    /**
     * Test {@code DirectedGraphTest} 
     */
    @Test
    public void testConstructor()
    {
        new DirectedGraph(10);
    }

	/**
     * Test constructor for invalid inputs
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException()
    {
    	new DirectedGraph(-1);
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
     * Test getAdjacencyList(int vertex)
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
     * Test {@code lowestCommonAncestor(int vertex1, int vertex2)}
     */
    @Test
    public void testLowestCommonAncestor()
    {
        
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
