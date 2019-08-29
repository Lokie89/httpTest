import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    HttpStatus status = HttpStatus.getInstance();

    public Map getFile(String path) {
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
            result.put("statusCode", status.getStatus(null));
            result.put("body", sb.toString());
            return result;
        } catch (FileNotFoundException e) {
            result.put("statusCode", status.getStatus(e));
            result.put("body", "");
            return result;
        } catch (IOException e) {
            result.put("statusCode", status.getStatus(e));
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
