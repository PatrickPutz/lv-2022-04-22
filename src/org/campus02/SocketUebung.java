package org.campus02;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketUebung {

    public static void main(String[] args) {

        try (Socket socket = new Socket("info.cern.ch", 80)){

            InputStream read = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(read));

            OutputStream send = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(send));

            bw.write("GET / HTTP/1.1\r\n");
            bw.write("Host: info.cern.ch\r\n\r\n");
            bw.flush();

            String string;
            while((string = br.readLine()) != null){
                System.out.println(string);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        try ( Socket socket = new Socket("info.cern.ch", 80)) {

            InputStream read = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(read));

            OutputStream send = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(send));

            bw.write("GET / HTTP/1.1\r\n");
            bw.write("Host: info.cern.ch\r\n\r\n");
            bw.flush();

            String html;
            while((html = br.readLine()) != null){
                System.out.println(html);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
    }

}
