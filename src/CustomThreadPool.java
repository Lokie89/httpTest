import java.net.Socket;
import java.util.Stack;

public class CustomThreadPool {
    private static final int amountThread = 10;

    Stack<CustomThread> threadPool = null;

    public CustomThreadPool() {
        threadPool = new Stack<>();
        for (int i = 0; i < amountThread; i++) {
            CustomThread customThread = new CustomThread();
            threadPool.push(customThread);
        }
    }

    public CustomThread getCustomThread(Socket socket) {
        CustomThread customThread = threadPool.pop();
        customThread.setSocket(socket);
        return customThread;
    }

    public void returnRequestThread(CustomThread customThread){
        threadPool.push(customThread);
    }
}
