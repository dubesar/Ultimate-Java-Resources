class ComputeNumberOfDivisors {

    // Function that calculates number of divisors
    // Time Complexity : O( (n)^ 1/2 )
    static int numberOfDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 25;
        System.out.println("Total number of divisor of " + x + " are " + numberOfDivisors(x));
    }
}