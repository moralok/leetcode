package hash_table.single_number;


public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNumber2 singleNumber = new SingleNumber2();
        int[] case1 = new int[] {2,2,1};
        int[] case2 = new int[] {4,1,2,1,2};
        System.out.println(singleNumber.singleNumber(case1));;
        System.out.println(singleNumber.singleNumber(case2));;
    }
}