package org.campus02.networking.time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

    public static void main(String[] args) {

        System.out.println("Create the server...");
        try(ServerSocket serverSocket = new ServerSocket(1111)){

            int count = 0;
            while(count < 5){

                System.out.println("Wait for clients...");
                try(Socket client = serverSocket.accept();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){
                    System.out.println("Connected with client...");

                    LocalDateTime dateTime = LocalDateTime.now();
                    bw.write("Current datetime: " + dateTime.toString());

                    bw.flush();

                    count++;
                    System.out.println("Count: " + count);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
