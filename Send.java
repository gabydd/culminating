import hsa.Stdin;
public class Send {
    public static void main(String[] args) {
	System.out.println(NetIO.myIP());
    do {
	System.out.print("Message: ");
	String message = Stdin.readLine();
	System.out.print("IP address: ");
	String ip = Stdin.readLine();
	NetIO.sendRequest(message, ip);
    } while (true);
    }    
}
