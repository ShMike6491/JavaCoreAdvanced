package hw6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    // задаю порт
    private final static int PORT = 8189;

    public static void main(String[] args) throws IOException {
        try(ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server has started running");

            while(true) {
                Socket socket = server.accept();
                new Thread(new MyServer(socket)).start();
            }
        }
    }
}

class MyServer implements Runnable {
    Socket socket;

    public MyServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(
//            Scanner in = new Scanner(socket.getInputStream());
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            ) {
            System.out.println("Client has connected to the network");
//            out.println("Hello");
            out.writeUTF("Hello");

            while (true) {
                out.writeUTF(sc.nextLine());
            }

//            while(in.hasNextLine()) {
//                String str = in.nextLine();
//                System.out.println(str);
//                if(str.equals("/exit")) {
//                    break;
//                }
//            }
//
//            while(true) {
//                String msg = sc.nextLine();
//                out.println(msg);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//    public static void main(String[] args) throws IOException {
//            // ServerSocket запускает сервер
//        try(ServerSocket serverSocket = new ServerSocket(PORT);
//            // Socket для того чтобы подключить клиента
//            Socket socket = serverSocket.accept();
//            Scanner in = new Scanner (socket.getInputStream());
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
//            //out.println("hello");
//            while(in.hasNextLine()) {
//                String str = in.nextLine();
//                out.println("Your message: " + str);
//                System.out.println(str);
//                if(str.equals("exit")) {
//                    break;
//                }
//            }
//        }
//    }