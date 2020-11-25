package hw6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    // задаю порт для подключения
    private final static int PORT = 8189;
    // время ожидания
    private final static int TIMEOUT = 3000;
    // название сети
    private final static String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        // создаю сокет
        try(Socket socket = new Socket()) {
            // подключаюсь к серверу
            socket.connect(new InetSocketAddress(HOST, PORT), TIMEOUT);

            Scanner sc = new Scanner(System.in);
            // инициализация для потоков
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

//            new Thread (() -> {
//                while (true) {
//                    String msg = sc.nextLine();
//                    out.println(msg);
//                    if (msg.equals("/exit")) {
//                        break;
//                    }
//                }
//            }).start();
        }
    }
}
