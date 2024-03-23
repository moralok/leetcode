package daily;

import java.util.HashMap;
import java.util.Map;

public class Daily20240321Lc2671Solution {

    private static class FrequencyTracker {

        private final int[] counter;
        private final int[] index;

        public FrequencyTracker() {
            counter = new int[100001];
            index = new int[100001];
        }

        public void add(int number) {
            int preFrequency = counter[number];
            counter[number]++;
            if (index[preFrequency] > 0) {
                index[preFrequency]--;
            }
            index[preFrequency + 1]++;
        }

        public void deleteOne(int number) {
            int preFrequency = counter[number];
            if (preFrequency == 0) {
                return;
            }
            counter[number]--;
            if (index[preFrequency] > 0) {
                index[preFrequency]--;
            }
            index[preFrequency - 1]++;
        }

        public boolean hasFrequency(int frequency) {
            return index[frequency] > 0;
        }
    }

    private static class FrequencyTracker1 {

        private final Map<Integer, Integer> counter;

        public FrequencyTracker1() {
            counter = new HashMap<>();
        }

        public void add(int number) {
            if (counter.containsKey(number)) {
                counter.put(number, counter.get(number) + 1);
            } else {
                counter.put(number, 1);
            }
        }

        public void deleteOne(int number) {
            if (counter.containsKey(number)) {
                int count = counter.get(number);
                if (count == 1) {
                    counter.remove(number);
                } else {
                    counter.put(number, count - 1);
                }
            }
        }

        public boolean hasFrequency(int frequency) {
            for (int count : counter.values()) {
                if (count == frequency) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(1);
        frequencyTracker.deleteOne(1);
        assert !frequencyTracker.hasFrequency(1);

        FrequencyTracker1 frequencyTracker1 = new FrequencyTracker1();
        frequencyTracker1.add(1);
        frequencyTracker1.deleteOne(1);
        assert !frequencyTracker1.hasFrequency(1);
    }
}
