package hw6;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class NewClient {
    // задаю порт для подключения
    private final static int PORT = 8189;
    // время ожидания
    private final static int TIMEOUT = 3000;
    // название сети
    private final static String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        // создаю сокет
        try (Socket socket = new Socket()) {
            // подключаюсь к серверу
            socket.connect(new InetSocketAddress(HOST, PORT), TIMEOUT);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String str = null;
                        str = in.readUTF();
                        System.out.println(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
