import java.util.HashMap;
import java.util.Map;

public class EjerciciosPd {

    public long getFibonaci(int n) {
    if (n <= 1) 
        return n;
    return getFibonaci(n - 1) + getFibonaci(n - 2);                       
    }

    public Long getFibonaciPD(int n) {
        Map<Integer, Long> cache = new HashMap<>();
        return getFibonacciPDHelper(n, cache);
    }

    private Long getFibonacciPDHelper(int n, Map<Integer, Long> cache) {
        if (n <= 1)
            return (long) n;

        if (cache.containsKey(n))
            return cache.get(n);

        Long value = getFibonacciPDHelper(n - 1, cache) + getFibonacciPDHelper(n - 2, cache);
        cache.put(n, value);
        return value;
    } 
}