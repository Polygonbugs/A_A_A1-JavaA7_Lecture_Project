import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 50000;

        ServerSocket server;
        try {
            server = new ServerSocket(port);
            Socket client = server.accept();
            System.out.println("클라이언트의 연결 요청 승낙!");
            System.out.println("클라이언트와 통신을 위한 소켓을 생성합니다.");
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("클라이언트와 통신을 위한 입출력 스트림을 생성합니다.");

            while(true) {
                while(br.ready()) {
                    String recv = br.readLine();
                    System.out.println("클라이언트(" + client.getInetAddress() + ":" + client.getPort() + ")부터 메시지 : " + recv);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
