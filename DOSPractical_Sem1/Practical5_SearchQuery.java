// Java program to implement the Search interface
import java.rmi.*;
import java.rmi.server.*;

public class Practical5_SearchQuery extends UnicastRemoteObject implements Practical5_Search {
	// Default constructor to throw RemoteException
	// from its parent constructor
	Practical5_SearchQuery() throws RemoteException {
		super();
	}
	// Implementation of the query interface
	public String query(String search) throws RemoteException {
		String result;
		if (search.equals("Reflection in Python"))
			result = "Found";
		else
			result = "Not Found";        
		return result;
	}
}
