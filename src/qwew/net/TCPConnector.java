package qwew.net;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class TCPConnector implements IConnector{

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InetAddress iaddr;
    private int port;

    public TCPConnector(int port, InetAddress iaddr){
        this.port = port;
        this.iaddr = iaddr;
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public void send(String msg, String toIP, int toPort) {

    }
}
