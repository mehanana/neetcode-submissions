class Solution {

    public String encode(List<String> strs) {
        // add period at the end of each string
        String result = "";
        for (String s : strs) {
            result = result + s.length() + "#" + s;
        }

        return result;

    }

    public List<String> decode(String str) {
        // while you don't see a #, keep track of the number
        // after reaching the #, add that many chars to string and save in result list
        // keep going until you reach end of string
        int num = 0;
        String number = "";
        List<String> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i+1).equals("#")) {
                String res = "";
                num = Integer.parseInt(number);
                i++;
                while (num > 0 && i < str.length()) {
                    res = res + str.substring(i, i+1);
                    i++;
                    num--;
                }
                result.add(res);
                number = "";
                i--;

            } else {
                number = number + str.substring(i, i+1);
            }

        }
        return result;

    }
}
