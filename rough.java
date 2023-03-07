import java.util.*;
class rough
{
	public static void main(String[] args) 
    {
		System.out.println("Hello World");
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int start = 2;
        int end = 5;
        int[] subarray = Arrays.copyOfRange(arr, start, end + 1);
        // Print the subarray
        System.out.println(Arrays.toString(subarray));

	}
}
