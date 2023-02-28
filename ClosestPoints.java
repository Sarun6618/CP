/*This problem was asked by Google.

Given a set of points (x, y) on a 2D cartesian plane, find the two closest points. 
For example, given the points [(1, 1), (-1, -1), (3, 4), (6, 1), (-1, -6), (-4, -3)], 
return [ (1, 1),(-1, -1),].
Sample Input/Output
Input:6                                                                                                                       
1 1                                                                                                                     
-1 -1                                                                                                                   
3 4                                                                                                                     
6 1                                                                                                                     
-1 -6                                                                                                                   
-4 -3 
Output:1,1                                                                                                                     
-1,-1   
*/
import java.util.*;
//create a Points class with x,y as integers
class Points
{
    int x,y;
    Points(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}

class ClosestPoints 
{
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		Points[] p=new Points[n];
		for(int i=0;i<n;i++)
		{
		    int x=s.nextInt(),y=s.nextInt();
		    p[i]=new Points(x,y);
		}
        s.close();
		Points p1=null,p2=null;
		double min=Double.MAX_VALUE;
		for(int i=0;i<n-1;i++)
		{
		    for(int j=i+1;j<n;j++)
		    {
		        double d=Math.sqrt(Math.pow((p[j].x-p[i].x),2)+Math.pow((p[j].y-p[i].y),2));
		        if(min>d)
		        {
		            min=d;
		            p1=p[i];
		            p2=p[j];
		        }
		    }
		}
		System.out.println(p1.x+","+p1.y);
		System.out.println(p2.x+","+p2.y);
	}
}
