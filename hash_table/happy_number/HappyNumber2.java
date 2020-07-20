package hash_table.happy_number;

public class HappyNumber2 {
    public boolean isHappy(int n) {
        // 快慢指针法检测循环
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            n = n / 10;
            sum += (d * d);
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber2 happyNumber = new HappyNumber2();
        int case1 = 19;
        int case2 = 116;
        System.out.println(happyNumber.isHappy(case1));
        System.out.println(happyNumber.isHappy(case2));
    }
}