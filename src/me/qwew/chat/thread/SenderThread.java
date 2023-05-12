package me.qwew.chat.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import me.qwew.chat.connector.IConnector;
import me.qwew.chat.connector.UDPConnector;

public class SenderThread extends Thread{
    //base connector
    IConnector connector;

    //Destination address
    String destIP;
    int destPort;

    //port to locate sender on
    int basePort;

    public SenderThread(int basePort, int destPort, String destIP){
        this.destPort = destPort;
        this.destIP = destIP;
        this.basePort = basePort;
    }

    @Override
    public void run(){
        //input setup
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        connector = new UDPConnector(this.basePort);
        
        System.out.println("--SENDER THREAD STARTED--\n");
        
        //variable to reassign without wasting memory
        String msg;
 
        //main loop
        while(true){
            //parsing message
            try{
                msg = stdin.readLine();
            }
            catch(IOException ioException){
                msg = "--ERR--";
                System.out.println(ioException.getMessage());
                break;
            }

            //sending message
            connector.send(msg, destIP, destPort);
            System.out.print("@You: " + msg + "\n");
            
        }
    }
}
