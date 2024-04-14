package daily;

import java.util.LinkedList;

public class Daily20240414Lc0705Solution {

    private static class MyHashSet {

        private static final int BASE = 769;
        private LinkedList[] buckets;

        public MyHashSet() {
            buckets = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                buckets[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int idx = hash(key);
            LinkedList<Integer> bucket = buckets[idx];
            if (!bucket.contains(key)) {
                bucket.add(key);
            }
        }

        public void remove(int key) {
            int idx = hash(key);
            LinkedList<Integer> bucket = buckets[idx];
            bucket.remove((Integer) key);
        }

        public boolean contains(int key) {
            int idx = hash(key);
            LinkedList<Integer> bucket = buckets[idx];
            return bucket.contains(key);
        }

        private int hash(int key) {
            return key % BASE;
        }
    }
}
