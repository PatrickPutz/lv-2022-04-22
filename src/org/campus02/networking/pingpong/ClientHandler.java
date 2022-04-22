package org.campus02.networking.pingpong;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    public void start(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){

            System.out.println("reading from client -->");
            String line = br.readLine();

            switch (line){
                case "ping":
                    System.out.println("Send PONG <---");
                    bw.write("pong");
                    break;
                case "pong":
                    System.out.println("Send PING <---");
                    bw.write("ping");
                    break;
                default:
                    System.out.println("Send ERROR <---");
                    bw.write("error");
            }

            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
