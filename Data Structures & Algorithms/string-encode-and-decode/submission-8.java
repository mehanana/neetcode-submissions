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
        List<String> res = new ArrayList();
        int index = 0;
        while (index < str.length()) {
            int endIndex = index;
            while (str.charAt(endIndex) != '.') {
                endIndex++;
            }
            int length = Integer.parseInt(str.substring(index, endIndex));
            index = endIndex+1;
            res.add(str.substring(index, index+length));
            index = index+length;
        }


        return res;
    }
}
