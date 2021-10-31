import java.util.LinkedList;
import java.util.Queue;
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
    private boolean[] visited;
    private int[] edgeTo;
    private int[] depthTo;

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
        this.visited = new boolean[graph.getNumberOfVertices()];
        this.edgeTo = new int[graph.getNumberOfVertices()];
        this.depthTo = new int[graph.getNumberOfVertices()];

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
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        depthTo[sourceVertex] = 0;
        queue.add(sourceVertex);
        while(!queue.isEmpty())
        {
            int currentVertex = queue.remove();
            for(int adjacentVertex : graph.getAdjacencyList(currentVertex))
            {
                if(!visited[adjacentVertex])
                {
                    visited[adjacentVertex] = true;
                    edgeTo[adjacentVertex] = currentVertex;
                    depthTo[adjacentVertex] = depthTo[currentVertex] + 1;
                    queue.add(adjacentVertex);
                }
            }
        }
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
        if(graph.isValidVertex(vertex))
        {
            hasPathTo = visited[vertex];
        }

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
        if(graph.isValidVertex(vertex) && hasPathTo(vertex))
        {
            path = new Stack<Integer>();
            for(int currentVertex = vertex; currentVertex != sourceVertex; currentVertex = edgeTo[currentVertex])
            {
                path.push(currentVertex);
            }
            path.push(sourceVertex);
        }

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
        if(graph.isValidVertex(vertex))
        {
            depth = depthTo[vertex];
        }

        return depth;
    }

    /**
     * Gets the {@code sourceVertex} in the {@code BreadthFirstSearch}}
     * 
     * @return the {@code sourceVertex} in the {@code BreadthFirstSearch}
     */
    public int getSourceVertex()
    {
        return sourceVertex;
    } 
}

