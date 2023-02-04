import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class WritingFile {
// Запись в файл
    public static void writerFile(String type, String nameOut, ArrayList merger) {
        try {
            PrintWriter writer = new PrintWriter(nameOut, "UTF-8");

            if (type == "-s") {
                for (Object s : merger) {
                    writer.println(s);
                }
            } else if (type == "-i") {
                for (Object s : merger) {
                    writer.println(s);
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
    }
}
