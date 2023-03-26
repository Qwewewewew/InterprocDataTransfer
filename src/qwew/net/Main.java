package qwew.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    static IConnector connector;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Set up as receiver?[y/n]");
        String isReceiver = reader.readLine();

        System.out.println("Select protocol:\n\t0 for UDP(default)\n\t1 for TCP");
        boolean useTCP = reader.readLine() == "1";

        int port;
        try{
            port = Integer.parseInt(args[0]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Input port to bind to: ");
            port = Integer.parseInt(reader.readLine());
        }

        //Receiver setup
        if(!Objects.equals(isReceiver, "n")){
            connector = new UDPConnector(port);
            System.out.println("\n--CONNECTOR IS SET UP--\n");
            System.out.println(connector.get());
        }

        //Sender setup
        else{
            IConnector connector = new UDPConnector(port);
            System.out.println("\n--CONNECTOR IS SET UP--\n");

            System.out.println("Enter destination IP:");
            String destIP = reader.readLine();

            System.out.println("Enter port on destination host:");
            int destPort = Integer.parseInt(reader.readLine());

            System.out.println("\nEnter message to send: ");
            String msg = reader.readLine();
            connector.send(msg, destIP, destPort);
        }
    }
}