/**
 * Created by:
 *
 * @author Dmytro Shablia
 * @since 07.02.2018
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrom("Assa, a ss.a"));
        System.out.println(isPalindrom2("bababab"));
    }

    private static boolean isPalindrom(String str) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        StringBuilder sb = new StringBuilder(str).reverse();
        return sb.toString().equals(str);
    }

    private static boolean isPalindrom2(String str) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i -1)) return false;
        }
        return true;
    }
}
