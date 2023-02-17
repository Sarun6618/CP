import java.util.*;
public class Palindrome_Permutation 
{
      public static boolean canPermutePalindrome(String s) 
	  {
            //create a Map of Character and Integer
            // HashMap<Character,Integer>m=new HashMap<>();
            // int n=s.length();
            // for(int i=0;i<n;i++)
            // m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
            // int ct=0;
            // for(Map.Entry<Character,Integer>e:m.entrySet())
            // {
            //     ct+=(int)(e.getValue())%2;
            // }
            // //count the number of each characters

            // //initialise ct to 0
            
            // return ct < 2;
            HashSet<Character>str=new HashSet<>();
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                if(!str.add(s.charAt(i)))
                str.remove(s.charAt(i));
            }
            return str.size()<2;

        }

		public static void main(String[] args) 
		{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter a string");
			String str=s.next();
			System.out.println(canPermutePalindrome(str));
            s.close();
		}
    }