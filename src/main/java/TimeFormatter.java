import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";
        List<String> stringList = new ArrayList<>();
        stringList.add(asString(seconds / 31536000, "year"));
        stringList.add(asString((seconds / 86400) % 365, "day"));
        stringList.add(asString((seconds / 3600) % 24, "hour"));
        stringList.add(asString((seconds / 60) % 60, "minute"));
        stringList.add(asString(seconds % 60, "second"));

        return stringList.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(", "))
                .replaceAll(", (?=[\\w\\d\\s]+$)", " and ");
    }

    private static String asString(int quantity, String unit) {
        if (quantity < 1) return "";
        return quantity + " " + unit + ((quantity > 1) ? "s" : "");
    }
}