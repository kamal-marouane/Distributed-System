package client;

import java.rmi.Naming;
import server.PingPongInterface;

public class Client {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a message as a command-line argument.");
            return;
        }
        String message = args[0];

        try {
            PingPongInterface stub = (PingPongInterface) Naming.lookup("rmi://localhost/PingPong");
            String response = stub.ping(message);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
