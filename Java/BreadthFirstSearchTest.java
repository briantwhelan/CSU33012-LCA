import org.junit.Test;
import static org.junit.Assert.assertEquals;
/*************************************************************************
 *  {@code BreadthFirstSearch} test class.
 *
 *  @version 30/10/21
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
}

