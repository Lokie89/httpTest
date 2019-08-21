import java.net.ServerSocket;
import java.net.Socket;

public class SocketClass {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestThread thread = new RequestThread(socket);
                thread.run();
            }
        } catch (Exception e) {

        }

    }
}
