import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestThread implements Runnable {

    private Socket socket;

    public RequestThread (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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
        }catch(Exception e){

        }
    }
}
