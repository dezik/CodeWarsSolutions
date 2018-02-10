import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Decompose {

    public String decompose(long n) {
        List<Long> list = dedecompose(n, n * n);
        return list != null ?
                list.stream().map(Object::toString).collect(Collectors.joining(" "))
                : null;
    }

    private List<Long> dedecompose(long n, long diff) {
        if (diff == 0) return new ArrayList<>();
        for (long i = n - 1; i > 0; i--) {
            if (diff >= i * i) {
                List<Long> list = dedecompose(i, (diff - i * i));
                if (list != null) {
                    list.add(i);
                    return list;
                }
            }
        }
        return null;
    }

    public String decompose2(long n) {
        List<Long> decomposedList = decomposer(n, n * n);
        if(decomposedList == null) return "";
        decomposedList.remove(decomposedList.size() - 1);
        return decomposedList.stream().sorted().map(Object::toString).collect(Collectors.joining(" "));
    }

    public List<Long> decomposer(long n, long difference){
        // basic case
        if(difference == 0){
            List<Long> r = new ArrayList<>();
            r.add(n);
            return r;
        }

        // iterate all element less than n
        for(long i = n - 1 ; i > 0; i--){
            if((difference - i * i) >= 0){
                List<Long> r = decomposer(i, (difference - i * i));

                // only get the answer
                if(r != null){
                    r.add(n);
                    return r;
                }
            }
        }

        // no answer
        return null;
    }
}