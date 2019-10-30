import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;

import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class SecureRandomClass {

    public static void generateSecureRandomValues() {
        SecureRandom secureRandom = new SecureRandom();

        int randomInt = secureRandom.nextInt();
        long randomLong = secureRandom.nextLong();
        float randomFloat = secureRandom.nextFloat();
        double randomDouble = secureRandom.nextDouble();
        boolean randomBoolean = secureRandom.nextBoolean();

        IntStream randomIntStream = secureRandom.ints();
        LongStream randomLongStream = secureRandom.longs();
        DoubleStream randomDoubleStream = secureRandom.doubles();

        byte[] values = new byte[124];
        secureRandom.nextBytes(values);
    }

    public static SecureRandom getSecureRandomForAlgorithm(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null || algorithm.isEmpty()) {
            return new SecureRandom();
        }

        return SecureRandom.getInstance(algorithm);
    }

    public static void main (String[] args) throws NoSuchAlgorithmException {
        generateSecureRandomValues();
        getSecureRandomForAlgorithm()
    }
}