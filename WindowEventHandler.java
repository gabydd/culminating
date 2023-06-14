import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEventHandler extends WindowAdapter {
    public void windowClosing(WindowEvent event) {
	if (!Globals.gameOver) {
	    int errorCode = Utils.clientRequest(Globals.REQUEST_TO_DISCONNECT, 0, 0, "");
	    System.out.println("Client Disconnecting...");
	    Utils.delay(3000);
	}
	System.exit(0);
    }
}
