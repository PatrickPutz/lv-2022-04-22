package org.campus02.networking.pingpong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(1111)){
            System.out.println("Server waits for clients...");

            try(Socket client = serverSocket.accept()){
                System.out.println("Connection to client established.");

                ClientHandler clientHandler = new ClientHandler(client);
                clientHandler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
