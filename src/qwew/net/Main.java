package qwew.net;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Set up as reciever?[y/n]");
        String isReceiver = in.next();

        System.out.println("Enter port to bind to:");
        int port = in.nextInt();

        //Receiver setup
        if(!Objects.equals(isReceiver, "n")){
            IConnector connector = new UDPConnector(port);
            System.out.println("\n--CONNECTOR IS SET UP--\n");
            System.out.println(connector.get());
        }

        //Sender setup
        else{
            IConnector connector = new UDPConnector(port);
            System.out.println("--CONNECTOR IS SET UP--\n");

            System.out.println("Enter destination:"); //Enter in two separate lines
            String destIP = in.next();
            int destPort = in.nextInt();

            System.out.println("\nEnter message to send: ");
            connector.send(in.next(), destIP, destPort);
        }

        in.next(); //For program not to close, simple yet effective way
    }
}