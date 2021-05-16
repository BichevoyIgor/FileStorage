package com.bichevoy.server;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public Server() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        try (ServerSocket server = new ServerSocket(6789)) {
            while (true){
                service.execute(new ClientHandler(server.accept()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
