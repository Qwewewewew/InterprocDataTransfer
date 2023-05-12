package me.qwew.chat;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import me.qwew.chat.thread.ListenerThread;
import me.qwew.chat.thread.SenderThread;

import java.io.IOException;

public class Main {

    //port to bind sender to
    static int sendPort;
    static int getPort;

    //destination address
    static String destIP;
    static int destPort;

    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(reader);

        sendPort = 8080;
        getPort = 8081;

        //parsing destination address
        try{
            //trying to parse command line args
            destIP = args[0];
            destPort = Integer.parseInt(args[1]);
        }
        catch(ArrayIndexOutOfBoundsException outOfBoundsException){
            
            System.out.println("Enter destination IP:");
            destIP = stdin.readLine();
            destIP = destIP == "" ? "127.0.0.1" : destIP; //sets localhost as default if nothing was entered

            try {
                System.out.println("Enter port on destination host:");
                destPort = Integer.parseInt(stdin.readLine());
            }
            catch(NumberFormatException formatException) { //if destport is empty

                destPort = 8081; //sets default port
            }
        }

        System.out.println("--STARTING THREADS--\n");

        //threads setup
        ListenerThread listener = new ListenerThread(getPort);
        SenderThread sender = new SenderThread(sendPort, destPort, destIP);
        
        //starting
        listener.start();
        sender.start();
    }
}
