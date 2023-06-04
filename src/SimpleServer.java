import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(1254)) {
			System.out.println("Listening on port 1254");
			while (true) {
				Socket connection = server.accept();
				try {
					System.out.println("Connection from " + connection.getInetAddress().toString());
					DataOutputStream os = new DataOutputStream(connection.getOutputStream());
					os.writeUTF("Hello");
					os.close();
				} catch (Exception e) {
					System.out.println("Error: " + e);
				}
			}

		} catch (Exception e) {
			System.out.println("Error:  " + e);
			return;
		}

	}
}
