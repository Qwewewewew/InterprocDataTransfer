package me.qwew.chat.connector;

import java.io.IOException;
import java.net.DatagramPacket;

public interface IConnector {
    
    DatagramPacket get() throws IOException;
    
    void send(String msg, String toIP, int toPort);
    
}
