class Solution {
    HashMap<String, List<String>> wordMap = new HashMap<>();
    Set<String> visited = new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        hashmap : each word to a list of words where 1 letter is changed
        then, start at beginWord, iterate through the list of words and for each word in that, iterate through their list of words (skipping begin word) and keep going until end word is reached
        if all words in list are done and nothing was returned, return 0
        
        bfs cuz we want shortest path
        */
        for (int i = 0; i < wordList.size() + 1; i++) {
            if (i == wordList.size()) {
                wordMap.put(beginWord, new ArrayList<>());
            } else {
                wordMap.put(wordList.get(i), new ArrayList<>());
            }
        }

        for (String wordA : wordMap.keySet()) {
            for (String wordB : wordMap.keySet()) {
                if (oneDiff(wordA, wordB)) {
                    wordMap.get(wordA).add(wordB);
                }
            }
        }

        Queue<String> curWords = new LinkedList<>();
        curWords.add(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!curWords.isEmpty()) {
            int sizeWords = curWords.size();
            for (int i = 0; i < sizeWords; i++) {
                String curWord = curWords.poll();
                for (String word : wordMap.get(curWord)) {
                    if (word.equals(endWord)) return count + 1;
                    if (!visited.contains(word)) {
                        visited.add(word);
                        curWords.add(word);
                    }
                }
            }
            count++;
        }
        return 0;


    }

    private boolean oneDiff(String a, String b) {
    int diff = 0;
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) diff++;
    }
    return diff == 1;
}
}
