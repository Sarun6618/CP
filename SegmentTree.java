class SegmentTree {
    private int[] tree;
    private int[] nums;
    private int n;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        this.tree = new int[maxSize];
        buildSegmentTree(0, 0, n - 1);
    }

    private int buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = nums[left];
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftSum = buildSegmentTree(2 * treeIndex + 1, left, mid);
        int rightSum = buildSegmentTree(2 * treeIndex + 2, mid + 1, right);
        tree[treeIndex] = leftSum + rightSum;
        // System.out.println(tree[treeIndex]);
        return tree[treeIndex];
    }

    public void update(int index, int newValue) {
        int diff = newValue - nums[index];
        nums[index] = newValue;
        updateSegmentTree(0, 0, n - 1, index, diff);
    }

    private void updateSegmentTree(int treeIndex, int left, int right, int index, int diff) {
        if (index < left || index > right) {
            return;
        }

        tree[treeIndex] += diff;
        if (left != right) {
            int mid = left + (right - left) / 2;
            updateSegmentTree(2 * treeIndex + 1, left, mid, index, diff);
            updateSegmentTree(2 * treeIndex + 2, mid + 1, right, index, diff);
        }
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(0, 0, n - 1, left, right);
    }

    private int querySegmentTree(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) {
            return 0;
        }

        if (queryLeft <= left && queryRight >= right) {
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftSum = querySegmentTree(2 * treeIndex + 1, left, mid, queryLeft, queryRight);
        int rightSum = querySegmentTree(2 * treeIndex + 2, mid + 1, right, queryLeft, queryRight);
        return leftSum + rightSum;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};

        SegmentTree segmentTree = new SegmentTree(nums);
        System.out.println("Sum of elements in range [1, 3]: " + segmentTree.sumRange(1, 3));

        segmentTree.update(2, 6);

        System.out.println("Updated sum of elements in range [1, 3]: " + segmentTree.sumRange(1, 3));
    }
}

