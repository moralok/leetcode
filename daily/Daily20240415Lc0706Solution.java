package daily;

import java.util.LinkedList;

public class Daily20240415Lc0706Solution {

    private static class MyHashMap {

        private static final int BASE = 769;
        private LinkedList[] buckets;

        public MyHashMap() {
            buckets = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                buckets[i] = new LinkedList<int[]>();
            }
        }

        public void put(int key, int value) {
            int idx = hash(key);
            LinkedList<int[]> bucket = buckets[idx];
            for (int[] entry : bucket) {
                if (entry[0] == key) {
                    entry[1] = value;
                    return;
                }
            }
            bucket.add(new int[] {key, value});
        }

        public int get(int key) {
            int idx = hash(key);
            LinkedList<int[]> bucket = buckets[idx];
            for (int[] entry : bucket) {
                if (entry[0] == key) {
                    return entry[1];
                }
            }
            return -1;
        }

        public void remove(int key) {
            int idx = hash(key);
            LinkedList<int[]> bucket = buckets[idx];
            for (int[] entry : bucket) {
                if (entry[0] == key) {
                    bucket.remove(entry);
                    return;
                }
            }
        }

        private int hash(int key) {
            return key % BASE;
        }
    }
}
