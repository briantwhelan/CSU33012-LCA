/*************************************************************************
 *  {@code BreadthFirstSearch} class.
 *  
 *  @version 30/10/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BreadthFirstSearch 
{
    private DirectedGraph graph;
    private final int sourceVertex;
   
    public BreadthFirstSearch(DirectedGraph graph, int sourceVertex)
    {
        this.graph = graph;
        this.sourceVertex = sourceVertex;
    }
}

