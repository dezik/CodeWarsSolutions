import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifferenceTwoArrays {
    public static void main(String[] args) {
        int[] a = {1, 4, 6, 5};
        int[] b = {0, 5, 6, 7};
        List<Integer> list = new ArrayList<>();
        minus(a, b, list);
        minus(b, a, list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void minus(int[] a, int[] b, List list) {
        for (int i = 0; i < a.length; i++) {
            boolean exist = false;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    exist = true;
                    break;
                }
            }
            if (!exist) list.add(a[i]);
        }
    }
}
