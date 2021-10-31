import java.util.HashSet;
import java.util.ArrayList;
/*************************************************************************
 *  {@code DirectedGraph} class.
 *  Adapted from Sedgewick and Wayne's Algorithms Textbook.
 *  @see <a href="https://algs4.cs.princeton.edu/">Algorithms Textbook</a>
 *
 *  @version 31/10/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DirectedGraph 
{
    private final int numberOfVertices;
    private int numberOfEdges;
    private HashSet<Integer>[] adjacencyLists;
    private int[] indegrees;

	/**
     * Creates an empty {@code DirectedGraph} with the specified number of vertices
     *
     * @param numberOfVertices the number of vertices to be included in the {@code DirectedGraph}
     */
    public DirectedGraph(int numberOfVertices) throws IllegalArgumentException
    {
       if(numberOfVertices < 0)
		{
			throw new IllegalArgumentException("The number of vertices must be positive");
		}
		
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		
        this.adjacencyLists = (HashSet<Integer>[]) new HashSet[numberOfVertices];
		for(int vertex = 0; vertex < numberOfVertices; vertex++)
		{
			this.adjacencyLists[vertex] = new HashSet<Integer>();
		}

        this.indegrees = new int[numberOfVertices];
        for(int vertex = 0; vertex < numberOfVertices; vertex++)
		{
			this.indegrees[vertex] = 0;
		}
    }

	/**
     * Checks whether the specified vertex is a valid vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex to validate
     * @return {@code true} if {@code vertex} is valid and {@code false} otherwise
     */
    public boolean isValidVertex(int vertex)
    {
        return ((vertex >= 0) && (vertex < numberOfVertices));
    }

	/**
     * Adds the directed edge between the two specified vertices to the {@code DirectedGraph}
     * 
     * @param vertex1 the initial vertex of the edge to be added
     * @param vertex2 the terminal vertex of the edge to be added
     */
    public void addEdge(int vertex1, int vertex2)
    {
		if(isValidVertex(vertex1)
    		&& isValidVertex(vertex2)
    		&& (!adjacencyLists[vertex1].contains(vertex2)))
    	{
	    	adjacencyLists[vertex1].add(vertex2);
            indegrees[vertex2]++;
	    	numberOfEdges++;
    	}
    }

	/**
     * Gets the adjacency list for the specified vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex of which the adjacency list is required
     * @return the vertices adjacent to {@code vertex}
     */
    public Iterable<Integer> getAdjacencyList(int vertex)
    {
    	Iterable<Integer> adjacencyList = null;	
		if(isValidVertex(vertex))
    	{
    		adjacencyList = adjacencyLists[vertex];
    	}    
	
		return adjacencyList;
    }

	/**
     * Gets the outdegree of the specified vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex of which the outdegree is required
     * @return the outdegree of {@code vertex}
     */
    public int getOutdegree(int vertex)
    {
        int outdegree = -1;
        if(isValidVertex(vertex))
        {
            outdegree = adjacencyLists[vertex].size();
        }

        return outdegree;
    }

	/**
     * Gets the indegree of the specified vertex in the {@code DirectedGraph}
     * 
     * @param vertex the vertex of which the indegree is required
     * @return the indegree of {@code vertex}
     */
    public int getIndegree(int vertex)
    {
        int indegree = -1;
        if(isValidVertex(vertex))
        {
            indegree = indegrees[vertex];
        }

        return indegree;
    }

	/**
     * Returns the Lowest Common Ancestor of the two specified vertices (if they exist) in the {@code DirectedGraph}.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return an array containing the Lowest Common Ancestor(s) of {@code vertex1} and {@code vertex2} (or {@code null} if no such vertex exists)
     */
    public int[] lowestCommonAncestor(int vertex1, int vertex2)
    {
        ArrayList<Integer> lcas = new ArrayList<Integer>();
        if(isValidVertex(vertex1) && isValidVertex(vertex2))
        { 
            //Perform bfs on every vertex
            BreadthFirstSearch[] bfss = new BreadthFirstSearch[numberOfVertices];
            for(int vertex = 0; vertex < numberOfVertices; vertex++)
            {
                bfss[vertex] = new BreadthFirstSearch(this, vertex);
            }

            //Find ancestors of two vertices
            ArrayList<Integer> vertex1Ancestors = new ArrayList<Integer>();
            ArrayList<Integer> vertex2Ancestors = new ArrayList<Integer>();
            for(BreadthFirstSearch currentBfs : bfss)
            {
                if(currentBfs.hasPathTo(vertex1))
                {
                    vertex1Ancestors.add(currentBfs.getSourceVertex());
                }
                
                if(currentBfs.hasPathTo(vertex2))
                {
                    vertex2Ancestors.add(currentBfs.getSourceVertex());
                }
            }

            //Find common ancestors
            ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
            for(int index = 0; index < vertex1Ancestors.size(); index++)
            {
                int currentAncestor = vertex1Ancestors.get(index);
                if(vertex2Ancestors.contains(currentAncestor))
                {
                    commonAncestors.add(currentAncestor);
                }
            }

            //Vertices in subgraph containing common ancestors with an outdegree of 0 are LCA(s)
            for(int currentCommonAncestor : commonAncestors)
            {
                int outdegree = getOutdegree(currentCommonAncestor);
                Iterable<Integer> adjacencyList = adjacencyLists[currentCommonAncestor];
                for(int currentVertex : adjacencyList)
                {
                    if(!commonAncestors.contains(currentVertex))
                    {
                        outdegree--;
                    }
                }

                if(outdegree == 0)
                {
                    lcas.add(currentCommonAncestor);
                } 
            }
        }

        //Return array of LCA(s)
        int[] result = null;
        Object[] temp = lcas.toArray();
        if(temp.length > 0)
        {
            result = new int[temp.length];
            for(int index = 0; index < temp.length; index++)
            {
                result[index] = (int)temp[index];
            }
        }

        return result;
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
        String string =  getNumberOfVertices() + " vertices, " + getNumberOfEdges() + " edges\n";
	    for(int vertex = 0; vertex < numberOfVertices; vertex++)
	    {
		    string += vertex + ": ";
		    for(int adjacentVertex : getAdjacencyList(vertex))
		    {
		    	string += adjacentVertex + " ";
		    }
		    string += "\n";
	    }
	    
	    return string;
    }
}

