package daily;

public class Lc0204Solution2 {
    public int countPrimes(int n) {
        // 埃氏筛
        boolean[] isNotPrime = new boolean[n];
        int ret = 0;
        // 注意 i*i，这样要再遍历才能统计
        for (int i = 2; i * i < n; i++) {
            if (!isNotPrime[i]) {
                // 注意溢出
                for (int j = i * i; j < n; j = j+i) {
                    isNotPrime[j] = true;
                }
            }
        }
        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                ret++;
            }
        }
        return ret;
    }
}
