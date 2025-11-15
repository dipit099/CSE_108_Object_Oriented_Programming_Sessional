package tcpdiff;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import util.SocketWrapper;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, SocketWrapper> clientMap; // HashMap of client's name and socket information

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            new WriteThreadServer(clientMap, "Server"); //write thread for server..wait to read
            while (true) {
                Socket clientSocket = serverSocket.accept();    //wait for client to connect
                System.out.println("Server accepts the client");
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        System.out.println("I am in serve");
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);        
        String clientName = (String) socketWrapper.read();  //waiting to read the clientName
        System.out.println("I have read the clientName " + clientName);
        clientMap.put(clientName, socketWrapper);
        System.out.println("Entered into hashmap");
        new ReadThread(socketWrapper);
    }

    public static void main(String args[]) {
        new Server();
    }
}
