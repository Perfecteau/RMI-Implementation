package pi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PiCompute extends Remote {
	
	float compute() throws RemoteException;

}
