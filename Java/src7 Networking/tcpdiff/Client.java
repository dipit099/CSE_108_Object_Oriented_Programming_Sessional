package tcpdiff;

import java.util.Scanner;

import util.SocketWrapper;

public class Client {

    public Client(String serverAddress, int serverPort) 
    {
        System.out.println("Client starts");
        try {
            System.out.print("Enter name of the client: ");
            Scanner scanner = new Scanner(System.in);
            String clientName = scanner.nextLine();
            SocketWrapper socketWrapper = new SocketWrapper(serverAddress, serverPort);
            socketWrapper.write(clientName);    //send the name to the server and then server calls "serve"
            new ReadThread(socketWrapper);
            new WriteThreadClient(socketWrapper, clientName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) 
    {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        new Client(serverAddress, serverPort);
    }
}
