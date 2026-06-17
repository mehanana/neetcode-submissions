class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        backtrack(res, new ArrayList(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> part, String s, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList(part));
            return;
        }
        // every possible substring
        for (int j = index; j < s.length(); j++) {
            if (isPalindrome(s, index, j)) {
                part.add(s.substring(index, j+1));
                backtrack(res, part, s, j+1);
                part.remove(part.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
