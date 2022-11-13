import java.io.*;
import java.net.*;

class FactorialServer {
    public static void main(String[] args) {
        System.out.println("TCP Factorial Server");
        try {
            ServerSocket ss = new ServerSocket(4000);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            int num = dis.readInt();
            int fact = 1;
            for(int i=1; i<=num; i++) {
                fact = fact * i;
            }
            dos.writeInt(fact);
            s.close();
            ss.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}