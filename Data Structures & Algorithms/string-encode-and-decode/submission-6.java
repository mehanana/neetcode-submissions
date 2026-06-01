class Solution {
    /*
    - length of string, followed by the string, followed by a period (to show that the string ended)
    */

    public String encode(List<String> strs) {
        String res = "";
        for (String str : strs) {
            res = res + str.length() + "." + str;
        }
        return res;

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            String curLength = "";
            while (str.charAt(index) != '.') {
                curLength = curLength+str.charAt(index);
                index++;
            }
            index++;
            int length = Integer.parseInt(curLength);
            String cur = str.substring(index, index+length);
            index = index+length;
            res.add(cur);
        }
        
        return res;

    }
}
