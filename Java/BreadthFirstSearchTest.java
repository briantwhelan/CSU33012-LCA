import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Stack;
/*************************************************************************
 *  {@code BreadthFirstSearch} test class.
 *
 *  @version 31/10/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BreadthFirstSearchTest
{   	
    /**
     * Test constructor for valid inputs
     */
    @Test
    public void testConstructor()
    {
        DirectedGraph graph = new DirectedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        new BreadthFirstSearch(graph, 0);
    }

	/**
     * Test constructor for invalid inputs
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException()
    {
        DirectedGraph graph = new DirectedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        new BreadthFirstSearch(graph, -1);
    }

    /**
     * Test {@code hasPathTo(int vertex)} 
     */
    @Test
    public void testHasPathTo()
    {
        DirectedGraph graph = new DirectedGraph(3);
        graph.addEdge(0, 1);
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);

        assertEquals("Testing hasPathTo(int vertex) - Checking an invalid path", false, bfs.hasPathTo(2));
        assertEquals("Testing hasPathTo(int vertex) - Checking a valid path", true, bfs.hasPathTo(1));
    }

    /**
     * Test {@code getPathTo(int vertex)} 
     */
    @Test
    public void testGetPathTo()
    {
        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        
        Stack<Integer> expectedPath = new Stack<Integer>();
        expectedPath.push(2);
        expectedPath.push(1);
        expectedPath.push(0);
        assertEquals("Testing getPathTo(int vertex) - Getting an invalid path", null, bfs.getPathTo(3));
        assertEquals("Testing getPathTo(int vertex) - Getting a valid path", expectedPath, bfs.getPathTo(2));
    }

    /**
     * Test {@code getDepthTo(int vertex)} 
     */
    @Test
    public void testGetDepthTo()
    {
        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);

        assertEquals("Testing hasDepthTo(int vertex) - Getting depth for an ivalid vertex", -1, bfs.getDepthTo(-1));
        assertEquals("Testing hasDepthTo(int vertex) - Getting an invalid depth", Integer.MAX_VALUE, bfs.getDepthTo(3));
        assertEquals("Testing hasDepthTo(int vertex) - Getting a valid depth", 1, bfs.getDepthTo(1));
        assertEquals("Testing hasDepthTo(int vertex) - Getting a valid depth", 2, bfs.getDepthTo(2));
    }
}

