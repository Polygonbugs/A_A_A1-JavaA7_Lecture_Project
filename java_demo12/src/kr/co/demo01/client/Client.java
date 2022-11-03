package kr.co.demo01.client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        /*
         *  클라이언트측 프로그래밍 순서(UDP)
         *      1. 서버가 보낸 메시지를 받을 byte[] 준비
         *      2. DatagramSocket 객체 생성
         *      3. 메시지 받을 DatagramPacket 객체 생성
         *      4. byte[]로 받은 메시지를 String으로 변환
         */
        Scanner sc = new Scanner(System.in);

        // 연결할 서버의 IP 주소와 Port 번호 준비
        byte[] serverIp = {127, 0, 0, 1};
        int serverPort = 50000;

        try {
            // 서버 주소를 InetAddress 객체로 생성
            InetAddress serverInet = InetAddress.getByAddress(serverIp);
            DatagramSocket dSocket = new DatagramSocket();

            // 클라이언트의 연결 소켓 생성
            while(true) {
                System.out.print("서버에 보낼 메시지 입력 : ");
                String msg = sc.nextLine();

                // 서버에 메시지 전송을 위한 Packet 생성
                DatagramPacket dPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, serverInet, serverPort);

                // 서버에 메시지 전송
                dSocket.send(dPacket);

                // 서버에 메시지 전송 후 서버로부터 받을 메시지 대기
                byte[] data = new byte[1024];
                DatagramPacket recvPacket = new DatagramPacket(data, data.length);
                dSocket.receive(recvPacket);

                // 메시지를 받으면 출력
                String recv = new String(recvPacket.getData(), 0, recvPacket.getData().length);
                System.out.println("서버 응답(echo) : " + recv);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
