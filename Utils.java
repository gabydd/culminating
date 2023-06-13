import javax.swing.JOptionPane;

public class Utils {
	public static void initialNetworkConnection() {
		String[] serverNames = {
				Globals.SERVER1_NAME,
				Globals.SERVER2_NAME,
				Globals.SERVER3_NAME,
				Globals.SERVER4_NAME,
		};
		String[] serverAddresses = {
				Globals.SERVER1_ADDRESS,
				Globals.SERVER2_ADDRESS,
				Globals.SERVER3_ADDRESS,
				Globals.SERVER4_ADDRESS,
		};
		String serverName = (String) JOptionPane.showInputDialog(null, "Choose server", "The TicTacToe Connection",
				JOptionPane.INFORMATION_MESSAGE, null, serverNames, Globals.SERVER1_NAME);

		for (int i = 0; i < serverNames.length; i++) {
			if (serverNames[i].equals(serverName)) {
				Globals.serverIPAddress = serverAddresses[i];
			}
		}
		if (serverName != null) {
			int errorCode = clientRequest(Globals.REQUEST_TO_PLAY_GAME, '0', '0', "");
			if (errorCode != Globals.NET_OK) {
				JOptionPane.showMessageDialog(null, "Server doesn't like you", "TicTacToe Connection",
						JOptionPane.ERROR_MESSAGE);
				Globals.serverIPAddress = null;
			}
		}
	}

	public static int clientRequest(char command, char row, char col, String message) {
		return NetIO.sendRequest("" + command + col + row + leftPad(Globals.user, 15) + leftPad(NetIO.myIP(), 15) + (message.length() > 0 ? message : "null message"), Globals.serverIPAddress);
	}

	public static String leftPad(String s, int len) {
		while (s.length() < len) {
			s = "0" + s;
		}
		return s;
	}
	
	public static void updateStatusLine(String message) {
	    Globals.status.setText("Game status: " + message);
	}

	public static void main(String[] args) {
		System.out.println(leftPad(Globals.user, 15));
	}
}
