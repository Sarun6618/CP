import java.util.*;

public class TSort 
{
    static int V; // number of vertices
    static int[][] adjMatrix; // adjacency matrix

    public TSort(int V) 
	{
        //initialization
        TSort.V=V;
        adjMatrix=new int[V][V];
    }

    public void addEdge(int u, int v) 
	{
        //logic
        adjMatrix[u][v]=1;
    }

    public List<Integer> sort() 
	{
        int[] inDegree = new int[V]; // array to store indegrees of vertices
        //compute indegrees
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                inDegree[j]+=adjMatrix[i][j];
            }
        }

        Queue<Integer> queue = new java.util.LinkedList<>();
        //store vertices with indegree 0 into queue
        for(int u=0;u<V;u++)
        {
            if(inDegree[u]==0)
            queue.offer(u);
        }

        List<Integer> sortedList = new ArrayList<>();
        //logic
        while(!queue.isEmpty())
        {
            int u=queue.poll();
            sortedList.add(u);
            for(int w=0;w<V;w++)
            {
                if(adjMatrix[u][w]==1 && --inDegree[w]==0)
                queue.offer(w);
            }
        }
        if (sortedList.size() != V) 
		{
            System.out.println("Graph has a cycle");
        }
        return sortedList;
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		V=s.nextInt();
		TSort g = new TSort(V);
		int E=s.nextInt();
		for(int i=1;i<=E;i++)
		{
			int u=s.nextInt();
			int v=s.nextInt();
			g.addEdge(u,v);
		}
        System.out.println(g.sort());
        s.close();
	}
}