class Solution {
    HashMap<Character, List<Character>> graph = new HashMap<>();
    HashMap<Character, Boolean> visited;
    List<Character> result;
    
    public String foreignDictionary(String[] words) {
        /*
        first and second word, see what's the first letter that's differnt and you know that it's f1Letter < f2Letter
        hashmap<String, List<String>>
        - key = curLetter
        - List<String> are the letters that come after it
        - after iterating through the words, go through the hashmap and for each string in the list, add it after the current string, but then dfs through that to see if it has any followers.
            - or maybe iterate through until you reach base case and then build from there
        - if a is a prefix of b, there's not much sorting we can do i think
        
        n -> f
        h -> e
        r -> n
        e -> r

       h -> e -> r -> n -> f
        */

        // put all chars into hashmap
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }  
        }
            
        
        // go through the words and put in the differences into hashmap
        for (int i = 0; i < words.length-1; i++)  {
            String firstWord = words[i];
            String secondWord = words[i+1];
            Character difference;
            int minLen = Math.min(firstWord.length(), secondWord.length());
            if (firstWord.length() > secondWord.length() &&
                firstWord.substring(0, minLen).equals(secondWord.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (firstWord.charAt(j) != secondWord.charAt(j)) {
                    graph.get(firstWord.charAt(j)).add(secondWord.charAt(j));
                    break;
                }
            }
        }

        // iterate through hashmap
        visited = new HashMap<>();
        result = new ArrayList<>();
        for (char c : graph.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        // build the string in reverse
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    public boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);
        for (char next : graph.get(c)) {
            if (dfs(next)) {
                return true;
            }
        }
        visited.put(c, false);
        result.add(c);
        return false;


    }
}
