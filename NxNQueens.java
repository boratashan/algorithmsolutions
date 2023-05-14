import java.util.ArrayDeque;

/********************************************************************************************************************

This problem was asked by Microsoft.

You have an N by N board. Write a function that, given N, returns the number of possible arrangements of the board
where N queens can be placed on the board without threatening each other,
i.e. no two queens share the same row, column, or diagonal.

 ********************************************************************************************************************/

public class NxNQueens {
    final int N = 4;
    int numberOfSolutions = 0;
    ArrayDeque<Entry> stack = new ArrayDeque<>();

    private class Entry {
        int row;
        int col;

        public Entry(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        new NxNQueens().solve();
    }

    public void solve() {
        for (int j = 0; j < N; j++) {
            placeQueen(0, j);
        }
        System.out.println(String.format("N is %d, number of solutions is %d", N, numberOfSolutions));
    }

    public void placeQueen(int row, int col) {
        stack.add(new Entry(row, col));
        if (stack.size() == N) {
            numberOfSolutions++;
            drawTable(stack);
        }
        row++;
        col = 0;
        while (row < N) {
            if (isSafe(row, col)) {
                placeQueen(row, col);
            }
            col++;
            if (col == N) {
                row++;
                col = 0;
            }
        }
        stack.removeLast();
    }

    public boolean isSafe(int row, int col) {
        for (Entry entry : stack) {
            if ((row == entry.row) || (col == entry.col)) {
                return false;
            }
            int r1 = entry.row, r2 = entry.row, c1 = entry.col, c2 = entry.col;
            while (r1 > 0 || r2 < N || c1 > 0 || c2 < N) {
                if (((row == r1) || (row == r2)) && (col == c1 || col == c2)) {
                    return false;
                }
                r1--;
                r2++;
                c1--;
                c2++;
            }
        }
        return true;
    }

    public void drawTable(ArrayDeque<Entry> stack) {
        System.out.println();
        for (Entry e : stack) {
            for (int i = 0; i < N; i++) {
                System.out.print(i == e.col ? " Q " : " - ");
            }
            System.out.println();
        }
    }
}
