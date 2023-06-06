import javax.swing.JOptionPane;

public class Utils {
    public static String initialNetworkConnection() {
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
        return Globals.serverIPAddress;
    }

    public static void clientRequest(char command, char row, char col) {
        NetIO.sendRequest(command + col + row + Globals.user, Globals.serverIPAddress);
    }
}
