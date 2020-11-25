package networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // задаю порт для подключения
    public static final int PORT = 8189;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            // создание сервера
            System.out.println("Server has started running");

            while (true) {
                // прикрепление клиента
                Socket client = server.accept();
                new Thread(new MyServer(client)).start();
            }
        }
    }
}

class MyServer implements Runnable {
    Socket client;

    public MyServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client has connected");
            Thread input = new Thread(() -> {
                try {
                    while (true) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}