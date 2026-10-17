package server;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ChatServer chatServer;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        this.socket = socket;
        this.chatServer = chatServer;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your name");
            clientName = in.readLine();

            chatServer.broadcast(clientName + " joined the chat!", this);

            String message;
            while ((message = in.readLine()) != null){
                chatServer.broadcast(clientName + ": " + message, this);
            }
        }catch (IOException e){
            IO.println(clientName + "disconnected");
        }
        finally {
            chatServer.removeClient(this);
            try {
                socket.close();
            }catch (IOException e){
                IO.println(clientName + "disconnected");
            }
        }
    }
    public void sendMessage(String message) {
        out.println(message);
    }
}
