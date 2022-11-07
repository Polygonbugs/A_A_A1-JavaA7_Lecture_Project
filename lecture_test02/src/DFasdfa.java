import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DFasdfa {
    public void output() {
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/test123.txt");
        FileWriter fw = null;
        try {

            fw = new FileWriter(f, true);
            fw.write(65);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

