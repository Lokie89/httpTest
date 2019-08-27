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
            int msg = 0;
            CustomRequest request = new CustomRequest();
            int i = 0;
            String message = "";
//            while ((msg = br.read())!=-1) {
//                message += (char)msg;
//                String[] msgArray = message.split(" ");
//                System.out.println(message);
//                switch (++i) {
//                    case 1:
//                        request.setMethod(msgArray[0]);
//                        request.setUri(msgArray[1]);
//                        request.setProtocol(msgArray[2]);
//                        break;
//                    case 2:
//                        request.setHost(msgArray[1]);
//                        break;
//                    case 9:
//                        request.setAccept(msgArray[1]);
//                        break;
//                    case 13:
//                        request.setCookie(msgArray[1]);
//                        break;
//                    default:
//                        break;
//                }
//            }
            request.setUri("/a");
            Controller controller = new Controller();
            controller.httpControll(request, socket);
            br.close();
            System.out.println(request.toString());


        } catch (Exception e) {

        }
    }
}
