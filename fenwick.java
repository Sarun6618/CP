import java.util.*;

public class fenwick {
    public static int[] createTree(int a[]) {
        int bit[] = new int[a.length + 1];
        for (int i = 1; i < a.length; i++)
            updatebinaryindex(bit, a[i - 1], i);
        return bit;
    }

    public static void updatebinaryindex(int bit[], int v, int index) {
        while (index < bit.length) {
            bit[index] += v;
            index = getNext(index);
        }
    }

    public static int getNext(int index) {
        return index += index & (-index);
    }

    public static int getParent(int index) {
        return index -= index & (-index);
    }

    public static int getSum(int bit[], int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index = getParent(index);
        }
        return sum;
    }

    public static int getSumRange(int bit[], int i, int j) {
        return getSum(bit, j) - getSum(bit, i - 1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no of elements");
        int n = s.nextInt(), a[] = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        int bit[] = createTree(a);
        while (true) 
        {
            System.out.println("Enter 1:GetSum and 2:GetSumRange and 3:updation and 4:exit ");
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter index");
                    int index = s.nextInt();
                    System.out.println(getSum(bit, index));
                    break;
                case 2:
                    int i = s.nextInt(), j = s.nextInt();
                    System.out.println(getSumRange(bit, i, j));
                    break;
                case 3:
                    int x = s.nextInt(),val = s.nextInt();
                    updatebinaryindex(bit, val-a[x], x+1);
                    a[x] = val;
                    for (int k = 0; k < a.length; k++) {
                        System.out.print(a[k] + " ");
                    }
                    System.out.println();
                    for (int k = 0; k < bit.length; k++) {
                        System.out.print(bit[k] + " ");
                    }
                case 4:
                    s.close();
                    System.exit(0);
            }
        }
    }
}
