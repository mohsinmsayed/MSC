import java.io.*;
import java.net.*;
import java.sql.*;

class ClntServer {
    InetAddress lclhost;
    int recport;
    Timestamp obtmp;

    ClntServer(InetAddress lclhost) {
        this.lclhost = lclhost;
    }
    void recPort(int recport) {
        this.recport = recport;
    }
    void setTimeStamp(Timestamp obtmp) {
        this.obtmp = obtmp;
    }
    void recData() throws Exception {
        String msgstr="";
        DatagramSocket ds;
        DatagramPacket dp;
        //BufferedReader br;
        byte buf[]= new byte[256];
        ds = new DatagramSocket(recport);
        dp = new DatagramPacket(buf,buf.length);
        ds.receive(dp);
        ds.close();
        msgstr = new String(dp.getData(),0,dp.getLength());
        System.out.println(msgstr);
        Timestamp clientmp = new Timestamp(System.currentTimeMillis());
        System.out.println(this.obtmp);
        if(clientmp.before(this.obtmp)!=false) {
            System.out.println("The Message is accepted");
        }
        else {
            System.out.println("The Message is rejected");
        }
    }
}

public class Practical3_Server{
    public static void main(String args[]) throws Exception {
        InetAddress localhost;        
        localhost = InetAddress.getLocalHost();
        long maxtime,skewtime,datatime;

        String maxtimestr, skewtimestr;
        ClntServer ser = new ClntServer(localhost);
        System.out.println("enter the maxtime");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxtimestr = br.readLine();
        System.out.println("Enter the maximum skew time");
        br = new BufferedReader(new InputStreamReader(System.in));
        skewtimestr= br.readLine();
        maxtime=Long.parseLong(maxtimestr);
        skewtime=Long.parseLong(skewtimestr);
        while(true) {
            datatime = System.currentTimeMillis();
            long G = datatime + maxtime + skewtime;
            System.out.println("G ="+ new Timestamp(G));
            ser.setTimeStamp(new Timestamp(G));
            ser.recPort(8001);
            ser.recData();
        }
    }
}