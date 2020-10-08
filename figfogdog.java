class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int steps = 0;
        
        for(String wordl : wordList){
            int counter = 0;
            for(int i=0;i<beginWord.length();i++){
                char currentLetter = beginWord.charAt(i);
                char wordListLetter = wordl.charAt(i);
                
                if(currentLetter == wordListLetter){
                    //do nothing
                } else {
                    counter++;
                }
            }
            
            if(counter == 1){
                beginWord = wordl;
                steps++;
            }
            
            if(wordl == endWord){
                return steps;
            }
        }
        return steps;
    }
}
