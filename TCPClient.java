import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = userIn.readLine()) != null) {
            out.println(line);
            System.out.println("Server: " + in.readLine());
        }
    }
}