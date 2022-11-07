package review_project.demo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/입출력텍스트.txt");

        try(FileReader fr = new FileReader(f)) {
            char[] cArr = new char[(int)f.length()];
            char[] buffer = new char[8];

            while(true) {
                int readChars = fr.read(buffer);

                if(readChars == -1) {
                    break;
                }

                cArr = Arrays.copyOf(cArr, cArr.length + readChars);
                System.arraycopy(buffer, 0, cArr, cArr.length - readChars, readChars);
            }

            System.out.println(cArr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
