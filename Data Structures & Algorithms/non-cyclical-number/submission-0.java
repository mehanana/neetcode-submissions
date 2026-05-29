class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int cur = n;
        while (!seen.contains(cur)) {
            seen.add(cur);
            int num = cur;
            int next = 0;
            while (num != 0) {
                int digit = num % 10;
                next += digit * digit;
                num /= 10;
            }
            cur = next;
            if (cur == 1) {
                return true;
            }
        }
        return false;
        
    }
}
