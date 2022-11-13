import java.net.*;
import java.io.*;

class RPCClient {
    RPCClient() {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket();
            DatagramSocket ds1 = new DatagramSocket(1300);
            System.out.println("RPC Client");
            System.out.println("Enter methodname and parameters");
            while(true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        String str = br.readLine();
		        byte b[] = str.getBytes();
		        DatagramPacket dp = new DatagramPacket(b, b.length, ia, 1200);
		        ds.send(dp);
		        dp = new DatagramPacket(b, b.length);
		        ds1.receive(dp);
		        String s = new String(dp.getData(),0,dp.getLength());
		        System.out.println("\n Result = "+s+ "\n");
                ds.close();
                ds1.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
		new RPCClient();
	}
}