import java.util.concurrent.Semaphore;
import java.util.* ;
//Qitem contains buffer and full and empty indicators
class Qitem {
  int item,
  n,
  full,
  empty;
  int[] buffer;
  Qitem(int n) {
    this.n = n;
    buffer = new int[n];
    full = 0;
    empty = n;
  }

  int x;
  //Semaphore initialised
  static Semaphore sem = new Semaphore(1);

  Random random = new Random();

  void get() {
    while (full <= 0);
    try {
      sem.acquire();
    } catch(InterruptedException e) {
      System.out.println("InterruptedException caught");
    }
    int rand = random.nextInt(n);
    if (buffer[rand] == 1) {
      buffer[rand] = 0;
      full--;
      empty++;
      System.out.println("Consumer consumed at " + rand + ", Buffer = " + Arrays.toString(buffer));
    }
    sem.release();
  }

  void put() {
    while (empty <= 0);
    try {
      sem.acquire();
    } catch(InterruptedException e) {
      System.out.println("InterruptedException caught");
    }
    int rand = random.nextInt(n);
    if (buffer[rand] == 0) {
      buffer[rand] = 1;
      empty--;
      full++;
      System.out.println("Producer produced at " + rand + ", Buffer = " + Arrays.toString(buffer));
    }
    sem.release();
  }
}
//Producer Class
//Qitem produced
class Producer extends Thread {
  Qitem q;
  long start = System.currentTimeMillis();
  long end;
  long time;
  Producer(Qitem q, long time) {
    this.q = q;
    this.time = time;
    end = start + time;
  }
  public void run() {
    while (System.currentTimeMillis() < end) {
      q.put();
    }
  }
}
//Consumer Class 
//Qitem is item consumed by consumer
class Consumer extends Thread {
  Qitem q;
  long start = System.currentTimeMillis();
  long end;
  long time;
  Consumer(Qitem q, long time) {
    this.q = q;
    this.time = time;
    end = start + time;
  }
  public void run() {
    while (System.currentTimeMillis() < end) {
      q.get();
    }
  }
}
//Producer Consumer Runner Class
public class ProducerConsumer {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System. in );
    System.out.print("Enter duration of programme in milliseconds:");
    long time = sc.nextInt();
    System.out.print("Enter buffer length:");
    int n = sc.nextInt();
    Qitem q = new Qitem(n);
    Producer p = new Producer(q, time);
    Consumer c = new Consumer(q, time);
    p.start();
    c.start();
  }
}
