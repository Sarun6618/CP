import java.util.*;
import java.util.Stack;

public class TopologicalSort 
{
    static int V; // number of vertices
    static int[][] adjMatrix; // adjacency matrix
    private Stack<Integer> stack; // stack for storing sorted vertices
    
    public TopologicalSort(int V) 
	{
        //initializations
        TopologicalSort.V=V;
        adjMatrix =new int[V][V];
        stack=new Stack<>();
    }
    
    public void addEdge(int i, int j) 
	{
        //assignment
        adjMatrix[i][j]=1;
    }
    
    public void topologicalSort() 
	{
        boolean[] visited = new boolean[V];
        //assign false values to visited array
        
        //dfs logic calling topologicalSortUtil
        for(int i=0;i<V;i++)
        {
            if(!visited[i]) topologicalSortUtil(i,visited);
        }
        
        System.out.println("Topological sorting order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    private void topologicalSortUtil(int v, boolean[] visited)
	{
        visited[v] = true;
        
        //logic
        for(int w=0;w<V;w++)
        {
            if(adjMatrix[v][w]==1 && !visited[w]) topologicalSortUtil(w,visited);
        }
        stack.push(v);
    }
    
    public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		V=s.nextInt();
		TopologicalSort g = new TopologicalSort(V);
		int E=s.nextInt();
		for(int i=1;i<=E;i++)
		{
			int u=s.nextInt();
			int v=s.nextInt();
			g.addEdge(u,v);
		}
        g.topologicalSort();
        s.close();
    }
}