package app;

import server.ChatServer;

import java.io.IOException;

public class ServerApp {
    void main() throws IOException {
        new ChatServer().start();
    }
}
