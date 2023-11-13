package node;

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
}
