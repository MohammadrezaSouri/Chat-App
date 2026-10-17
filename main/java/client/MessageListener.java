package client;

import java.io.BufferedReader;
import java.io.IOException;

public class MessageListener implements Runnable {
    private BufferedReader in;

    public MessageListener(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                IO.println(message);
            }
        } catch (IOException e) {
            IO.println("Disconnected from server.");
        }
    }
}
