package tcpforward;

import util.SocketWrapper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, SocketWrapper> clientMap;

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();    // wait for a client to connect
                serve(clientSocket); // serve the client in a separate thread
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
        String clientName = (String) socketWrapper.read();  // read the name of the client
        System.out.println("Client " + clientName + " connected");
        clientMap.put(clientName, socketWrapper);   // add the client to the map
        System.out.println("Client " + clientName + " added to the map");
        new ReadThreadServer(clientMap, socketWrapper); // start a thread to read from the client
    }

    public static void main(String args[]) {
        new Server();
    }
}
