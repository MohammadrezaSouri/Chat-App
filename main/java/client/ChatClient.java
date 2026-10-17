package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private final String serverAddress;
    private final int port;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ChatClient(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.port = port;
    }

    public void connect()throws IOException {
        socket = new Socket(serverAddress, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(new MessageListener(in)).start();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String message;
        while ((message = console.readLine()) != null) {
            out.println(message);
        }

    }
}
