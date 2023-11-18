package master;



import node.PingPongInterface;

import java.rmi.Naming;
public class Master {

    private static void executeACommand(){
        try {
            PingPongInterface exec = (PingPongInterface) Naming.lookup("rmi://localhost:3000/PingPongObject");
            exec.executeCommand("echo Testing It > C:\\Users\\Kamal\\Desktop\\anajit.txt");
            System.out.println("The File has been created.");
        } catch (Exception e) {
            System.out.println("Master exception in File Creation : " + e);
        }
    }
    private static void getMessage(String message) {
        try {
            PingPongInterface stub = (PingPongInterface) Naming.lookup("rmi://localhost:3000/PingPongObject");
            String response = stub.ping(message);
            System.out.println("Response => " + response);
        } catch (Exception e) {
            System.out.println("Master exception In Message Transmission : " + e);
        }
    }

    public static void main(String[] args) {
        // this is just for now (because we do not know yet the number of requests authorized per node
        executeACommand();
        if (args.length > 0) {
            getMessage(args[0]);
        } else {
            System.out.println("Please provide a message as a command-line argument.");
        }
    }
}
