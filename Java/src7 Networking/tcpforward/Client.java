package tcpforward;

import util.SocketWrapper;

import java.util.Scanner;

public class Client {

    public Client(String serverAddress, int serverPort) {
        try {
            System.out.print("Enter name of the client: ");
            Scanner scanner = new Scanner(System.in);
            String clientName = scanner.nextLine();
            SocketWrapper socketWrapper = new SocketWrapper(serverAddress, serverPort);// connect to the server
            socketWrapper.write(clientName);// send the name of the client to the server
            new ReadThreadClient(socketWrapper); // start a thread to read
            new WriteThreadClient(socketWrapper, clientName);// start a thread to write
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        new Client(serverAddress, serverPort);
    }
}
