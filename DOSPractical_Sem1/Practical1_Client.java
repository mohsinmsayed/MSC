import java.io.*;
import java.net.*;

class FactorialClient {
	public static void main(String[] args) {
        System.out.println("TCP Factorial Client");
	    String host = "localhost";
	    int port = 4000;
	    try {
            System.out.println("Enter the number whose factorial is to be found");
			DataInputStream in = new DataInputStream(System.in);
			int num = Integer.parseInt(in.readLine());
			Socket s = new Socket(host,port);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new
			DataOutputStream(s.getOutputStream());
			dos.writeInt (num);
			int i = dis.readInt();
			System.out.println("Factorial of the number is :" +i);
			s.close();
		} catch(Exception e) {
            e.printStackTrace();
        }
	}
}