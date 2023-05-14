package progquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 
This problem was asked by Apple.

A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:

if n is even, the next number in the sequence is n / 2
if n is odd, the next number in the sequence is 3n + 1
It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.

Bonus: What input n <= 1000000 gives the longest sequence?

 */
public class CollatzSequence {

    private static int MAX = 1000000;

    private static Map<Integer, Integer> ltable = new HashMap();

    public static void main(String[] args) {
        find();

    }



    public static void find () {
        int maxSeq = 0;
        for (int i = 2; i <= MAX ;  i++) {
            int step = findCseq(i);
            if (step > maxSeq)
                maxSeq = step;
        }
        System.out.println (String.format("Max Seq is  %d", maxSeq));
    }

    public static int findCseq(int start) {
        int n = start;
        int step = 1;
        while (n > 1) {
           if (n % 2 == 0) 
               n = n / 2;
           else
                n = 3*n + 1;
            step++;                
            if (ltable.containsKey(n)) {
                step += ltable.get(n);
                break;
            }
            
        }
        ltable.put(start, step);
        return step;    
    }


}
