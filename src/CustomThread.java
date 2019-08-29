import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;

public class CustomThread implements Runnable {

    private static final String fileRoot = "./src/html";
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = br.readLine();
            CustomRequest request = new CustomRequest();
            request.setMethod(msg.split(" ")[0]);
            request.setUri(msg.split(" ")[1]);
            request.setProtocol(msg.split(" ")[2]);
            int i = 0;
            while (!(msg = br.readLine()).equals("")) {
                String[] msgArray = msg.split(" ");
                switch (++i) {
                    case 1:
                        request.setHost(msgArray[1]);
                        break;
                    case 8:
                        request.setAccept(msgArray[1]);
                        break;
                    case 12:
                        request.setCookie(msgArray[1]);
                        break;
                    default:
                        break;
                }
            }
            if (!request.getUri().equals("/favicon.ico")) {
                String uri = request.getUri();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                Map result = new FileSystem().getFile(fileRoot + uri);

                int statusCode = (int) result.get("statusCode");
                String body = (String) result.get("body");

                bw.write(new CustomResponse().getHeader(statusCode, body.length()));
                bw.write(body, 0, body.length());
                bw.flush();
                bw.close();
            }

        } catch (Exception e) {

        } finally {
            try {
                br.close();
                socket.close();
            } catch (Exception e) {

            }
        }
    }
}
