package qwew.net;

public interface IConnector {

    String get();

    void send(String msg, String toIP, int toPort);
}
