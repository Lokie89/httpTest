import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClass {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                Socket socket = serverSocket.accept();
                try {

                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = null;
                    while ((msg = br.readLine()) != null) {
                        System.out.println(msg);
                    }

                    br.close();
                } catch (Exception e) {

                } finally {
                    socket.close();
                }

            }
        } catch (Exception e) {

        }

    }
}
