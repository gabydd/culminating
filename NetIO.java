import java.net.InetAddress;
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
}
