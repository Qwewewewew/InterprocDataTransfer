package qwew.net;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IConnector connector = new UDPConnector("127.0.0.1", 8080);
        Scanner in = new Scanner(System.in);
        boolean isReceiver = in.nextBoolean();
        if(isReceiver){
            System.out.println(connector.get());
        }
        else{
            connector.send(in.next());
        }
    }
}