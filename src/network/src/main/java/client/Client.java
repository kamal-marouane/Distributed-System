package client;

import java.rmi.Naming;
import server.PingPongInterface;

public class Client {
    public static void main(String[] args) {
        try {
            PingPongInterface stub = (PingPongInterface) Naming.lookup("rmi://localhost/PingPong");
            String response = stub.ping("Hello, Server!");
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
