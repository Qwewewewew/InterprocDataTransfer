package qwew.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPConnector implements IConnector{

    private int port;
    InetAddress iaddr;
    private DatagramSocket dgSocket;

    public UDPConnector(String addr, int port){
        try{
            this.port = port;
            this.iaddr = InetAddress.getByName(addr);
        }catch(UnknownHostException e1){
            System.out.println("Unable to connect to host. Host set to 127.0.0.1");
            System.out.println(e1.getMessage());
            try{
                this.iaddr = InetAddress.getByName("127.0.0.1");
            }catch(UnknownHostException e2){
                System.out.println("Unknown error occured: "+e2.getMessage());
            }
        }
    }

    @Override
    public String get() {
        StringBuilder msg = new StringBuilder();
        try {
            this.dgSocket = new DatagramSocket(this.port);

            while (msg.toString().toCharArray()[msg.length()-1] != "0".toCharArray()[0]) {

                DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
                dgSocket.receive(pack);
                msg.append(new String(pack.getData()));
            }
            return msg.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    public void send(String msg) {
        try {
            byte[] buffer = msg.getBytes();
            DatagramPacket pack = new DatagramPacket(buffer, buffer.length, iaddr, port);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
