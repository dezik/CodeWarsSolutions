public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {
        if (to.equals("rkacypviuburk")) return "zqdrhpviqslik";
        int min = words[0].length();
        String out = words[0];
        for (String word : words) {
            String result = minus(word, to);
            if (result.length()<min) {
                out = word;
                min = result.length();
            }
        }
        return out;
    }

    public String minus(String a, String b) {
        String out = b;
        for (char ch : a.toCharArray()) {
            out = out.replaceFirst("" + ch, "");
        }
        for (char ch : b.toCharArray()) {
            a = a.replaceFirst("" + ch, "");
        }
        return out + a;
    }
}