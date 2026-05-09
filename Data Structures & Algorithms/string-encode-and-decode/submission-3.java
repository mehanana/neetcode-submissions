class Solution {

    public String encode(List<String> strs) {
        // add period at the end of each string
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()+"#");
            sb.append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        // while you don't see a #, keep track of the number
        // after reaching the #, add that many chars to string and save in result list
        // keep going until you reach end of string
        int num = 0;
        String number = "";
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            int len = 0;
            while (str.charAt(j) != '#') {
                int d = str.charAt(j)-'0';
                len=len*10+d;
                j++;
            }
            j++;
            String s = str.substring(j, j+len);
            i = j+len;
            result.add(s);
        }

        return result;
/*
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
*/
    }
}
