public class RomanNumeralsEncoder {
    public String solution(int n) {
        int i = n % 10;
        int x = (n % 100 - i) / 10;
        int c = (n % 1000 - x - i) / 100;
        int m = (n % 10000 - c - x - i) / 1000;
        return getM(m)
                + getRom(c, "C", "D", "M")
                + getRom(x, "X", "L", "C")
                + getRom(i, "I", "V", "X");
    }

    private String getM(int number) {
        StringBuilder out = new StringBuilder();
        while (number > 0) {
            out.append("M");
            number--;
        }
        return out.toString();
    }

    private String getRom(int number, String init, String five, String fin) {
        if (number == 0) return "";
        if (number == 9) return init + fin;
        if (number == 4) return init + five;
        String out = "";
        if (number >= 5) out = five;
        int middle = number % 5;
        while (middle > 0) {
            out += init;
            middle--;
        }
        return out;
    }
}
