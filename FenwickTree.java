public class FenwickTree 
{
    /**
     * Start from index+1 if you updating index in original array. Keep adding this value 
     * for next node till you reach outside range of tree
     */
    public void updateBinaryIndexedTree(int bit[], int val, int index)
	{
        //logic
        while(index<bit.length)
        {
            bit[index]+=val;
            index=getNext(index);
        }
    }
    
    /**
     * Start from index+1 if you want prefix sum 0 to index. Keep adding value
     * till you reach 0
     */
    public int getSum(int bit[], int index)
	{
        //logic
        index++;
        int sum=0;
        while(index>0)
        {
            sum+=bit[index];
            index=getParent(index);
        }
        return sum;
    }
    
    /**
     * Creating tree is like updating Fenwick tree for every value in array
     */
    public int[] createTree(int input[])
	{
        //logic
        int bit[]=new int[input.length+1];
        for(int i=1;i<input.length;i++)
        {
            updateBinaryIndexedTree(bit,input[i-1],i);
        }
        return bit;
    }
    
    /**
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     */
    private int getParent(int index)
	{
        //logic
        return index-=index&-index;
    }
    
    /**
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     */
    private int getNext(int index)
	{
        //logic
        return index+=index&-index;
    }
    
	private int getSumRange(int bit[],int i,int j)
	{
		//logic
		return getSum(bit,j)-getSum(bit,i-1);
	}
    public static void main(String args[])
	{
        int input[] = {3,2,-1,6,5,4,-3,3,7,2,3};
        FenwickTree ft = new FenwickTree();
        int bit[] = ft.createTree(input);
        System.out.println(ft.getSum(bit, 4));
        System.out.println(ft.getSum(bit, 5));
        System.out.println(ft.getSum(bit, 6));
		System.out.println("\n\n"+ft.getSumRange(bit, 6, 9));
		ft.updateBinaryIndexedTree(bit,10-input[7],8);
		input[7]=10;
		System.out.println("\n\n"+ft.getSumRange(bit, 6, 9));
    }
}