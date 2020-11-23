package homework6;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    // задаю порт для подключения
    private final static int PORT = 8189;
    // время ожидания
    private final static int TIMEOUT = 3000;
    // название сети
    private final static String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        try(Socket s = new Socket()) {
            // подключаюсь к серверу
            s.connect(new InetSocketAddress(HOST, PORT), TIMEOUT);
            DataInputStream in=new DataInputStream(s.getInputStream());
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String str="",str2="";
            while(!str.equals("stop")){
                str=br.readLine();
                out.writeUTF(str);
                out.flush();
                str2=in.readUTF();
                System.out.println("Server says: "+str2);
            }
        }
    }
}
