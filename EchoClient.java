import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) throws IOException {

        // connect client with the server
        Socket client = new Socket(InetAddress.getLocalHost(), 1111);

        System.out.println("Welcome to EchoChat.");
        System.out.println("Type in any message you want. Type in 'Okay Thank U Bye' to exit.");

        // get ready for input and output
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        // this is for input from server side
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // this is to get input from keyboard
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        // print out messages from server until the client close connection
        String userInput;
        System.out.println(in.readLine());
        while (!(userInput = stdIn.readLine()).equals("Okay Thank U Bye")) {
            out.println(userInput);
            System.out.println("EchoServer: " + in.readLine());
        }

    }

}

