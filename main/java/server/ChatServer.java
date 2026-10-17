package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private final static int PORT = 8080;
    private final List<ClientHandler> clients = new ArrayList<>();

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        IO.println("Server started in port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            ClientHandler handler = new ClientHandler(clientSocket, this);
            clients.add(handler);
            new Thread(handler).start();
        }
    }

    public void broadcast(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }
    }
    public void removeClient(ClientHandler handler){
        clients.remove(handler);
    }
}
