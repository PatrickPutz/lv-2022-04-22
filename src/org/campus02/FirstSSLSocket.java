package org.campus02;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class FirstSSLSocket {

    public static void main(String[] args) {

        try(Socket socket = SSLSocketFactory.getDefault().createSocket("news.orf.at", 443);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            bw.write("GET / HTTP/1.1\r\nHost: news.orf.at\r\n\r\n");
            bw.flush();

            String html;
            while((html = br.readLine()) != null){
                System.out.println(html);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
