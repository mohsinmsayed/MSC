import java.rmi.*;

public interface Practical5_Search extends Remote {
	// Declaring the method prototype
	public String query(String search) throws RemoteException;
}