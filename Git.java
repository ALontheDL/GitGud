import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Git {
    public static void initialize() throws Exception{
        Path indexPath = Paths.get("index");
        Path objectsPath = Paths.get("objects");
        if (Files.exists(indexPath)){
            Files.createFile(indexPath);
        }
        if (Files.exists(objectsPath)){
            Files.createDirectory(objectsPath);
        }
    }
}
