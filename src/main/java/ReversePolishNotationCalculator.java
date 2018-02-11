import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReversePolishNotationCalculator {
    public double evaluate(String expr) {
        if (expr.length() == 0) return 0;
        List<String> list = new LinkedList<>(Arrays.asList(expr.split(" ")));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("\\D")) {
                List<String> sublist = list.subList(i - 2, i + 1);
                String result = calculate(sublist).toString();
                sublist.clear();
                list.add(i - 2, result);
                i = 0;
            }
        }
        return Double.valueOf(list.get(list.size() - 1));
    }

    private Double calculate(List<String> list) {
        switch (list.get(2)) {
            case "+":
                return Double.valueOf(list.get(0)) + Double.valueOf(list.get(1));
            case "-":
                return Double.valueOf(list.get(0)) - Double.valueOf(list.get(1));
            case "*":
                return Double.valueOf(list.get(0)) * Double.valueOf(list.get(1));
            case "/":
                return Double.valueOf(list.get(0)) / Double.valueOf(list.get(1));
        }
        return 0d;
    }
}
