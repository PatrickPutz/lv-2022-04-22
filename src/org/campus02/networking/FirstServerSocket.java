package org.campus02.networking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FirstServerSocket {

    public static void main(String[] args) {

        System.out.println("Server wird erstellt und wartet auf Client");
        try(ServerSocket serverSocket = new ServerSocket(1111)){
            while(true){
                try(Socket client = serverSocket.accept();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
                    System.out.println("Client hat sich verbunden");
                    bw.write("Hallo Client");
                    bw.flush();
                    System.out.println("Antwort an Client gesendet");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
