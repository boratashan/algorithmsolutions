
/**
 * This problem was asked by Google.
 * Given two strings A and B, return whether or not A can be shifted some number of times to get B.
 * For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.
 */
public class TwoStringsAndSwapPossible {


    public static void main(String[] args) {

        boolean result = isSwapPossible("abc", "acb");
        System.out.printf("Result is %b \n", result);
    }


    public static boolean isSwapPossible(String first, String second) {
        if (first.length() != second.length())
            return false;
        int idxRef = -1;
        for (int i = 0; i < second.length(); i++) {
            if (first.charAt(0) == second.charAt(i)) {
                idxRef = i;
                break;
            }
        }
        if (idxRef < 0) {
            return false;
        }
        int ifp = 1;
        int iptr = (idxRef + 1) % second.length();
        while (iptr != idxRef) {
            if (first.charAt(ifp) != second.charAt(iptr)) {
                return false;
            }
            ifp++;
            iptr = (iptr + 1) % second.length();
        }
        return true;
    }
}
