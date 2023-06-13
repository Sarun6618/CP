import java.util.*;
class DietPlanPerformance
{
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper)
	{
		int points = 0;
		int sum = 0;
		//logic
		for(int i=0;i<k;i++)
		{
		    sum=sum+calories[i];
		}
		if(sum>upper)
		{
		    points++;
		}
		else if(sum < lower)
		{
		    points--;
		}
		int length=calories.length;
		for(int i=k;i<length;i++){
		    sum=sum+calories[i]-calories[i-k];
		    if(sum>upper)
		    {
		        points++;
		    }
		    else if(sum < lower)
		    {
		        points--;
		    }
		}
		return points;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter calories size");
		int n=sc.nextInt();
		int calories[]=new int[n];
		System.out.println("enter the calroties");
		//read
		for(int i=0;i<n;i++)
		{
		    calories[i]=sc.nextInt();
		}
		System.out.println("enter the days");
		//read
		int k=sc.nextInt();
		System.out.println("enter the Lower value");
		//read
		int l=sc.nextInt();
		System.out.println("enter the Upper value");
		//read
		int u=sc.nextInt();
		System.out.println(new DietPlanPerformance().dietPlanPerformance(calories,k,l,u));
        sc.close();
	}
}