import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//// Thread Implementation using Callable (It returns object through Future which stores the value.)
public class Driver_2 {
    static final int MAX_T = 100; // pool of threads inorder to implement Multithreading.

    public static void main(String abc[]) {
        Callable<String> r1 = new Thread_2();

        ExecutorService pool = Executors.newFixedThreadPool(MAX_T); //Executor Service - Capable of executing tasks concurrently in the background.

        for (int i = 0; i < 100; i++) {
            try {
                Future<String> session_id = pool.submit(r1); //Thread is submitted to get executed.
                String value = session_id.get(); // Callable returns value which is fetched through get method of Future.
                System.out.println("Value is " + value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread_2 implements Callable<String> {
    private String name;
    String digest;

    public Thread_2() {}

    public String call() {
        try {
            digest = "hello";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return digest; //Value of thread execution s returned.
    }
}
