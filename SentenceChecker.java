/*
Daily Coding Problem: Problem #837 [Medium]

This problem was asked by Nest.

Create a basic sentence checker that takes in a stream of characters and determines whether they form valid sentences. If a sentence is valid, the program should print it out.

We can consider a sentence valid if it conforms to the following rules:

The sentence must start with a capital letter, followed by a lowercase letter or a space.
All other characters must be lowercase letters, separators (,,;,:) or terminal marks (.,?,!,‽).
There must be a single space between each word.
The sentence must end with a terminal mark immediately following a word.
 */


public class SentenceChecker {

    public static void main(String[] args) {

        String input = "xyz, Kitty what is, happening there? Meow  meow, is allowed ok!";
        check(input);
    }

    public static void check(String input) {
        int spos = 0;
        int epos = 0;
        int bek = 0;
        final short  upper = 1;
        final short word  = 2;
        final short space = 4;
        final short seperator = 8;
        final short terminator = 16;

        bek = upper;

        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (Character.isUpperCase(current)) { //Upper or Sentence Start
                if ((bek & upper) == upper) {
                    epos = 0;
                    spos = i;
                    bek = word | space | seperator;

                }
            }
            else if (Character.isSpaceChar(current)) { //Space
                if ((bek & space) == space) {
                    bek = word | space | seperator;

                }
            }
            else if (Character.isLowerCase(current)) { //Word
                if ((bek & word) == word) {
                    bek = word | space | seperator | terminator;

                }
            }
            else if (current == ',') { //Seperator
                if ((bek & seperator) == seperator) {
                    bek = word | space ;

                }
            }
            else if (current == '!' || current == '?' || current == '.') { //Terminator
                if ((bek & terminator) == terminator) {
                    bek = upper ;
                    epos = i;

                }
            }
            if ((spos >= 0) && (epos > spos)) {
                System.out.println(input.substring(spos, epos+1));
                spos = 0;
                epos = 0;
            }
        }
    }


}
