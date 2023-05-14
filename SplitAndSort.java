import java.util.*;
import java.util.function.Consumer;

public class SplitAndSort {

    public static void main(String[] args) {
        String input = "     Hello world c a n be    126 times but 324 times would be better .       ";

       TextParser t = TextParser.parse(input);
        for (Iterator<String> it = t.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.print(s+" ");
        }
        System.out.println("");
        /*for (String s : TextParser.parse(input)) {
            System.out.print(s+" ");
        }
        System.out.println("");*/
        t.forEach(s -> System.out.print(s+" "));System.out.println("");
        t.forEach(s -> System.out.print(s+" "));System.out.println("");

        while (t.spliterator().tryAdvance(s -> System.out.println(s))) {

        }
//        run(returnTestData());
//        run(input);

    }

    public static String returnTestData() {
       List<String> out =  List.of("Hello", " ", "world", " ", " . ");
       StringBuilder b = new StringBuilder();
       out.stream().forEach(s -> b.append(s));
       return b.toString();
    }

    public static void run(String input) {
        String[] out = sort(split(input));

        System.out.println(Arrays.toString(out));
        Arrays.sort(out, Comparator.reverseOrder());
        System.out.println(Arrays.toString(out));
    }

    public static String[] sort(String[] input) {
        List<String> l = Arrays.asList(input);
        Collections.sort(l, Collections.reverseOrder());
        l.sort(Comparator.naturalOrder());
        return l.toArray(input);

    }

    public static String[] split(String input) {
        int i = 0;
        String[] temp = new String[0];
        ArrayList<String> out = new ArrayList<>();
        int s = 0, f = 0;
        char p = ' ';
        StringBuilder buf = new StringBuilder();
        while  (i <= input.length()) {
            if (i == input.length()) {
                if (buf.length()> 0) {
                    out.add(buf.toString());
                }
                break;
            }
            char c = input.charAt(i);
            switch (c) {
                case ' ' :
                    if (p != ' ') {
                        out.add(buf.toString());
                        buf = new StringBuilder();
                    }
                    i++;
                    break;
                default:
                    buf.append(c);
                    i++;
                    break;
            }
            p = c;
        }

        return out.toArray(temp);

    }

    public static class TextParser implements Iterable<String> {
        private String[] parsed;



        private TextParser() {}

        public static TextParser parse(String input) {
            return new TextParser().internalParse(input);
        }

        private TextParser internalParse(String input) {
            this.parsed = this.split(input);
            return this;
        }

        private String[] split(String input) {
            int i = 0;
            String[] temp = new String[0];
            ArrayList<String> out = new ArrayList<>();
            int s = 0, f = 0;
            char p = ' ';
            StringBuilder buf = new StringBuilder();
            while  (i <= input.length()) {
                if (i == input.length()) {
                    if (buf.length()> 0) {
                        out.add(buf.toString());
                    }
                    break;
                }
                char c = input.charAt(i);
                switch (c) {
                    case ' ' :
                        if (p != ' ') {
                            out.add(buf.toString());
                            buf = new StringBuilder();
                        }
                        i++;
                        break;
                    default:
                        buf.append(c);
                        i++;
                        break;
                }
                p = c;
            }
            return out.toArray(temp);
        }



        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                int idx = 0;
                @Override
                public boolean hasNext() {
                    return idx < parsed.length;
                }

                @Override
                public String next() {
                    return parsed[idx++];
                }
            };
        }
    }
}
