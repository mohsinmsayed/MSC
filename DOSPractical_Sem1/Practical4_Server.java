import java.util.*;
import java.net.*;

class RPCServer {
    DatagramSocket ds;
    DatagramPacket dp;
    String str, methodname, result;
    int val1, val2;
    RPCServer() {
        try {
            ds = new DatagramSocket(1200);
            byte b[] = new byte[1024];
            while(true) {
                dp = new DatagramPacket(b, b.length);
                ds.receive(dp);
                str = new String(dp.getData(),0,dp.getLength());
                if(str.equalsIgnoreCase("q")) {
                    System.exit(1);
                } else {
                    StringTokenizer st = new StringTokenizer(str," ");
                    while(st.hasMoreTokens()) {
                        String Token = st.nextToken();
                        methodname = Token;
                        val1 = Integer.parseInt(st.nextToken());
                        val2 = Integer.parseInt(st.nextToken());
                    }
                }
                System.out.println(str);
                InetAddress.getLocalHost();
                if(methodname.equalsIgnoreCase("add")) {
                    result = " "+add(val1, val2);
                } else if(methodname.equalsIgnoreCase("sub")) {
                    result = " "+sub(val1, val2);
                } else if(methodname.equalsIgnoreCase("mul")) {
                    result = " "+mul(val1, val2);
                } else if(methodname.equalsIgnoreCase("div")) {
                    result = " "+div(val1, val2);
                }
                byte b1[] = result.getBytes();
                DatagramSocket ds1 = new DatagramSocket();
                DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 1300);
                System.out.println("result:" +result+ "\n");
                ds1.send(dp1);
                ds1.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public int add(int val1,int val2) {
        return val1+val2;
    }
    public int sub(int val1,int val2) {
        return val1-val2;
    }
	public int mul(int val1,int val2) {
		return val1*val2;
	}
	public int div(int val1,int val2) {
		return val1/val2;
	}
	public static void main(String args[]) {
        new RPCServer();
    }
}