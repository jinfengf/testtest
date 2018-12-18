import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * Created by jiguang on 2018/10/12.
 */

public class FileTest {
    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset().toString());
        File file = new File("aaaaa");
//        File origin = new File("123.gradle");
//        BufferedReader reader = null;
//        BufferedWriter writer = null;
//        try {
//            reader = new BufferedReader(new FileReader(origin));
//
//            File temp = new File("1234.gradle");
//            temp.createNewFile();
//            writer = new BufferedWriter(new FileWriter(temp));
//            String len = reader.readLine();
//            String next;
//            while ((next = reader.readLine()) != null) {
//                System.out.println(len);
//                System.out.println(len.length());
//                writer.write(len);
//                writer.write("\n");
//                len = next;
//            }
//            writer.write("implementation microModule(':p_im_ccccccccc')\n");
//            writer.write("}\n");
//        } catch (Exception e) {
//        } finally {
//            if (reader != null) {
//
//            }
//            reader.close();
//            writer.close();
//        }
//        origin.delete();
//        temp.renameTo(origin);

//        writer.close();
    }
}
