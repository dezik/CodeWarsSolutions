import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        pascalTriangle(10);
    }

    private static List<List<Integer>> pascalTriangle(int count) {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) arr.add(1);
                else arr.add(matrix.get(i - 1).get(j - 1) + matrix.get(i - 1).get(j));
            }
            matrix.add(arr);
        }
        for (List<Integer> list : matrix) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
        return matrix;
    }
}
