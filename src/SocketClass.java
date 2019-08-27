import java.net.ServerSocket;
import java.net.Socket;

public class SocketClass {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            CustomThreadPool requestThreadPool = new CustomThreadPool();
            while (true) {
                Socket socket = serverSocket.accept();
                CustomThread customThread = requestThreadPool.getCustomThread(socket);
                customThread.run();
                requestThreadPool.returnRequestThread(customThread);
            }
        } catch (Exception e) {

        } finally {
            try {
                serverSocket.close();
            }catch (Exception e){

            }
        }
    }
}
