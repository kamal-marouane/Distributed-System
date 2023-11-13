package master;

import java.rmi.Naming;
import node.PingPongInterface;

public class Master {
    public static void main(String[] args) {
        try {
            PingPongInterface stub = (PingPongInterface) Naming.lookup("rmi://localhost/Node");
            String response = stub.ping("Hello, Master!");
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println("Master exception: " + e);
        }
    }
}
