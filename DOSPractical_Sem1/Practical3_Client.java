import java.io.*;
import java.net.*;

public class Practical3_Client{
    public static void main(String args[]) throws Exception {
        InetAddress loclhost;
        loclhost = InetAddress.getLocalHost();
        while (true) {
            Client cntl = new Client(loclhost);
            cntl.sendPort(9001);
            cntl.sendData();
        }
    }
}

class Client {
    InetAddress lclhost;
    int senport;
    Client (InetAddress loclhost) {
        this.lclhost = loclhost;
    }
    void sendPort (int senport) {
        this.senport = senport;
    }
    void sendData() throws Exception{
        DatagramPacket dp;
        DatagramSocket ds;
        BufferedReader br;
        br = new BufferedReader (new InputStreamReader(System.in));
        System.out.println ("Enter The Data");
        String str = br.readLine();
        ds = new DatagramSocket (senport);
        dp = new DatagramPacket(str.getBytes(),str.length(),lclhost,senport-1000);
        ds.send(dp);
        ds.close();
    }
}