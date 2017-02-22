package pi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Server implements PiCompute {
	
	public Server() {}
	
	public float compute(){
		return (float) 3.14;
	}
	
	public static void main(String args[]){
		try{
			Server obj = new Server();
			PiCompute stub = (PiCompute)UnicastRemoteObject.exportObject(obj, 0);
			
			//Bind the remote object stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("ComputePi", stub);
			
			System.err.println("Server ready");
		} catch (Exception e){
			System.err.println("Server exception:" + e.toString());
			e.printStackTrace();
		}
	}

}
