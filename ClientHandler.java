import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket s;

    public ClientHandler(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        PrintWriter out = null;
        BufferedReader in = null;

        try {

            // get ready for client's input and output
            out = new PrintWriter(s.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine;
        try {

            // gets username for each client
            out.println("Type your username: ");
            String username = in.readLine();
            out.println("Welcome " + username);

            // keeps track of each client and their input
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
                System.out.println(username + " said: " + inputLine);
            }

        } catch(Exception e) {
            System.out.println("Client disconnected.");
        }
    }
}
