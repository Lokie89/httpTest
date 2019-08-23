import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RequestThread implements Runnable {

    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            CustomRequest request = new CustomRequest();
            int i = 0;
            while ((msg = br.readLine()) != null) {
                String[] msgArray = msg.split(" ");
                switch (++i) {
                    case 1:
                        request.setMethod(msgArray[0]);
                        request.setUri(msgArray[1]);
                        request.setProtocol(msgArray[2]);
                        break;
                    case 2:
                        request.setHost(msgArray[1]);
                        break;
                    case 9:
                        request.setAccept(msgArray[1]);
                        break;
                    case 13:
                        request.setCookie(msgArray[1]);
                        break;
                    default:
                        break;
                }
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("<html><head></head><body>abcd</body></html>");
            bw.flush();
            bw.close();

        } catch (Exception e) {

        }
    }
}
