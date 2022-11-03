package kr.co.demo02.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        /*
         *      TCP 연결
         */
        Scanner sc = new Scanner(System.in);
        byte[] serverIp = {127, 0, 0, 1};
        int serverPort = 50000;

        try {
            InetAddress serverInet = InetAddress.getByAddress(serverIp);

            Socket sock = new Socket(serverInet, serverPort);

            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

            while(true) {
                System.out.print("서버에 보낼 메시지 입력 : ");
                String msg = sc.nextLine();

                bw.write(msg);
                bw.newLine();
                bw.flush();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
