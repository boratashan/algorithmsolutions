import java.util.Arrays;

/*
This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2
 */
public class MicrosoftRunningMedianOfArrayStream {

    public static void main(String[] args) {
        int arr[] = new int[] {
                2, 1, 5, 7, 2, 0, 5
        };
        printMedians(arr);
    }

    public static void printMedians(int[] arr) {
        System.out.println(String.format(" Input array is %s", Arrays.toString(arr)));
        System.out.println(String.format("%d. median %d", 1, arr[0]));
        for (int i = 1; i < arr.length; i++) {
            if (i+1 == arr.length)
                Arrays.sort(arr);
            else
                Arrays.sort(arr, 0, i+1);
           double median = (i%2==0 ? arr[i/2] :(double)(arr[i/2]+arr[(i/2)+1])/2);
            System.out.println(String.format("%d. median %.2f", i+1, median));
        }
    }
}
