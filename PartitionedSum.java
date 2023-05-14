import java.util.Arrays;

/**
 * This problem was asked by Facebook.
 * Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10}
 * and {20, 35}, which both add up to 55.
 * Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets
 * that add up to the same sum.
 */
public class PartitionedSum {

    private static int[] source = new int[]  {15, 5, 20, 10, 35, 15, 10};

    public static void main(String[] args) {
        PartitionedSum app = new PartitionedSum();
        System.out.printf("Source is %s %n", Arrays.toString(source));
        int sum = app.getSum(source);
        System.out.printf("Total is %d, search for %d %n", sum, sum / 2);
        if (sum % 2 != 0)
            System.out.printf("Total is odd number, does not have partition %n");
        else {
            boolean isPartitioned = false;
            for (int i = 0; i < source.length - 1; i++)
                if (app.test(source, sum / 2, source[i], i+1)) {
                    isPartitioned = true;
                    break;
                }
            System.out.printf("Partitioned [%s] %n", isPartitioned);
        }
    }

    public  int getSum(int[] arr){
        int res = 0;
        for(int i : arr)
            res += i;
        return res;
    }

    public boolean test(int[] arr, int sum, int val,  int pos) {
        if (val == sum)
            return  true;
        for (int i = pos; i < arr.length; i++) {
            if (val + arr[i] == sum) {
                return true;
            }
            else {
                if (test(arr, sum, val + arr[i], i + 1))
                    return true;
            }
        }
        return false;
    }
}
