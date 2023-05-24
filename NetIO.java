import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class NetIO {
    public static void main(String[] args) {
	System.out.println(myIP());
    }
    public static String myIP() {
	try {
	    return InetAddress.getLocalHost().getHostAddress();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
	return "";
    }

    public static in sendRequest(String message, String ip) {
        int errorCode = Globals.NET_SEND_ERROR;
        int attempts = 0;
        do {
            try {
                Socket socket = new Socket(ip, Globals.PORT_NUMBER);
                socket.setSoTimeout(Globals.TIME_OUT);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(message);
                Scanner in = new Scanner(socket.getOutputStream());
                errorCode = in.nextInt();
            } catch (IOException e) {
                System.out.println("Attempt " + attempts);
            }
        } while (errorCode != Globals.NET_OK && attempts < Globals.SENDING_ATTEMPTS_LIMIT);
        return errorCode;
    }

    public static String receiveRequest() {
        String request = "";
        int errorCode = Globals.NET_RECEIVE_ERROR;
        try {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }
    
}
