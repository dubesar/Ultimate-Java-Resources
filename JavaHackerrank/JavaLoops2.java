import java.util.Scanner;

class JavaLoops2 {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            printAP(a, b, n);
        }
        in.close();
    }

    private static void printAP(int a, int b, int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int sumOfPowers = calculatePower(i, b);
            arr[i] = a + sumOfPowers;
            if (i < n - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.println(arr[i]);
            }

        }
    }

    private static int calculatePower(int i, int b) {
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            int oneValue = (int) (Math.pow(2, j)) * b;
            sum = sum + oneValue;
        }
        return sum;
    }
}