import java.util.HashSet;
/*************************************************************************
 *  {@code DirectedGraph} class.
 *  Adapted from Sedgewick and Wayne's Algorithms Textbook.
 *  @see <a href="https://algs4.cs.princeton.edu/">Algorithms Textbook</a>
 *
 *  @version 24/10/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DirectedGraph 
{
    private final int numberOfVertices;
    private int numberOfEdges;
    private HashSet<Integer>[] adjacencyLists;

	/**
     * Create an empty directed graph with a particular number of vertices
     * @param: number of vertices to be included in directed graph
     */
    public DirectedGraph(int numberOfVertices) throws IllegalArgumentException
    {
       if(numberOfVertices < 0)
		{
			throw new IllegalArgumentException("Number of vertices must be positive");
		}
		
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		this.adjacencyLists = (HashSet<Integer>[]) new HashSet[numberOfVertices];
		for(int vertex = 0; vertex < numberOfVertices; vertex++)
		{
			adjacencyLists[vertex] = new HashSet<Integer>();
		}
    }

	/**
     * Add an edge to the directed graph
     * 
     * @param vertex1: start vertex of edge to be added
     * @param vertex2: end vertex of edge to be added
     */
    public void addEdge(int vertex1, int vertex2)
    {
		if((vertex1 >= 0) && (vertex1 < numberOfVertices)
    		&& (vertex2 >= 0) && (vertex2 < numberOfVertices)
    		&& (!adjacencyLists[vertex1].contains(vertex2)))
    	{
	    	adjacencyLists[vertex1].add(vertex2);
	    	numberOfEdges++;
    	}
    }

	/**
     * Returns the Lowest Common Ancestor of the two specified vertices (if they exist) in the {@code DirectedGraph}.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the {@code int} corresponding to the Lowest Common Ancestor vertex of {@code vertex1} and {@code vertex2} (or {@code null} if no such vertex exists)
     */
    public int lowestCommonAncestor(int vertex1, int vertex2)
    {
        return 0;
    }

	 /**
     * Gets the number of vertices in the {@code DirectedGraph}
     * 
     * @return the number of vertices in the {@code DirectedGraph}
     */
    public int getNumberOfVertices()
    {
        return numberOfVertices;
    }

	 /**
     * Gets the number of edges in the {@code DirectedGraph}
     * 
     * @return the number of edges in the {@code DirectedGraph}
     */
    public int getNumberOfEdges()
    {
        return numberOfEdges;
    }

	/**
     * Gets the {@code String} representation of the {@code DirectedGraph}.
     * 
     * @return the {@code String} representation of the {@code DirectedGraph}
     */
	@Override
    public String toString()
    {
        return "";
    }
}

