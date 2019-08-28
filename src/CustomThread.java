import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class CustomThread implements Runnable {

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
            request.setUri(request.getUri());
            if(!request.getUri().equals("/favicon.ico")){
                Controller controller = new Controller();
                controller.httpControll(request, socket);
            }
            br.close();
            socket.close();
        } catch (Exception e) {

        }
    }
}
