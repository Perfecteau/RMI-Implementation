package pi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	
	public static void main(String[] args){
		
		String host = (args.length < 1) ? null : args[0];
		
		Registry registry;
		try{
			registry = LocateRegistry.getRegistry();
			PiCompute stub;
			try{
				System.currentTimeMillis();
				stub = (PiCompute)registry.lookup("Hello");
				float response = stub.compute();
				System.out.println("response:" + response);
			} catch (NotBoundException e){
				System.err.println("Client exception:" + e.toString());
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			System.err.println("Server exception:" + e.toString());
			e.printStackTrace();
		}
	}

}
