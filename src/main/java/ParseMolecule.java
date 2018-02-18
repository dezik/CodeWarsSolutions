import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMolecule {

    public static Map<String, Integer> getAtoms(String formula) {
        Map<String, Integer> map = fillMapWithElements(formula);
        for (String s : map.keySet()) {
            map.put(s, map.get(s) + getElementCount(formula, s));
        }
        return map;
    }

    private static Map<String, Integer> fillMapWithElements(String str) {
        Map<String, Integer> map = new HashMap<>();
        Matcher matcher = Pattern.compile("[A-Z][a-z]|[A-Z]").matcher(str);
        while (matcher.find()) {
            map.put(matcher.group(), 0);
        }
        if (map.size() == 0) throw new IllegalArgumentException();
        return map;
    }

    private static int insideOfBrackets(String str, String element) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('[', ']');
        int startPosition = str.indexOf(element);
        int multiplicator = getInitialMultiplicator(str, startPosition);
        for (int i = startPosition - 1; i > 0; i--) {
            boolean valid = false;
            if (brackets.containsKey(str.charAt(i))) {
                for (int j = startPosition + 1; j < str.length(); j++) {
                    if (brackets.get(str.charAt(i)) == str.charAt(j)) {
                        valid = true;
                        if (j < str.length() - 1 && Character.isDigit(str.charAt(j + 1))) {
                            multiplicator *= Character.getNumericValue(str.charAt(j + 1));
                            break;
                        }
                    }
                }
                if (!valid) throw new IllegalArgumentException();
            }
        }
        return multiplicator;
    }

    private boolean isValid(String str) {
        return false;
    }

    private static int getInitialMultiplicator(String str, int startPosition) {
        String initialMultiplicator = "";
        for (int i = startPosition + 1; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) initialMultiplicator += str.charAt(i);
            else break;
        }
        return initialMultiplicator.length() == 0 ? 1 : Integer.parseInt(initialMultiplicator);
    }

    private static int getElementCount(String str, String element) {
        int out = 0;
        while (str.contains(element)) {
            out += insideOfBrackets(str, element);
            str = str.replaceFirst(element, "");

        }
        return out;
    }
}

//    public static Map<String, Integer> getAtoms(String formula) {
//        Map<String, Integer> map = fillMapWithElements(formula);
//        for (String s : map.keySet()) {
//            map.put(s, map.get(s) + getElementCount(formula, s));
//        }
//        return map;
//    }
//
//    private static Map<String, Integer> fillMapWithElements(String str) {
//        Map<String, Integer> map = new HashMap<>();
//        Matcher matcher = Pattern.compile("[A-Z][a-z]|[A-Z]").matcher(str);
//        while (matcher.find()) {
//            map.put(matcher.group(), 0);
//        }
//        if (map.size() == 0) throw new IllegalArgumentException();
//        return map;
//    }
//
//    private static boolean insideOfBrackets(String str, String element) {
//        List<Character> openBrackets = Arrays.asList('(', '{', '[');
//        for (int i = 0; i < str.indexOf(element); i++) {
//            if (openBrackets.contains(str.charAt(i))) return true;
//        }
//        return false;
//    }
//
//    private static int getElementCount(String str, String element) {
//        int count = 1;
//        if (insideOfBrackets(str, element)) {
//            List<Character> closeBrackets = Arrays.asList(')', '}', ']');
//            for (int i = str.indexOf(element); i < str.length(); i++) {
//                if (closeBrackets.contains(str.charAt(i))) {
//                    if (i < str.length() - 1 && Character.isDigit(str.charAt(i + 1))) count *= Character.getNumericValue(str.charAt(i + 1));
//                }
//            }
//        } else if (str.lastIndexOf(element) < str.length() - 1 ) {
//            char nextToElementChar = str.charAt(str.lastIndexOf(element) + 1);
//            if (Character.isDigit(nextToElementChar)) return Character.getNumericValue(nextToElementChar);
//        }
//        return count;
//    }

