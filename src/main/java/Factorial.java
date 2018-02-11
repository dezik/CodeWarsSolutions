import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(int i) {
        if (i == 0) return BigInteger.ONE;
        return BigInteger.valueOf(i).multiply(factorial(i - 1));
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + "!= " + factorial(i));
        }
    }
}
