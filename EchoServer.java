import java.io.*;
import java.net.ServerSocket;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        // server socket instantiating
        ServerSocket ss = new ServerSocket(1111);
        System.out.println("Server waiting for client...");

        // assign new client into new thread
        while(true) {
            ClientHandler c = new ClientHandler(ss.accept());
            Thread thread = new Thread(c);
            thread.start();
        }
    }

}