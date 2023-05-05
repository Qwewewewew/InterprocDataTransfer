package qwew.net;

import java.io.IOException;

public class ListenerThread extends Thread {
    
    private IConnector connector;
    private int listenerPort;

    public ListenerThread(int port){
        this.listenerPort = port;
    }

    @Override
    public void run(){
        System.out.println("Listening for messages");
        connector = new UDPConnector(listenerPort);
        
        //main loop
        while(true){ 
            try {
                System.out.println(Main.destIP + ": " + connector.get());
            }
            catch(IOException e) {
                System.out.println("--Something went wrong..--");
            }
        }
    }
}
