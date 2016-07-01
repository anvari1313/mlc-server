package com.mlc.server;

/**
 * Created by ahmad on 7/1/16.
 */
public class MLCServer {
    public static void main(String[] args) {
        Thread server = new Server();
        server.start();
    }
}
