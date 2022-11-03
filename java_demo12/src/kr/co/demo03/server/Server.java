package kr.co.demo03.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port = 50000;
    private Socket sock;
    private String fileName;
    private BufferedInputStream clientIn;
    private BufferedOutputStream clientOut;

    public void run() {
        try {
            ServerSocket sSocket = new ServerSocket(port);

            this.sock = sSocket.accept();

            this.clientIn = new BufferedInputStream(sock.getInputStream());
            this.clientOut = new BufferedOutputStream(sock.getOutputStream());

            byte buf[] = new byte[4096];

            while (true) {
                while (true) {
                    int len = this.clientIn.read(buf);
                    if (len == -1) {
                        break;
                    }

                    if (new String(buf, 0, 9).equals("fileName=")) {
                        if (this.fileName == null) {
                            this.fileName = new String(buf, 9, len);
                        }
                    } else {
                        this.save(buf, len);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(byte[] byteData, int length) {
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test" + this.fileName);

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f, true))) {
            bos.write(byteData, 0, length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /*
         * 파일 업로드/다운로드 서버
         */
        Server server = new Server();
        server.run();
    }
}
