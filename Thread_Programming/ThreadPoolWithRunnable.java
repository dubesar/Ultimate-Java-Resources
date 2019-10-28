import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolWithRunnable {

//Executor maintains thread pool to improve application performance by avoiding the continuous spawning of threads.
//It executes the task bu running necessary threads from the pool.

        static final int MAX_T = 10; //Thread Pool Size
        static  int i = 0;
        public static void main(String abc[]) {


            Runnable r1 = new Thread_1();

            // creates a thread pool with MAX_T no. of threads for concurrent execution

            ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

            // passes the Task objects to the pool to execute

        for( i=0;i<20;i++)
        {
            pool.execute(r1);  //Executes by picking non-running thread from the pool.
        }


            pool.shutdown();
        }

}


class Thread_1 implements Runnable {


    private int name;

    public Thread_1(){

    }

    public void run() {
        try {

            System.out.println("Thread " +
                    java.lang.Thread.currentThread().getId() +
                    " is running");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



