/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites
where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take 
course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*/
import java.util.*;

public class CourseSchedule 
{
    public static boolean canFinish(int numCourses, int[][] prerequisites) 
	{
        int adjList[][]=new int[numCourses][numCourses];

        
        int[] inDegree = new int[numCourses];
        // Populate the adjacency list with prerequisites and update inDegree of vertices
        for(int pre[]:prerequisites)
        {
            int u=pre[0],v=pre[1];
            adjList[v][u]=1;
            inDegree[u]++;
        }
        // Perform a topological sort to find the order in which the courses should be taken
        Queue<Integer> queue = new java.util.LinkedList<>();
        //add vertices with indegree 0 to q
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0) queue.offer(i);
        }
        
        int count = 0;
		int[] order = new int[numCourses];
        int index = 0;
        //generate the order and count based on queue
        while(!queue.isEmpty())
        {
            int u=queue.poll();
            order[index++]=u;
            count++;
            for(int v=0;v<numCourses;v++)
            {
                if(adjList[u][v]==1 && --inDegree[v]==0) queue.offer(v);
            }
        }
        
        if(count == numCourses)
		{
			for(int i=0;i<count;i++)
				System.out.print(order[i]+" ");
			return true;
		}
		else
		{
			return false;
		}
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int nc=s.nextInt();
		int c=s.nextInt();
		int prereq[][]=new int[c][2];
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<2;j++)
			{
				prereq[i][j]=s.nextInt();
			}
		}
		System.out.println(canFinish(nc, prereq));
        s.close();
	}
}
