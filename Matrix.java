public class Matrix {
    public static int checkWinner(int[][] board) {
	int ret = get(board, 5) != Globals.NO_PLAYER ? Globals.GAME_TIE : Globals.GAME_STILL_ON;
	int[][] positions = new int[][]{{1, 0, 2}, {4, 3, 5}, {8, 7, 6}, {3, 0, 6}, {7, 4, 1}, {2, 5, 8}, {0, 4, 8}, {6, 4, 2}};
	for (int i = 0; i < positions.length; i++) {
	    int a = get(board, positions[i][0]);
	    ret = ret == Globals.GAME_TIE && a != Globals.NO_PLAYER ? Globals.GAME_TIE : Globals.GAME_STILL_ON;
	    int b = get(board, positions[i][1]);
	    int c = get(board, positions[i][2]);
	    if (a != Globals.NO_PLAYER && a == b && a == c) {
		ret = a;
	    }
	}
	return ret;
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
