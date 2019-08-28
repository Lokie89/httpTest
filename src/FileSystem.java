import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    public Map fileToString(String path) {
        Map<String, Object> result = new HashMap<>();
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            br = new BufferedReader(new InputStreamReader(fis));
            String fileString = null;
            StringBuilder sb = new StringBuilder();
            while ((fileString = br.readLine()) != null) {
                sb.append(fileString);
                sb.append("\n");
            }
            result.put("statusCode", 200);
            result.put("body", sb.toString());
            return result;
        } catch (FileNotFoundException e) {
            result.put("statusCode", 404);
            result.put("body", "");
            return result;
        } catch (IOException e) {
            result.put("statusCode", 500);
            result.put("body", "");
            return result;
        } finally {
            try {
                br.close();
            } catch (Exception e) {

            }
        }
    }

}
