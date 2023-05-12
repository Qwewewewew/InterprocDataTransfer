package me.qwew.chat.thread;

import java.io.IOException;
import java.net.DatagramPacket;
import me.qwew.chat.connector.*;

public class ListenerThread extends Thread {
    
    private IConnector connector;
    private int basePort;

    public ListenerThread(int port){
        this.basePort = port;
    }

    @Override
    public void run(){
        System.out.println("--LISTENING--\n");
        connector = new UDPConnector(basePort);
        
        //main loop
        while(true){ 
            try {
                DatagramPacket msg = connector.get();
                System.out.println("@" + msg.getAddress() + ": " + new String(msg.getData()));
            }
            catch(IOException e) {
                System.out.println("--Something went wrong..--");
            }
        }
    }
}
