import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Git {
    private HashMap<String,String> map;
    private Path indexPath;
    private Path objectsPath;
    public Git (){
        map = new HashMap<String,String>();
        indexPath = Paths.get("index");
        objectsPath = Paths.get("objects");
    }
    
    public void initialize() throws Exception{
        if (!Files.exists(indexPath)){
            Files.createFile(indexPath);
        }
        if (!Files.exists(objectsPath)){
            Files.createDirectory(objectsPath);
        }
    }
    
    public void addBlob(String fileName) throws Exception{
        Blob blob = new Blob(fileName);
        blob.writeToFile();
        map.put(fileName, blob.getSHA());
        updateFile();
    }

    private void updateFile() throws Exception{
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<String, String> entry : map.entrySet()){
            sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
        }
        if (sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        Utils.writeToFile(sb.toString(), indexPath.toString());
    }

    public void removeBlob(String fileName) throws Exception{
        if (map.containsKey(fileName)){
            map.remove(fileName);
            updateFile();
        }
    }
}
