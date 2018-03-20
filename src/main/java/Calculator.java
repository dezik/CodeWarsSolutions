import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public static Double evaluate(String expression) {
        System.out.println(expression);
        List<String> expr = Arrays.asList(expression.split(" "));
        List<Double> numbers = expr.stream()
                .filter(s -> s.matches("-?\\d+\\.\\d+E\\d+|-?\\d+\\.\\d+|-?\\d+"))
                .map(Double::valueOf)
                .collect(Collectors.toList());
        if (numbers.size() == 0) return 0.0;
        if (numbers.size() == 1) return numbers.get(0);
        List<String> signs = expr.stream()
                .filter(s -> s.matches("[\\+\\-\\*\\/]"))
                .collect(Collectors.toList());

        for (int i = 0; i < signs.size(); i++) {
            if (signs.get(i).equals("/") || signs.get(i).equals("*")) {
                numbers.set(i, calculate(numbers.get(i), signs.remove(i), numbers.remove(i + 1)));
            }
        }
        while (numbers.size() > 1) {
            numbers.set(0, calculate(numbers.get(0), signs.remove(0), numbers.remove(1)));
        }
        return numbers.get(0);
    }

    private static Double calculate(Double a, String sign, Double b) {
        switch (sign) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException();
        }
    }
}