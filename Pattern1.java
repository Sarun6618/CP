import java.util.*;
class Pattern1 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter odd number of rows");
		int n=sc.nextInt();
        sc.close();
		for(int i=1;i<=n/2+1;i++){
		    for(int j=1;j<=i;j++){
		        System.out.print(i*j+" ");
		    }
		    System.out.println();
		}
		int kk=n/2;
		for(int i=n-n/2+1;i<=n;i++){
		    for(int j=1;j<=kk;j++){
		        System.out.print(i*j+" ");
		    }
		    kk=kk-1;
		    System.out.println();
		}
	}
}