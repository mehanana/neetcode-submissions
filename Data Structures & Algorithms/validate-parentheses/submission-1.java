class Solution {
    public boolean isValid(String s) {
        /*
        - if it's an open parenthesis, add it to the list
        - if we see a closed one, we check if teh last item in the list is a matching open
            - if it's not, we return false
            - if it is, pop it and keep going through list
        - at the end return list.size() == 0
        */

        Stack<Character> pars = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                pars.add(c);
            } else if (pars.isEmpty()) {
                return false;
            } else {
                if (c == '}') {
                    if (pars.peek() != '{') {
                        return false;
                    } else {
                        pars.pop();
                    }

                } else if (c == ']') {
                    if (pars.peek() != '[') {
                        return false;
                    } else {
                        pars.pop();
                    }
                    
                } else if (c == ')') {
                    if (pars.peek() != '(') {
                        return false;
                    } else {
                        pars.pop();
                    } 
                }
            }

        }

        return pars.size() == 0;
        
    }
}
