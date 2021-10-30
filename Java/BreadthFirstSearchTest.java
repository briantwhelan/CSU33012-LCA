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
     * Test constructor
     */
    @Test
    public void testConstructor()
    {
        new BreadthFirstSearch(new DirectedGraph(0), 0);
    }
}

