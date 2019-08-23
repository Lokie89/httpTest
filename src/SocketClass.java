import java.net.ServerSocket;
import java.net.Socket;

public class SocketClass {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(9000);
            RequestThreadPool requestThreadPool = new RequestThreadPool();
            while (true) {
                Socket socket = serverSocket.accept();
                RequestThread requestThread = requestThreadPool.getRequestThread(socket);
                requestThread.run();
                socket.close();
                requestThreadPool.returnRequestThread(requestThread);
            }
        } catch (Exception e) {

        }

    }
}
