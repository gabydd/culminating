import javax.swing.JLabel;

public class Globals {
    public static final int NET_OK = 0;
    public static final int NET_SEND_ERROR = -1;
    public static final int NET_RECEIVE_ERROR = -2;
    public static final int NET_REQUEST_ERROR = -3;
    public static final int NET_RECEIVE_REQUEST_ERROR = -3;
    public static final int NET_TIME_OUT_ERROR = -3;

    public static final int SENDING_ATTEMPTS_LIMIT = 5;
    public static final int PORT_NUMBER = 5000;
    public static final int TIME_OUT = 1000;
    public static final int QUEUE_SIZE = 100;
    public static String clientIPAddress = "";
    public static String serverIPAddress = null;
    public static final int GAME_STILL_ON = -1;
    public static final int NO_PLAYER = 0;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int GAME_TIE = 0;

    public static final int FRAME_X = 250;
    public static final int FRAME_Y = 100;
    public static final int ROW_WIDTH = 200;
    public static final int COL_WIDTH = 200;
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final int OFFSET = 15;

    public static GridPanel[][] grid = new GridPanel[3][3];
    public static JLabel status = new JLabel("TicTacToe message: ");

    public static final String SERVER1_NAME = "Gaby's Garage";
    public static final String SERVER2_NAME = "Daniel's Dungeon";
    public static final String SERVER3_NAME = "Prasun and Suns";
    public static final String SERVER4_NAME = "Steven's Spa";

    public static final String SERVER1_ADDRESS = "10.207.98.44";
    public static final String SERVER2_ADDRESS = "10.100.2.102";
    public static final String SERVER3_ADDRESS = "10.100.2.103";
    public static final String SERVER4_ADDRESS = "10.100.2.104";

    public static String user = NetIO.myUsername(); // 15 chars
    public static final char REQUEST_UNKNOWN = 255;
    public static final char REQUEST_TO_PLAY_GAME = 245;
    public static final char REQUEST_TO_PROCESS_PLAY = 244;
    public static final char REQUEST_TO_TERMINATE_GAME = 243;
    
}
