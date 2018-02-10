class RangeExtractor {
    public static String rangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == 1) {
                if ((i + 1 >= arr.length) || (Math.abs(arr[i] - arr[i + 1]) != 1)) {
                    if (i > 1 && Math.abs(arr[i - 1] - arr[i - 2]) == 1) sb.append("-").append(arr[i]);
                    else sb.append(",").append(arr[i]);
                }
            } else sb.append(",").append(arr[i]);
        }
        return sb.toString();
    }
}