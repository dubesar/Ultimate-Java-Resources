import java.nio.charset.Charset;
import java.util.Random;

public class Singleton {
    private static Singleton instance;
    private String randomString;

    private Singleton() {
        System.out.println("Creating the one and only instance.");
        //creating random string that'll prove that this works.
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        randomString = new String(array);
    }

    public static Singleton getInstance() {
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

    String getRandomString(){
        return randomString;
    }

    //client code trying to create two instances of the class - gets same instances,
    // proof - randomString printed will be same
    public static void main(String[] args) {
        Singleton foo = Singleton.getInstance();
        System.out.println(foo.getRandomString());

        Singleton bar= Singleton.getInstance();
        System.out.println(bar.getRandomString());
    }
}
