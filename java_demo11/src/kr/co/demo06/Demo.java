package kr.co.demo06;

import java.io.*;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) {
        /*
         * Properties File을 불러오는데 사용한다
         */

        Properties prop = new Properties(); // key도 String, value도 String

        File f = new File("C:\\Users\\user1\\eclipse\\jee-2022-09\\eclipse\\configuration\\config.ini.bak");
        try {
            prop.load(new BufferedReader(new FileReader(f)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = prop.get("osgi.bundles").toString();
        System.out.println(value);

        f = new File("C:\\Users\\user1\\eclipse\\jee-2022-09\\eclipse\\configuration\\config.ini.bak");
        try {
            prop.store(new BufferedWriter(new FileWriter((f))), "코멘트");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
