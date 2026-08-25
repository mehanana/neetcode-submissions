class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        /*
        i12n
        implementation
        - go through each string
        - if the char matches, increase both indexes by 1
        
        - if the char in abbr is a number, check if its 0 (return false) and then keep increasing index until number ends
        - move wrod index by number amount
        - check if char at that value matches the next char in abbr
        */
        List<Character> numbers = new ArrayList(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));

        int wordIndex = 0;
        int abbrIndex = 0;
        
        while (wordIndex < word.length() && abbrIndex < abbr.length()) {
            if (numbers.contains(abbr.charAt(abbrIndex))) {
                if (abbr.charAt(abbrIndex) == '0') {
                    return false;
                }
                int endIndex = abbrIndex;
                while (endIndex < abbr.length() && numbers.contains(abbr.charAt(endIndex))) {
                    endIndex++;
                }

                int digits = Integer.parseInt(abbr.substring(abbrIndex, endIndex));
                wordIndex = wordIndex + digits;
                abbrIndex = endIndex;
            } else {
                if (word.charAt(wordIndex) != abbr.charAt(abbrIndex)) {
                    return false;
                }
                abbrIndex++;
                wordIndex++;
            }

            
        } 

        System.out.print(wordIndex + " " + abbrIndex);

        if ((abbrIndex == abbr.length() && wordIndex == word.length())) {
            return true;
        } else {
            return false;
        }
        
    }
}