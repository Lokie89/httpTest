import java.net.Socket;
import java.util.Stack;

public class RequestThreadPool {
    private static final int amountThread = 10;

    Stack<RequestThread> threadPool = null;

    public RequestThreadPool() {
        threadPool = new Stack<>();
        for (int i = 0; i < amountThread; i++) {
            RequestThread requestThread = new RequestThread();
            threadPool.push(requestThread);
        }
    }

    public RequestThread getRequestThread(Socket socket) {
        RequestThread requestThread = threadPool.pop();
        requestThread.setSocket(socket);
        return requestThread;
    }

    public void returnRequestThread(RequestThread requestThread){
        threadPool.push(requestThread);
    }
}
