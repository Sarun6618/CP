/*
You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given
an array prerequisites where prerequisites[i] = [prevCoursei, nextCoursei], representing a prerequisite
relationship between course prevCoursei and course nextCoursei: course prevCoursei has to be taken before 
course nextCoursei. Also, you are given the integer k. Return the minimum number of semesters needed to take 
all courses. The testcases will be generated such that it is possible to take every course.

Input: n = 4, prerequisites = [[2,1],[3,1],[1,4]], k = 2
Output: 3
Explanation: 
In the first semester, you can take courses 2 and 3.
In the second semester, you can take course 1.
In the third semester, you can take course 4.
Example 2:


Input: n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2
Output: 4
Explanation: 
In the first semester, you can only take courses 2 and 3 since you cannot take more 
than two per semester.
In the second semester, you can take course 4.
In the third semester, you can take course 1.
In the fourth semester, you can take course 5.

*/
import java.util.*;
import java.util.LinkedList;

public class ParallelCourses 
{
    public int minimumSemesters(int numCourses, int[][] prerequisites,int maxCourses) 
	{
        // create an adjacency list to represent the graph
		int graph[][]=new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];

        // populate the adjacency list using the prerequisites array
        for(int pre[]:prerequisites)
        {
            int u=pre[0];
            int v=pre[1];
            graph[u][v]=1;
            indegree[v]++;
        }
        

        // Perform a topological sort to find the order in which the courses should be taken
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0) queue.offer(i);
        }
        
        int semesters = 0;
        int coursesTaken = 0;
        //logic
        while(!queue.isEmpty())
        {
            int cts=Math.min(queue.size(),maxCourses);
            for(int i=0;i<cts;i++)
            {
                int u=queue.poll();
                coursesTaken++;
                for(int v=0;v<numCourses;v++)
                {
                    if(graph[u][v]==1 && --indegree[v]==0) queue.offer(v);
                }
            }
            semesters++;
        }

        if (coursesTaken != numCourses) {
            return -1; // cannot complete all courses
        }

        return semesters;
    }

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int numCourses=s.nextInt();
		int c=s.nextInt();
		int prerequisites[][]=new int[c][2];
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<2;j++)
			{
				prerequisites[i][j]=s.nextInt();
			}
		}
		int maxCourses=s.nextInt();
		
        ParallelCourses p=new ParallelCourses();

        System.out.println(p.minimumSemesters(numCourses,prerequisites,maxCourses));
        s.close(); 
	}
}