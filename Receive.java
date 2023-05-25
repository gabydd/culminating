public class Receive {
    public static void main(String[] args) {
	System.out.println(NetIO.myIP());
	do {
	    String message = NetIO.receiveRequest();
	    System.out.println(message);
	} while (true);
    }
}
