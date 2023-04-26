import java.util.*;

class Graph {
    private int V; // number of vertices
    private int[][] adj; // adjacency matrix
    private int time; // time used in DFS
    
    public Graph(int V) 
    {
        this.V=V;
        adj=new int[V][V];
    }
    
    // add an edge to the graph
    public void addEdge(int v, int w) 
    {
        adj[v][w]=1;
        adj[w][v]=1;
    }
    
    // utility function to find bridges in the graph
    private void bridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
        // mark current node as visited and initialize discovery time and low value
        visited[u]=true;
        disc[u]=low[u]=++time;
        
        // loop through all vertices adjacent to this vertex
        for (int v = 0; v < V; v++) 
        {
            if(adj[u][v]==1)
            {
                if(!visited[v]) 
                {
                    parent[v]=u;
                    bridgeUtil(v,visited,disc,low,parent);
                    low[u]=Math.min(low[u],low[v]);
                // if v is not visited yet, then recur for it
                
                    // check if the subtree rooted with v has a connection to one of the ancestors of u
                    
                    // if the lowest vertex reachable from subtree under v is below u in DFS tree, then u-v is a bridge
                   if (low[v] > disc[u]) {
                        System.out.println(u + " " + v);
                    }
                }
                else if(v!=parent[u]) low[u]=Math.min(low[u],disc[v]);
            }
                // update low value of u for parent function calls
        }
    }
    
    // main function to find bridges in the graph
    public void bridge() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        
        // initialize parent and visited arrays
        for(int i=0;i<V;i++)
        {
            parent[i]=-1;
            visited[i]=false;
        }
        
        // call the recursive helper function to find bridges
        for(int i=0;i<V;i++)
        {
            if(!visited[i]) bridgeUtil(i,visited,disc,low,parent);
        }
    }
}

public class Bridges {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int vertices = s.nextInt();
        int edges = s.nextInt();

		Graph g = new Graph(vertices);
		
		for (int i = 1; i <= edges; i++) 
		{
            int start = s.nextInt(); 
            int end = s.nextInt();
			g.addEdge(start, end);
        }
		
		System.out.println("Bridges in the graph:");
        g.bridge();
        s.close();
    }
}