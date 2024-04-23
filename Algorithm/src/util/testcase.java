package util;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class testcase {
    public static void main(String[] args) throws  Exception{
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.append("1\n30 20 600\n");
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 20; j++) {
                output.append(i + " " + j + "\n");
            }
        }

        output.flush();
        output.close();
    }
}
