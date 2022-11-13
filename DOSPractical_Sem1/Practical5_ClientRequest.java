// Java program for client application
import java.rmi.*;

public class Practical5_ClientRequest {
	public static void main(String args[]) {
		String answer,value="Reflection in Java";
		try {
			// lookup method to find reference of remote object
			Practical5_Search access = (Practical5_Search)Naming.lookup("rmi://localhost:1900"+ "/geeksforgeeks");
			answer = access.query(value);
			System.out.println("Article on " + value + " " + answer+" at GeeksforGeeks");
		} catch(Exception ae) {
			System.out.println(ae);
		}
	}
}
