import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Anton likes to play chess, and so does his friend Danik.

Once they have played n games in a row. For each game it's known who was the winner —
Anton or Danik. None of the games ended with a tie.

Now Anton wonders, who won more games, he or Danik? Help him determine this.

Input
The first line of the input contains a single integer n (1<=n<=100000) — 
the number of games played.

The second line contains a string s, consisting of n uppercase English letters 'A' and 'D' 
— the outcome of each of the games. The i-th character of the string is equal to 'A' 
if the Anton won the i-th game and 'D' if Danik won the i-th game.

Output
If Anton won more games than Danik, print "Anton" (without quotes) in the only line of the output.

If Danik won more games than Anton, print "Danik" (without quotes) in the only line of the output.

If Anton and Danik won the same number of games, print "Friendship" (without quotes).

Examples//input /output:
input=5
ADAAA
output=Anton

input=6
DDDAAD
output=Danik

input=8
DADADADA
output=Friendship
*/
public class friendWon {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String st=br.readLine();
        int A=0;
        for(int i=0;i<n;i++)
        {
            if(st.charAt(i)=='A') A++;
        }
        if((n/2)-A<0&&n%2!=1)
        System.out.println("Anton");
        if((n/2)-A>0)
        System.out.println("Danik");
        else
        System.out.println("Friendship");
    }
}
