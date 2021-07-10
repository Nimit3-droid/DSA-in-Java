package StringAlgos;

public class RollingHashFunction {
    static long prime = 31, primePower = 1, value = 0, MOD=100000007;

    public static long getHash(String key) {
        for (char c : key.toCharArray()) {
            value =(value + ((c - 'a' + 1) * primePower)%MOD)%MOD;
            primePower =(primePower * prime)%MOD;

        }
        return value;
    }

    public static void main(String[] args) {

        System.out.println(getHash("a a "));
    }
}
