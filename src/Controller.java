import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.nio.file.Files;

public class Controller {

    public void httpControll(CustomRequest request, Socket socket) {
        CustomResponse customResponse = new CustomResponse();
        String uri = request.getUri();
        System.out.print(uri);
        DataOutputStream bw = null;
        try {
            bw = new DataOutputStream(socket.getOutputStream());
            System.out.println("###############");
            File file = new File("./src/"+request.getUri());
            FileInputStream fileInputStream = new FileInputStream("./src/"+request.getUri());
            byte[] fileContent = new byte[(int)file.length()];
            fileInputStream.read(fileContent);
            byte[] body = "Hello World".getBytes();
            bw.writeBytes("HTTP/1.1 200 OK \r\n");
            bw.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            bw.writeBytes("Content-Length: " + fileContent.length + "\r\n");
            bw.writeBytes("\r\n");

            bw.write(fileContent, 0, fileContent.length);
            bw.writeBytes("\r\n");
            bw.flush();
        } catch (Exception e) {

        } finally {
            try {
                socket.close();
            } catch (Exception e) {

            }
        }

    }

}
