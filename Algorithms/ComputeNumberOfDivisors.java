class ComputeNumberOfDivisors {

    // Method to find prime numbers
    static void SieveOfEratosthenes(int n, boolean prime[]) {
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }

    // Method to count divisors
    static int countDivisors(int n) {
        if (n == 1) {
            return 1;
        }
        boolean prime[] = new boolean[n + 1];
        boolean primeSquare[] = new boolean[(n * n) + 1];
        int a[] = new int[n];

        prime[1] = false;
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        SieveOfEratosthenes(n, prime);
        int j = 0;
        for (int p = 2; p <= n; p++) {
            if (prime[p]) {
                a[j] = p;
                primeSquare[p * p] = true;
                j++;
            }
        }
        int ans = 1;
        for (int i = 0;; i++) {
            if (n < a[i] * a[i] * a[i]) {
                break;
            }
            int cnt = 1;
            while (n % a[i] == 0) {
                n = n / a[i];
                cnt = cnt + 1;
            }
            ans = ans * cnt;
        }
        if (prime[n]) {
            ans = ans * 2;
        } else if (primeSquare[n]) {
            ans = ans * 3;
        } else if (n != 1) {
            ans = ans * 4;
        }

        return ans;
    }

    public static void main(String[] args) {
        int x = 100;
        System.out.println("Total number of divisors of " + x + " are " + countDivisors(x));
    }
}

// Time Complexity : O( n ^ (1/3) )