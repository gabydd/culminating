import javax.swing.JLabel;

public class Globals {
    public static final int NET_OK = 0;
    public static final int NET_SEND_ERROR = -1;
    public static final int NET_RECEIVE_ERROR = -2;
    public static final int NET_REQUEST_ERROR = -3;
    public static final int NET_RECEIVE_REQUEST_ERROR = -3;
    public static final int NET_TIME_OUT_ERROR = -3;

    public static final int SENDING_ATTEMPTS_LIMIT = 10;
    public static final int PORT_NUMBER = 5000;
    public static final int TIME_OUT = 10 * 1000;
    public static final int QUEUE_SIZE = 100;
    public static String clientIPAddress = "";
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

    public static GridPanel[][] grid = new GridPanel[3][3];
    public static JLabel status = new JLabel("Game status: ");
}
