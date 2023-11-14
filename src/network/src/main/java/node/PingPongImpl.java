package node;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class PingPongImpl extends UnicastRemoteObject implements PingPongInterface {
    protected PingPongImpl() throws RemoteException {
        super();
    }

    @Override
    public String ping(String message) throws RemoteException {
        return "Node received: " + message;
    }

    @Override
    public void executeCommand(String command) throws RemoteException {
        try {
            Process process = Runtime.getRuntime().exec("cmd /c " + command);
            process.waitFor();
            System.out.println("Command executed: " + command);
        } catch(IOException | InterruptedException e) {
            System.out.println("Error executing command.\n" + e);
            throw new RemoteException("Error executing command", e);
        }
    }
}
