import java.io.*;
import java.net.Socket;
import java.util.Map;

public class Controller {
    private static final String fileRoot = "./src/html";
    public void httpControll(CustomRequest request, Socket socket) {
        String uri = request.getUri();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            Map result = new FileSystem().fileToString(fileRoot + uri);

            int statusCode = (int)result.get("statusCode");
            String body = (String)result.get("body");

            bw.write(new CustomResponse().getHeader(statusCode,body.length()));
            bw.write(body, 0, body.length());
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                socket.close();
            } catch (Exception e) {

            }
        }

    }

}
