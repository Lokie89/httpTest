import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RequestThreadPool {
    private static final int amountThread = 10;

    public void runningThreads() {
        //https://limkydev.tistory.com/55
        //https://nearhomedeveloper.tistory.com/entry/JavaThread-Java-Thread-바로-종료-시키기-–-interrupt
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < amountThread; i++) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

        }

    }
}
