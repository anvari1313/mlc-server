package com.mlc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by ahmad on 7/1/16.
 */
public class ClientInstance extends Thread {
    private Socket clientSocket;
    private String clientName;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean isClientConnected;
    private Server server;

    public ClientInstance(Socket clientSocket, Server server){
        this.clientSocket = clientSocket;
        this.server = server;
        try {
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        isClientConnected = true;
        start();
    }
    @Override
    public void run() {
        while (isClientConnected){
            try {
                System.out.println("Listening for the client....");
                Message m = ((Message) input.readObject());
                System.out.println("Client sends new message");
                server.sendToAll(m);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void sendMessage(Message message){
        try {
            output.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
