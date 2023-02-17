/*A computer programmer is setting up a LAN network, such that each computer in 
the network has 1 wire that loops around to itself and 1 wire between each 
computer in the network. In other words, we have the following:

If there is 1 computer in the network, then 1 wire is needed (the wire that loops 
around from that computer to itself). 
If there are 2 computers in the network, then 3 wires are needed (1 wire looped 
from each computer to itself, accounting for 2 wires, and 1 wire between the two
computers in the network).
If there are 3 computers in the network, then 6 wires are needed (1 wire from 
each computer to itself, accounting for 3 wires, and 1 wire between each of the
computers in the network, accounting for 3 wires).
If there are 4 computers in the network, then 10 wires are needed (1 wire from
each computer to itself, accounting for 4 wires, and 1 wire between each of the 
computers in the network, accounting for 6 wires).
Given the number of computers count the number of wires required
*/

import java.util.*;
class NumberofWires 
{
	static int count(int n)
	{
		//logic
		// int c=n+(n*(n-1))/2;
        int c=(n*(n+1))/2;
		return c;
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n value");
		//read n
		int n=s.nextInt();
		//call function
		int c=count(n);
		//print the value
		System.out.println(c);
        s.close();
	}
}
