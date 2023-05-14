import java.util.ArrayList;
import java.util.Arrays;


/**
 * This problem was asked by Amazon.
 * Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or less.
 * You must break it up so that words don't break across lines. Each line has to have the maximum possible amount of words.
 * If there's no way to break the text up, then return null.
 * You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.
 * For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should
 * return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
 */
public class SplitTextByKLength {
    public static void main(String[] args) {

        String text = "the quick brown fox jumps over the lazy dog";
        int k = 10;
        System.out.printf("k = %d, input text = %s \n", k, text);
        String[] res = splitText(text, k);
        System.out.printf("output = %s \n", Arrays.toString(res));
    }


    public static String[] splitText(String text, int k) {
        char SPC = ' ';
        char lastChar = SPC;
        ArrayList<String> list = new ArrayList<>();
        int i = 0, s = 0;
        int we = 0;
        while (i < text.length()) {
            char current = text.charAt(i);
            if ((lastChar != SPC) && ((current == SPC) || (i == (text.length()-1)))) {
                if ((i - s) <= k)
                    we = i;
                else {
                    list.add(text.substring(s, we));
                    s = we + 1;
                    we = i;
                }
            }
            lastChar = current;
            i++;
        }
        if (i>s)
            list.add(text.substring(s, i));
        return list.toArray(new String[0]);
    }
}

