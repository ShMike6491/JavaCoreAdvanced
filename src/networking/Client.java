package networking;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    // задаю порт для подключения
    public static final int PORT = 8189;
    // время ожидания
    private final static int TIMEOUT = 3000;
    // название сети
    private final static String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        try (
                Socket s = new Socket()
        ) {
            // подключаюсь к серверу
            s.connect(new InetSocketAddress(HOST, PORT), TIMEOUT);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Thread input = new Thread(() -> {
                try {
                    while(true) {
                        out.writeUTF(br.readLine());
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

            input.setDaemon(true);
            input.start();

            while (true) {
                try {
                    String msg = in.readUTF();
                    System.out.println(msg);
                    if (msg.equals("/exit")) {
                        out.writeUTF("/exit");
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
