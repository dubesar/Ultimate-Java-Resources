// Thread Implementation using Runnable (Runnable does not return any object)
public class Driver {

        static final int MAX_T = 100;

        public static void main(String abc[]) {

            Runnable r2 = new Thread("Hello : ");

            for (int i=0 ; i< 1000000 ;i++)
            {
               r2.run();

            }
        }
    }

class Thread implements Runnable {


    private String name;
    String digest;

    public Thread(String s)
    {
        name = s;
    }
    public void run() {
        try {
            digest = "hello";
            System.out.println(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



