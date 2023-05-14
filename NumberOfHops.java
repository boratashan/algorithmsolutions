
import java.util.Arrays;

/**
 * This problem was asked by Pinterest.
 * Given an integer list where each number represents the number of hops you can make, d
 * etermine whether you can reach to the last index starting at index 0.
 * For example, [2, 0, 1, 0] returns True while [1, 1, 0, 1] returns False.
 */
public class NumberOfHops {

    public static int[][] source = {{2,0,1,0}, {1,1,0,1}};

    public static void main(String[] args) {
        for (int[] s : source) {
            System.out.printf("Source : %s \n", Arrays.toString(s));
            System.out.printf("Result : %b \n", isHopsToEnd(s));
        }
    }

    public static boolean isHopsToEnd(int[] array){
        int i = 0;
        while ((i + array[i]) > i) {
            i = i + array[i];
        }
        return i >= (array.length - 1);
    }
}
