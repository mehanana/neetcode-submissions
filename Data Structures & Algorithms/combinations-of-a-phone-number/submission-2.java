class Solution {
    HashMap<Character, List<String>> digitToLetter = new HashMap<>();
    public Solution() {
        digitToLetter.put('2', Arrays.asList("a","b","c"));
        digitToLetter.put('3', Arrays.asList("d","e","f"));
        digitToLetter.put('4', Arrays.asList("g","h","i"));
        digitToLetter.put('5', Arrays.asList("j","k","l"));
        digitToLetter.put('6', Arrays.asList("m","n","o"));
        digitToLetter.put('7', Arrays.asList("p","q","r","s"));
        digitToLetter.put('8', Arrays.asList("t","u","v"));
        digitToLetter.put('9', Arrays.asList("w","x","y","z"));
    }

    public List<String> letterCombinations(String digits) {
        /*
        - make map of digit to list of string of letters it represents
        - for each digit, can choose 1 of the (3) letters
        */
        if (digits.length() == 0) {
            return new ArrayList();
        }
        List<String> res = new ArrayList();
        backtrack(res, "", digits, 0);
        return res;
        
    }

    private void backtrack(List<String> res, String cur, String digits, int index) {
        if (index >= digits.length()) {
            res.add(cur);
            return;
        }
        List<String> strings = digitToLetter.getOrDefault(digits.charAt(index), new ArrayList());
        for (int j = 0; j < strings.size(); j++) {
            backtrack(res, cur + strings.get(j), digits, index+1);
        }
    }
}
