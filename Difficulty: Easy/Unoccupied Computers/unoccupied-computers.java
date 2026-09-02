import java.util.*;

class Solution {
    public int solve(int n, String s) {
        Set<Character> using = new HashSet<>();
        Set<Character> arrived = new HashSet<>();

        int count = 0;

        for (char customer : s.toCharArray()) {
            if (!arrived.contains(customer)) {
                arrived.add(customer);

                if (using.size() < n) {
                    using.add(customer);
                } else {
                    count++;
                }
            } else {
                if (using.contains(customer)) {
                    using.remove(customer);
                }
            }
        }

        return count;
    }
}