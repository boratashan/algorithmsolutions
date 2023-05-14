import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Stack;

public class MicrosoftLongestSequence {

/*
This problem was asked by Microsoft.

Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
 */

    public static void main(String[] args) {

        int[] input = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        solve(input);
        System.out.println("Max Sequence : " + maxSeqLength);
        System.out.println(Arrays.toString(result));


    }
    private static Stack<Integer> table = new Stack<>();
    private static int maxSeqLength  = 0;
    private static Integer[] result = {0};

    public static void solve(int[] input) {
        find(input, 0, input.length -1);
    }

    public static void find(int[] input, int start,  int end) {
        for (int i = start; i <= end; i++) {
            if (input[i] > (table.empty() ? -1 : table.peek())) {
                table.push(input[i]);
                if (table.size() >= maxSeqLength) {
                    maxSeqLength = table.size();
                    result = table.toArray(result);
          //          System.out.println(Arrays.toString(result));
                }
                find(input, i+1, end);
                table.pop();
            }
        }
    }
}
