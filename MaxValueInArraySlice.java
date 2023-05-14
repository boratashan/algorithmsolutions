import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

/*
This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. 
You can simply print them out as you compute them.
*/
public class MaxValueInArraySlice {

    static int[] source = new int[10];


    static {
        Random random = new Random();
        for (int i = 0; i < source.length; i++)
            source[i] = random.nextInt(10);
    }



    public static void main(String[] args) {
         
        System.out.println("Input array is :" + Arrays.toString(source));
        int slice = 3;
        int[] dequeu = new int[slice];
        System.out.println(String.format("Length of slice is %d" , dequeu.length));
        int dequePtr = 0;
        int firstPtr = 0;
        int max = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] >= source[max]) {
                max = i;
                dequePtr = 0;
                firstPtr = 0;
                dequeu[dequePtr] = i;
            } else {
                dequePtr = (++dequePtr) % slice;  
                dequeu[dequePtr] = i; 

                int lastPtr = (dequePtr-1) % slice;
                while (source[i] >= source[dequeu[lastPtr]]) {
                    dequeu[lastPtr] = i;
                    dequePtr = lastPtr;                     
                    lastPtr = (dequePtr-1) % slice;  
                }
            }
            if (i >= (slice - 1)) {
                System.out.println(String.format("Max val of slice is : %d", source[max]));
                if (((i+1) - slice) == max) {
                    firstPtr = (++firstPtr) % slice;
                    max = dequeu[firstPtr];
                } 
            }
        }
    }

}
