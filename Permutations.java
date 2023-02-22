import java.util.*;
class Permutations
{
    // Utility function to swap two characters in a character array
    private static void swap(char[] chars, int i, int j)
    {
        char t=chars[i];
        chars[i]=chars[j];
        chars[j]=t;
    }
 
    // Recursive function to generate all permutations of a string
    private static void permutations(char[] chars, int currentIndex)
    {
        if (currentIndex == chars.length - 1) {
            System.out.println(String.valueOf(chars));
        }
 
        //logic
        for(int i=currentIndex;i<chars.length;i++)
        {
            swap(chars,currentIndex,i);
            permutations(chars,currentIndex+1);
            swap(chars,currentIndex,i);
        }
    }
 
    public static void findPermutations(String str) 
	{
         // base case
         if(str==null||str.length()==0)
         return;
        //logic
         permutations(str.toCharArray(), 0);
    }
 
    // generate all permutations of a string in Java
    public static void main(String[] args)
    {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a string");
        //logic
        String st=s.next();
        findPermutations(st);
        s.close();
    }
}