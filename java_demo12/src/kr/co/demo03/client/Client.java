package kr.co.demo03.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private int serverPort = 50000;
    private String serverIp = "127.0.0.1";

    private Socket sock;
    private BufferedInputStream serverIn;
    private BufferedOutputStream serverOut;

    public boolean connect() {
        try {
            this.sock = new Socket(serverIp, serverPort);

            this.serverIn = new BufferedInputStream(sock.getInputStream());
            this.serverOut = new BufferedOutputStream(sock.getOutputStream());

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void upload(String filePath) {
        File f = new File(filePath);

        if(!f.exists()) {
            System.out.println("업로드 할 파일이 존재하지 않습니다. 파일 경로와 파일명을 다시 확인하세요.");
            return;
        }

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))) {
            this.serverOut.write("fileName=".getBytes());
            this.serverOut.write(f.getName().getBytes());
            this.serverOut.write("\r\n".getBytes());
            this.serverOut.flush();
            byte buf[] = new byte[4096];
            System.out.println(f.getName() + "파일을 전송합니다.");
            while(true) {
                int len = bis.read(buf);
                if(len == -1) {
                    break;
                }
                this.serverOut.write(buf, 0, len);
                this.serverOut.flush();
            }
            System.out.println("파일 전송이 완료되었습니다.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /*
         * 파일 업로드/다운로드 클라이언트
         */
        Client client = new Client();
        boolean res = client.connect();
        if(res) {
            System.out.println("서버에 연결되었습니다.");
        } else {
            System.out.println("서버 연결에 실패하였습니다. 서버 주소를 확인해보세요.");
        }
        client.upload("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/birthday.txt");
    }

}