/************************************************************************************************************************/
/* To run this program: Place it in the same folder that contains Matrix class with checkWinner() method in it and run	*/
/*															*/
/* May 25 2023														*/
/* This program generates 19,693 TicTacToe configuration boards and checks the correctness of the 		  	*/
/* method Matrix.checkWinner() written by students from the course slides of Culminating Activity (slide 12)		*/
/* Boards that contain configurations with 2 winners are skipped							*/
/* Program ends immediately when an error is found									*/
/*															*/
/* Nothing needs to be done to this code in order to run it. 								*/
/* All necessary calls are made from within here (see line labelled CALL TO STUDENT PROGRAM)				*/
/************************************************************************************************************************/

public class TestMatrix {
    public static int checkBoardNumber = 0;
    public static int checkBoardTested = 0;
    public static int twoWinnersOnRows = 0;
    public static int twoWinnersOnCols = 0;

    private static int checkWinner (int[] [] board)
    {
	int result = Globals.GAME_TIE;
	String boardStr = "";

	for (int row = 0; row < 3; row++)
	    for (int col = 0; col < 3; col++)
		boardStr = boardStr + board[row][col];

	if (boardStr.substring(0, 3).equals("111") ||
 	       	boardStr.substring(3, 6).equals("111") ||
		boardStr.substring(6, 9).equals("111") ||

		boardStr.charAt(0) == '1' && boardStr.charAt(3) == '1' && boardStr.charAt(6) == '1' ||
 	       	boardStr.charAt(1) == '1' && boardStr.charAt(4) == '1' && boardStr.charAt(7) == '1' ||
		boardStr.charAt(2) == '1' && boardStr.charAt(5) == '1' && boardStr.charAt(8) == '1' ||

		boardStr.charAt(0) == '1' && boardStr.charAt(4) == '1' && boardStr.charAt(8) == '1' ||
 	       	boardStr.charAt(2) == '1' && boardStr.charAt(4) == '1' && boardStr.charAt(6) == '1') {

	    result = Globals.PLAYER_ONE;
	}
	else if	(boardStr.substring(0, 3).equals("222") ||
 	       	boardStr.substring(3, 6).equals("222") ||
		boardStr.substring(6, 9).equals("222") ||

		boardStr.charAt(0) == '2' && boardStr.charAt(3) == '2' && boardStr.charAt(6) == '2' ||
 	       	boardStr.charAt(1) == '2' && boardStr.charAt(4) == '2' && boardStr.charAt(7) == '2' ||
		boardStr.charAt(2) == '2' && boardStr.charAt(5) == '2' && boardStr.charAt(8) == '2' ||

		boardStr.charAt(0) == '2' && boardStr.charAt(4) == '2' && boardStr.charAt(8) == '2' ||
 	       	boardStr.charAt(2) == '2' && boardStr.charAt(4) == '2' && boardStr.charAt(6) == '2') {

	    result = Globals.PLAYER_TWO;

	}
	else if (boardStr.indexOf("" + Globals.NO_PLAYER) != -1) {
	    result = Globals.GAME_STILL_ON;
	}

	else {
	    result = Globals.GAME_TIE;
	}

	return result;
    }

    public static boolean boardFilled(int[][] board) {
	boolean filled = true;
	for (int row = 0; row < board.length; row++) {
	    for (int col = 0; col < board[0].length; col++) {
		filled = filled && board[row][col] != -1;
	    }
	}
	return filled;
    }
    
    public static void generateBoard(String board) {
	int[][] matrix = new int[3][3];
	if (board.length() == 9) {
	    // System.out.println(board);
	    checkBoardNumber++;
	    
	    for (int row = 0; row < 3; row++) {
		for (int col = 0; col < 3; col++) {
		    matrix[row][col] = Integer.parseInt("" + board.charAt(3 * row + col));
		}
	    }

	    if (!(

		  (board.substring(0, 3).equals("111") || board.substring(3, 6).equals("111") || board.substring(6, 9).equals("111")) &&
		  (board.substring(0, 3).equals("222") || board.substring(3, 6).equals("222") || board.substring(6, 9).equals("222"))

                )) {
		
		String tmp = "";
	    	for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
	    			tmp = tmp + matrix[col][row];			
			}
	    	}

		if (!(

		  (tmp.substring(0, 3).equals("111") || tmp.substring(3, 6).equals("111") || tmp.substring(6, 9).equals("111")) &&
		  (tmp.substring(0, 3).equals("222") || tmp.substring(3, 6).equals("222") || tmp.substring(6, 9).equals("222"))

                )) {

		    checkBoardTested++;
	    	    if (checkWinner(matrix) != Matrix.checkWinner(matrix)) {
			/*********     CALL TO STUDENT PROGRAM ********/
			System.out.println("Tester checkWinner(): " + checkWinner(matrix) + " Student checkWinner(): " + Matrix.checkWinner(matrix));
			System.out.println("***error in board");
			System.out.println(board);
			printBoard(matrix);
		 	System.exit(0);
	    	   }
	    	   else if (checkBoardNumber % 50 == 0) {
			System.out.println("Testing board: " + checkBoardNumber);
	    	   }
		}
		else {
		    // System.out.println("************On columns two winners rejected");
		    // int k = Stdin.readInt();
		    twoWinnersOnCols++;
		}
	    }
	    else {
		// System.out.println("************On rows two winners rejected");
		// int k = Stdin.readInt();
		twoWinnersOnRows++;
	    }
	}
	else {
	    for (int player = 0; player < 3; player++) {
		generateBoard(board + player);
	    }
	}
    }
    
    public static void printBoard(int[][] board) {
	for (int row = 0; row < board.length; row++) {
	    for (int col = 0; col < board[0].length; col++) {
		System.out.print(board[row][col]);
	    }
	    System.out.println();
	}
    }


    public static void main(String[] args) {
	String board = "";    
	generateBoard("");
	
	System.out.println("=====================================");
	System.out.println("Games considered: " + checkBoardNumber);
	System.out.println("Games tested    : " + checkBoardTested);
	System.out.println("Two winners on rows rejected: " + twoWinnersOnRows);
	System.out.println("Two winners on cols rejected: " + twoWinnersOnCols);
	System.out.println("Tests passed : " + checkBoardNumber);
	System.out.println();

	if (checkBoardTested + twoWinnersOnRows + twoWinnersOnCols == (int) Math.pow(3, 9))
	    System.out.println("     #### All tests passed ####");
	else
	    System.out.println("***Some tests failed");
	System.out.println("=====================================");
    }
}
