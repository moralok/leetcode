package string.unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String local = email.substring(0, email.indexOf("@"));
            String domain = email.substring(email.indexOf("@"), email.length());
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            // 注意replaceAll的使用
            local = local.replaceAll("\\.", "");
            emailSet.add(local + domain);
        }
        return emailSet.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] case1 = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(solution.numUniqueEmails(case1));
    }
}