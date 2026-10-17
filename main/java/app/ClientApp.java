package app;

import client.ChatClient;

import java.io.IOException;

public class ClientApp {
    void main() throws IOException {
        new ChatClient("localhost", 8080).connect();
    }
}
