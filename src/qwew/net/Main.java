package qwew.net;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Set up as reciever?[y/n]");
        String isReceiver = in.next();

        System.out.println("Enter port to bind:");
        int port = in.nextInt();

        if(!Objects.equals(isReceiver, "n")){
            IConnector connector = new UDPConnector(port);
            System.out.println("\n--CONNECTOR IS SET UP--\n");
            System.out.println(connector.get());
        }
        else{
            IConnector connector = new UDPConnector(port);
            System.out.println("--CONNECTOR IS SET UP--\n");

            System.out.println("Enter destination:");
            String destIP = in.next();
            int destPort = in.nextInt();

            System.out.println("\nEnter message to send: ");
            connector.send(in.next(), destIP, destPort);
        }
    }
}