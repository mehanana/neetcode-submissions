class Solution {
    HashMap<Integer, List<Character>> digitToLetter = new HashMap<>() {{
        put(2, Arrays.asList('a', 'b', 'c'));
        put(3, Arrays.asList('d', 'e', 'f'));
        put(4, Arrays.asList('g', 'h', 'i'));
        put(5, Arrays.asList('j', 'k', 'l'));
        put(6, Arrays.asList('m', 'n', 'o'));
        put(7, Arrays.asList('p', 'q', 'r', 's'));
        put(8, Arrays.asList('t', 'u', 'v'));
        put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        dfs(digits, res, "", 0);
        return res;
    }

    private void dfs(String digits, List<String> res, String curString, int index) {
        if (index == digits.length()) {
            res.add(curString);
            return;
        }
        List<Character> chars = digitToLetter.get(digits.charAt(index) - '0');
        for (char c : chars) {
            dfs(digits, res, curString + c, index + 1);
        }
    }
}