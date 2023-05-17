import java.util.*;

class Graph 
{
    private int V; // number of vertices
    private int[][] adj; // adjacency matrix
    private int time; // time used in DFS
    private static final int NIL = -1; // constant value for uninitialized variables
    
    public Graph(int V) 
	{
        //logic
        adj=new int[V][V];
        this.V=V;
    }
    
    // add an edge to the graph
    public void addEdge(int v, int w) 
	{
        //logic
        adj[v][w]=1;
        adj[w][v]=1;
    }
    
    // utility function to find articulation points in the graph
    private void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) 
	{
        // count children in DFS tree
        int children = 0;
        
        // mark current node as visited and initialize discovery time and low value
       visited[u]=true;
       disc[u]=low[u]=++time;
        
        // loop through all vertices adjacent to this vertex
        for(int w=0;w<V;w++)
        {
            if(adj[u][w]==1)
            {
                if(!visited[w])
                {
                    children++;
                    parent[w]=u;
                    APUtil(w,visited,disc,low,parent,ap);
                    low[u]=Math.min(low[u],low[w]);
                    if(parent[u]==NIL && children>1) ap[u]=true;
                    if(parent[u]!=NIL && low[w]>=disc[u]) ap[u]=true;
                }
                else if(w!=parent[u]) 
                low[u]=Math.min(low[u],disc[w]);
            }
        }
        
                // if v is not visited yet, then make it a child of u in DFS tree and recur for it
                
                    // check if the subtree rooted with v has a connection to one of the ancestors of u
                    
                    
                    // u is an articulation point in the following cases:
                    // 1. u is the root of DFS tree and has two or more children
                    
                    
                    // 2. if u is not the root and low value of one of its child is more than discovery value of u
                    
                // update low value of u for parent function calls
                
    }
    
    // main function to find articulation points in the graph
    public void AP() 
	{
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];
        
        // initialize parent and visited, and ap arrays
        for(int i=0;i<V;i++)
        {
            ap[i]=false;
            visited[i]=false;
            parent[i]=NIL;
        }
        
        
        // call the recursive helper function to find articulation points
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            APUtil(i,visited,disc,low,parent,ap);
        }
        
        // print articulation points
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.print(i + " ");
            }
        }
    }
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

public class APandBridge 
{
    public static void main(String[] args) 
	{
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
        char c=s.next().charAt(0);
        switch(c)
        {
            case 'a':System.out.println("Articulation Point");
            g.AP();
            break;
            case 'b':System.out.println("Bridge");
            g.bridge();
            break;
        }
        s.close();
	}
}