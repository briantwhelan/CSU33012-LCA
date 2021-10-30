import java.util.Stack;
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

	/**
     * Performs BreadthFirstSearch from the specified source vertex in the specified {@code DirectedGraph}
     * 
     * @param graph the {@code DirectedGraph} on which to perform BreadthFirstSearch
     * @param sourceVertex the source vertex from which to perform BreadthFirstSearch
     */
    public BreadthFirstSearch(DirectedGraph graph, int sourceVertex) throws IllegalArgumentException
    {
        if(!graph.isValidVertex(sourceVertex))
        {
            throw new IllegalArgumentException("The source vertex must be in the graph");
        }

        this.graph = graph;
        this.sourceVertex = sourceVertex;

        performBreadthFirstSearch(graph, sourceVertex);
    }

    /**
     * Performs BreadthFirstSearch from the specified source vertex in the specified {@code DirectedGraph}
     * 
     * @param graph the {@code DirectedGraph} on which to perform BreadthFirstSearch
     * @param sourceVertex the source vertex from which to perform BreadthFirstSearch
     */
    private void performBreadthFirstSearch(DirectedGraph graph, int sourceVertex)
    {
    }

    /**
     * Checks whether there exists a path from {@code sourceVertex} to the specified vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex to check if a path exists to from the {@code sourceVertex}
     * @return {@code true} if a path exists from {@code sourceVertex} to {@code vertex}  and {@code false} otherwise
     */
    public boolean hasPathTo(int vertex)
    {
        boolean hasPathTo = false;

        return hasPathTo;
    }
    
    /**
     * Gets a path from {@code sourceVertex} to the specified vertex (if it exists) in the {@code DirectedGraph}
     * 
     * @param vertex the vertex to get a path to from the {@code sourceVertex}
     * @return a path from {@code sourceVertex} to {@code vertex} (or {@code null} if no such path exists)
     */
    public Iterable<Integer> getPathTo(int vertex)
    {
        Stack<Integer> path = null;

        return path;        
    }

    /**
     * Gets the depth of the path from {@code sourceVertex} to the specified vertex (if it exists) in the {@code DirectedGraph}
     * 
     * @param vertex the vertex to get the depth to from the {@code sourceVertex}
     * @return the depth of {@code vertex} from {@code sourceVertex} (or @code Integer.MAX_VALUE if no such path exists)
     */
    public int getDepthTo(int vertex)
    {
        int depth = Integer.MAX_VALUE;

        return depth;
    } 
}

