package net.finn.farmmod.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NetworkHandler {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void sendData(String data) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             OutputStream outputStream = socket.getOutputStream()) {
            outputStream.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
