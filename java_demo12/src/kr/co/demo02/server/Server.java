package kr.co.demo02.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        /*
         *      TCP 연결
         */
        int serverPort = 50000;

        try {
            // 서버에서 사용할 연결소켓 생성
            System.out.println("클라이언트의 연결 요청을 처리할 소켓 생성");
            ServerSocket sSocket = new ServerSocket(serverPort);
            System.out.println("연결 요청 대기중...");

            // 클라이언트로부터 연결 요청 승낙 후 해당 클라이언트와의 연결 소켓 생성
            Socket sock = sSocket.accept();
            System.out.println("클라이언트의 연결 요청 승낙!");
            System.out.println("클라이언트와 통신을 위한 소켓을 생성합니다.");

            // 소켓으로 클라이언트와 통신을 하기 위한 입/출력 객체 생성
            System.out.println("클라이언트와 토인을 위한 입출력 스트림을 생성합니다.");
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

            // 무한 반복문을 통해 계속 대기하면서 입력스트림에 새로운 데이터가 있는지 확인
            while(true) {
                // 입력스트림에 데이터가 있으면 읽는다.
                while(br.ready()) {
                    String recv = br.readLine();
                    System.out.println("클라이언트(" + sock.getInetAddress() + ":" + sock.getPort() + ")부터 메시지 : " + recv);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
