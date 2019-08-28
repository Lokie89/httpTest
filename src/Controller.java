import java.io.*;
import java.net.Socket;

public class Controller {
    private static final String fileRoot = "./src/html/";
    public void httpControll(CustomRequest request, Socket socket) {
        String uri = request.getUri();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            FileInputStream fileInputStream = new FileInputStream(fileRoot + uri);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String body = "";
            String msg = null;
            while ((msg = br.readLine()) != null) {
                body += msg;
                body += "\n";
            }
//            String body = "Hello World";
            bw.write("HTTP/1.1 200 OK \r\n");
            bw.write("Content-Type: text/html;charset=utf-8\r\n");
            bw.write("Content-Length: " + body.length() + "\r\n");
            bw.write("\r\n");
            bw.write(body, 0, body.length());
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {

            }
        }

    }

}
