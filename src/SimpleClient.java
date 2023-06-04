import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	public static void main(String[] args) {
		try (Socket client = new Socket("0.0.0.0", 1254)) {
			System.out.println("Connected");

			DataInputStream is = new DataInputStream(client.getInputStream());
			String line = is.readUTF();
			System.out.println(line);

			is.close();
			client.close();

		} catch (UnknownHostException e) {
			System.out.println("Error:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());

		}
	}
}
