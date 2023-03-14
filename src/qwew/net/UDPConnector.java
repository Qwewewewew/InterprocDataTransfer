package qwew.net;

import java.net.*;
import java.io.IOException;

public class UDPConnector implements IConnector{

    private DatagramSocket dgSocket;

    public UDPConnector(int port) {
        try {
            dgSocket = new DatagramSocket(port);
        }catch (SocketException e){
            System.out.println("Something's wrong with socket:");
            System.out.println(e.getMessage());
        }
    }

    public UDPConnector(){
        try{
            this.dgSocket = new DatagramSocket();
        }catch(SocketException e){
            System.out.println("Something's wrong with socket: ");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String get() {
        StringBuilder msg = new StringBuilder();
        msg.append('-');
        try {
            while (msg.toString().toCharArray()[msg.length()-1] != '0') {
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
    public void send(String msg, String toIP, int toPort) {
        try {
            byte[] buffer = msg.getBytes();
            try{
                InetAddress destIP = InetAddress.getByName(toIP);
                DatagramPacket pack = new DatagramPacket(buffer, buffer.length, destIP, toPort);
                dgSocket.send(pack);
                dgSocket.close();
            }catch(UnknownHostException e){
                System.out.println("Something's wrong with the host: ");
                System.out.println(e.getMessage());
            }

            System.out.println("--SENT--");
        } catch (IOException e) {
            System.out.println("An error has occurred: ");
            System.out.println(e.getMessage());
        }
    }
}
