import java.util.*;
class TopKFrequentElements 
{
    private static int[] printKFrequent(int[] nums, int k) 
	{
       	//create a hashmap, arraylist
       	Map<Integer, Integer> hp = new HashMap<>();
       	ArrayList<Integer> ls = new ArrayList<>();
        int arr[]=new int[k];
        //place value in hashmap
        for(int i = 0; i < nums.length; i++){
            hp.put(nums[i], hp.getOrDefault(nums[i],0)+1);
        }
        //retrieve values using entryset mathod and store in arraylist
        for(Map.Entry<Integer, Integer>e:hp.entrySet()){
            ls.add(e.getValue());
        }
        //sort the values in array list
        Collections.sort(ls);
        int j=ls.size()-1;
        //copy k values into arr[]
        for(int i = 0; i < arr.length; i++){
            for(Map.Entry<Integer, Integer> e: hp.entrySet()){
                if(ls.get(j) == e.getValue()){
                    arr[i] = e.getKey();
                    hp.remove(e.getKey());
                    j--;
                    break;
                }
            }
        }
        return arr;
    }
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
 		a[i]=sc.nextInt();
 		int k=sc.nextInt();
		int p[]=printKFrequent(a,k);
		for(int i=0;i<k;i++)
		System.out.print(p[i]+" ");
        sc.close();
	}
}