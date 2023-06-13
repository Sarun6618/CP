import java.util.*;
class rough
{
    public static int[] createTree(int inputs[])
    {
        int bit[]=new int[inputs.length+1];
        for(int i=1;i<inputs.length;i++)
        {
            updateBinaryTree(bit,inputs[i-1],i);
        }
        return bit;
    }
    public static void updateBinaryTree(int bit[],int val,int index)
    {
        while(index<bit.length)
        {
            bit[index]+=val;
            index=getNext(index);
        }
    }
    public static int getNext(int index)
    {
        return index+=index&-index;
    }
    public static int getParent(int index)
    {
        return index-=index&-index;
    }
    public static int getSum(int bit[],int index)
    {
        index++;
        int sum=0;
        while(index>0)
        {
            sum+=bit[index];
            index=getParent(index);
        }
        return sum;
    }
    public static int getRangeSum(int bit[],int i,int j)
    {
        return getSum(bit, j)-getSum(bit, i-1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a[]={3,2,-1,6,5,4,-3,3,7,2};
        int bit[]=createTree(a);
        System.out.println(getSum(bit, 7));
        s.close();
        // dfs(a,v);
    }
}