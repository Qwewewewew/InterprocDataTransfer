package qwew.net;

import java.io.IOException;

public interface IConnector {
    String get() throws IOException;
    void send(String msg, String toIP, int toPort);
}
