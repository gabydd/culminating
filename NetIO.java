import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetIO {
	public static void main(String[] args) {
		System.out.println(myUsername());
	}

	public static String myIP() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static int sendRequest(String message, String ip) {
		int errorCode = Globals.NET_SEND_ERROR;
		int attempts = 0;
		do {
			attempts++;
			try {
				Socket socket = new Socket(ip, Globals.PORT_NUMBER);
				socket.setSoTimeout(Globals.TIME_OUT);
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(message);
				DataInputStream in = new DataInputStream(socket.getInputStream());
				errorCode = Integer.parseInt(in.readUTF());
				socket.close();
			} catch (IOException e) {
				System.out.println("sendRequest attempt " + attempts);
			}
		} while (errorCode != Globals.NET_OK && attempts < Globals.SENDING_ATTEMPTS_LIMIT);
		return errorCode;
	}

	public static String receiveRequest() {
		String request = "";
		int errorCode = Globals.NET_RECEIVE_ERROR;
		try {
			ServerSocket server = new ServerSocket(Globals.PORT_NUMBER, Globals.QUEUE_SIZE);
			Socket socket = server.accept();
			DataInputStream in = new DataInputStream(socket.getInputStream());
			request = in.readUTF();
			Globals.clientIPAddress = socket.getInetAddress().getHostAddress();
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("" + Globals.NET_OK);
			socket.close();
			server.close();
			errorCode = Globals.NET_OK;
		} catch (IOException e) {
			System.out.println("error when receiving request");
			e.printStackTrace();
		}
		return request;
	}

	public static String myUsername() {
		try {
		return System.getProperty("user.name");
		} catch (Exception e) {
			System.out.println("Can't get username");
			return "";
		}
	}

}
