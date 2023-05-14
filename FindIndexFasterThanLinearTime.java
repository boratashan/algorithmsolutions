import java.util.Arrays;

/**
 * This problem was asked by Amazon.
 * An sorted array of integers was rotated an unknown number of times.
 * Given such an array, find the index of the element in the array in faster than linear time.
 * If the element doesn't exist in the array, return null.
 * <p>
 * For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
 * You can assume all the integers in the array are unique.
 */
public class FindIndexFasterThanLinearTime {

    private static int[] source = new int[]{13, 18, 25, 2, 8, 10};
    private static int value = 2;
    private static int numberOfSteps = 1;

    public static void main(String[] args) {
        new FindIndexFasterThanLinearTime().solve();
    }

    private void solve() {
        System.out.printf("Input array is %s,  search %d %n", Arrays.toString(source), value);
        int index = find(source, value, 0, source.length - 1, (source.length - 1) / 2);
        System.out.printf("Index of %d is %d, result [%s] %n", value, index, index >= 0 ? "FOUND" : "NOT FOUND");
        System.out.printf("Length of the array is %d,  number of steps to find the element is %d %n", source.length, numberOfSteps);
    }

    private int find(int[] arr, int val, int beg, int end, int pos) {
        int res = -1;
        if (arr[pos] == val)
            return pos;
        else {
            if (beg == end) {
                return -1;
            }
            if (val < source[end] && val < source[beg]) {
                res = find(arr, val, pos + 1, end, (pos + 1 + end) / 2);
            } else {
                res = find(arr, val, beg, pos, (beg + (pos - 1)) / 2);
            }
        }
        numberOfSteps++;
        return res;
    }
}
