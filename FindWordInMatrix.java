public class FindWordInMatrix {
    /*

    This problem was asked by Microsoft.

    Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

    For example, given the following matrix:

    [['F', 'A', 'C', 'I'],
     ['O', 'B', 'Q', 'P'],
     ['A', 'N', 'O', 'B'],
     ['M', 'A', 'S', 'S']]
    and the target word 'FOAM', you should return true, since it's the leftmost column. Similarly, given the target word 'MASS', you should return true, since it's the last row.


     */
    public static void main(String[] args) {

        char[][] table = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };
        String wordToTest = "FOAM";
        boolean result = find(table, wordToTest);
        System.out.println(String.format("Word %s is %s", wordToTest, Boolean.toString(result)));

        wordToTest = "MASS";
        result = find(table, wordToTest);
        System.out.println(String.format("Word %s is %s", wordToTest, Boolean.toString(result)));
    }


    public static boolean find(char[][] input, String word) {
        char[] words = word.toCharArray();
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[y].length; x++) {
                char c = input[y][x];
                for (int p = 0; p < words.length; p++) {
                    if (words[p] != c) {
                        break;
                    } else {
                        boolean found = true;
                        for (int tx = 1; tx < words.length; tx++) {
                            if ((x + tx) >= input[y].length) {found = false; break;}
                            if (input[y][x + tx] != words[tx]) found = false;
                            if (!found) break;
                        }
                        if (found) {
                            return true;
                        }
                        found = true;

                        for (int ty = 1; ty < words.length; ty++) {
                            if ((y + ty) >= input.length) {found = false; break;}
                            if (input[y+ty][x] != words[ty]) found = false;
                            if (!found) break;
                        }
                        if (found) {
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }
}
