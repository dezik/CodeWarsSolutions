public class NumberOfTrailingZerosOfN {
    public static int zeros(int n) {
        int out = 0;
        for (int i = n; i > 1; i = i / 5) {
            out += i / 5;
        }
        return out;
    }
}
