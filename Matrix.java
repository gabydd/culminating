public class Matrix {
    public static int checkWinner(int[][] board) {
        int[][] positions = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int i = 0; i < positions.length; i++) {
            int a = get(board, positions[i][0]);
            int b = get(board, positions[i][1]);
            int c = get(board, positions[i][2]);
            if (a != Globals.NO_PLAYER && a == b && a == c) {
                return a;
            }
        }
        return full(board) ? Globals.GAME_TIE : Globals.GAME_STILL_ON;
    }

    public static int get(int[][] board, int n) {
        return board[n / 3][n % 3];
    }

    public static boolean full(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (get(board, i) == Globals.NO_PLAYER) {
                return false;
            }
        }
        return true;
    }
}
