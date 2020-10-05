public class Prime {

    public static void main(String[] args) {

        int low = 20, high = 50;

        while (low < high) {

            if(checkPrimeNumber(low))

                System.out.print(low + " ");

            ++low;

        }

    }

    public static boolean checkPrimeNumber(int num) {

        boolean flag = true;

        for(int i = 2; i <= num/2; ++i) {

            if(num % i == 0) {

                flag = false;

                break;

            }

        }

        return flag;

    }

}
