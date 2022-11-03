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
         *      서버가 먼저 켜져있어야 작동될 수 있다.
         */
        Scanner sc = new Scanner(System.in);
        //byte[] serverIp = {127, 0, 0, 1};

        // 클라이언트에서 연결 요청할 서버의 IP와 Port를 지정
        String serverIp = "192.168.120.246";
        int serverPort = 50000;

        try {
            //InetAddress serverInet = InetAddress.getByAddress(serverIp);
            // 서버에 연결
            Socket sock = new Socket(serverIp, serverPort);

            // 연결된 소켓으로 통신을 위한 입/출력 스트림 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

            while(true) {
                System.out.print("서버에 보낼 메시지 입력 : ");
                String msg = sc.nextLine();

                bw.write(msg);
                bw.newLine();
                // 네트워크 통신에서 flush를 하지 않으면 서버에 데이터가 전달되지 않음
                bw.flush();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
