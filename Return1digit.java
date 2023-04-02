
/* Write a java program that takes a number and returns one digit that
is the result of sming all the digits of the input number. 
When the s of the digits consists of more than one digit, 
repeat sming until you get one digit.

Examples
123
6
// 1 + 2 + 3 = 6

999888777L
9

1238763636555555555L
9*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Return1digit {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(br.readLine().trim().replaceAll("L", ""));
        // int s=0;
        while (n > 9) {
            long s = 0;
            while (n != 0) {
                s += n % 10;
                n /= 10;
            }
            n = s;
        }
        // while(n>0||s>9)
        // {
        //     if (n == 0) 
        //     {
        //         n = s;
        //         s = 0;
        //     }
        //     s+=n%10;
        //     n/=10;
        // }
        System.out.println(n);
    }
}
