package practice2023.design_circular_deque;

public class Lc0641SolutionArray {

    private int[] arr;
    private int l = 0, r = 0;
    private int size = 0;
    private int maxSize;

    public Lc0641SolutionArray(int k) {
        arr = new int[k];
        maxSize = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        size++;
        l = (l - 1 + maxSize) % maxSize;
        arr[l] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        size++;
        arr[r] = value;
        r = (r + 1) % maxSize;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        size--;
        l = (l + 1 + maxSize) % maxSize;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size--;
        r = (r - 1 + maxSize) % maxSize;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[l];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(r - 1 + maxSize) % maxSize];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
}
