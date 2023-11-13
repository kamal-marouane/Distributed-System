package master;

import java.rmi.Naming;
import node.PingPongInterface;

public class Master {
    public static void main(String[] args) {
        try {
            PingPongInterface stub = (PingPongInterface) Naming.lookup("rmi://localhost/PingPong");
            String response = stub.ping("Hello, Node!");
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
