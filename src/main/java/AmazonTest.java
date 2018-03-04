import java.util.ArrayList;
import java.util.List;

public class AmazonTest {
    public static List<String> getSubstrs(String s, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= s.length() - n; i++) {
            String substring = s.substring(i, i + n);
            int repetitionCount = 0;
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n && repetitionCount < 2; k++) {
                    if (substring.charAt(j) == substring.charAt(k)) repetitionCount++;
                }
            }
            if (repetitionCount == 1) list.add(substring);
        }
        return list;
    }
}
