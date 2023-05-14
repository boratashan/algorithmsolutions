import java.util.Arrays;
import java.util.HashMap;

/**
 * This problem was asked by Google.
 *
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first,
 * the Gs come second, and the Bs come last. You can only swap elements of the array.
 *
 * Do this in linear time and in-place.
 *
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */
public class SortRGBbySwapping {

    private static HashMap<Character, Integer> charMap = new HashMap<>();

    private static char[] inputArr = new char[]  {'G', 'B', 'R', 'R', 'B', 'R', 'G', 'R', 'B', 'R', 'G', 'R', 'B', 'R', 'G'};

    static {
        charMap.put('R', 0);
        charMap.put('G', 1);
        charMap.put('B', 2);
    }




    public static void main(String[] args) {
        System.out.println(String.format("Input array is : %s", Arrays.toString(inputArr)));
        sortArray(inputArr);
        System.out.println(String.format("Output array is : %s", Arrays.toString(inputArr)));
    }

    public static void swap(int i1, int i2) {
        char temp = inputArr[i2];
        inputArr[i2] = inputArr[i1];
        inputArr[i1] = temp;

    }
    public static void sortArray(char[] arr) {


        int i =0, reader=0;
        int k = inputArr.length - 1;
        boolean keepRun = true;
        int n = 0;
        while (keepRun) {
            n++;
            boolean incReader = true;
            if (charMap.get(inputArr[i]) > charMap.get(inputArr[reader])) {
                swap(i, reader);
                i++;
                reader++;
                incReader = false;
            }
            if (charMap.get(inputArr[reader]) > charMap.get(inputArr[k])) {
                swap(reader, k);
            }
            if (inputArr[k] == 'B' ) {
                k--;
            }
            if (incReader) reader++;
            keepRun = reader<=k;
        }
    }
}
