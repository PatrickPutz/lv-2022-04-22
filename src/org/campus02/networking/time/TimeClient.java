package org.campus02.networking.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {

    public static void main(String[] args) {

        try(Socket socket = new Socket("localhost", 1111);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()
                    ));){

            String string;
            while((string = br.readLine()) != null){
                System.out.println("Server answer: " + string);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
