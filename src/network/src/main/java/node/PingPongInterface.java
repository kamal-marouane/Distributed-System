package node;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PingPongInterface extends Remote {
    String ping(String message) throws RemoteException;
}
