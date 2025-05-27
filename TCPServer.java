import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Welcome to the server!");
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Client: " + line);
            out.println("Echo: " + line);
        }
    }
}