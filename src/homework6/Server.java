package homework6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8189;

    public static void main(String[] args) throws IOException {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket s = serverSocket.accept();
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("Server has started running");
            String str="",str2="";
            while(!str.equals("stop")){
                str=in.readUTF();
                System.out.println("client says: "+str);
                str2=br.readLine();
                out.writeUTF(str2);
                out.flush();
            }
        }
    }
}
