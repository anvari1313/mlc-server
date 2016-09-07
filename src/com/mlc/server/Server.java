package com.mlc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by ahmad on 7/1/16.
 */
public class Server extends Thread {
    private ArrayList<ClientInstance> clients;
    private ServerSocket serverSocket;

    private final int port = 6066;

    private boolean isRunning;

    public Server(){
        clients = new ArrayList<>();
        isRunning = true;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Server is started");
        while (isRunning){
            try {
                Socket socket = serverSocket.accept();
                System.out.println("new client accepted");
                clients.add(new ClientInstance(socket,this));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendToAll(Message message){
        for (ClientInstance ci :
                clients) {
            ci.sendMessage(message);
        }
    }
}
