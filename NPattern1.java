import java.util.*;
public class NPattern1
{
    public static void main(String[] args)
    {
        // Create a new Scanner object
        // Get the number of rows from the user
        System.out.println("Enter the number of rows");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int x = 1;
        boolean val = true;
        for(int i=0;i<n;i++){
            if(val){
                for(int j=0;j<n;j++){
                    a[j][i]=x++;
                }
            }else{
                for(int j=n-1;j>=0;j--){
                    a[j][i]=x++;
                }
            }
            val=!val;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        //logic
        sc.close();
    }
}