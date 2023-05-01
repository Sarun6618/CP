import java.util.*;

public class MaxFlow 
{
    static int V; // number of vertices in the graph
    
    // method to find the maximum flow in a flow network using the Edmonds-Karp algorithm
    static int findMaxFlow(int[][] graph, int source, int sink) 
	{
        int[][] residualGraph = new int[V][V];
        //copy graph into residual graph 
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                residualGraph[i][j]=graph[i][j];
            }
        }
        
        int[] parent = new int[V];
        int maxFlow = 0;
        
        while (bfs(residualGraph,source,sink,parent)) 
		{
            int pathFlow = Integer.MAX_VALUE;
            //find min path flow
            for(int v=sink;v!=source;v=parent[v])
            {
                int u=parent[v];
                pathFlow=Math.min(pathFlow,residualGraph[u][v]);
            }
            
            //update residual graph and maxFlow
            for(int v=sink;v!=source;v=parent[v])
            {
                int u=parent[v];
                residualGraph[u][v]-=pathFlow;
                residualGraph[v][u]+=pathFlow;
            }
            maxFlow+=pathFlow;
           
        }
        return maxFlow;
    }
    
    // helper method to find the shortest augmenting path in the residual graph using BFS
    static boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) 
	{
        boolean[] visited = new boolean[V];
        //update visited with false
       
        Queue<Integer> queue = new java.util.LinkedList<>();
        //add source to queue
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        while(!queue.isEmpty())
        {
            int u=queue.poll();
            for(int v=0;v<V;v++)
            {
                if(visited[v]==false && residualGraph[u][v]>0)
                {
                    queue.add(v);
                    visited[v]=true;
                    parent[v]=u;
                }
            }
        }
        return visited[sink];
    }
    
    public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
        System.out.println("Enter number of vertices");
		V=s.nextInt();
        int[][] graph = new int[V][V]; 
		System.out.println("Enter the adjacency matrix of the directed graph");
		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
			graph[i][j]=s.nextInt();
		System.out.println("Enter source and sink");
        int source = s.nextInt();
		int sink = s.nextInt();
        int maxFlow = findMaxFlow(graph, source, sink);
        System.out.println(maxFlow);
        s.close();
    }
}
