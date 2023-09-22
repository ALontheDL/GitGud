import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter {
    public FileWriter() {

    }

    public static void writeToFile(String str, String fileName) throws Exception {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.println(str);
        writer.close();
    }

    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, "UTF-8");
    }
}