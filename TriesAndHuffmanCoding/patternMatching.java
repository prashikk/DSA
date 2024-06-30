package TriesAndHuffmanCoding;
import java.util.*;
/*Problem statement
Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
de
Sample Output 1 :
true
Sample Input 2 :
4
abc def ghi hg
hi
Sample Output 2 :
true
Sample Input 3 :
4
abc def ghi hg
hif
Sample Output 3 :
false */
public class patternMatching {
    public class Trie {

        private TrieNode root;
        public int count;
        public Trie() {
            root = new TrieNode('\0');
        }
    
        public boolean search(String word){
            return search(root, word);
        }
    
        private boolean search(TrieNode root, String word) {
            if(word.length() == 0){
                return true;
            }
            int childIndex = word.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
            if(child == null){
                return false;
            }
            return search(child, word.substring(1));
        }
    
      private void add(TrieNode root, String word){
            if(word.length() == 0){
                root.isTerminating = true;
                return;
            }		
            int childIndex = word.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
            if(child == null){
                child = new TrieNode(word.charAt(0));
                root.children[childIndex] = child;
                root.childCount++;
            }
            add(child, word.substring(1));
        }
    
        public void add(String word){
            add(root, word);
        }
    
        public boolean patternMatching(ArrayList<String> vect, String pattern) {
            // Write your code here
            for (int i = 0; i < vect.size(); i++) {
            String word = vect.get(i); 
            for (int j = 0; j < word.length(); j++) {
                add(word.substring(j)); }}
            // for(int i=0;i<vect.size();i++)
            // {   
            //  int j=1;
            //  while(j<vect.get(i).length()){
            //      add(pattern.substring(j));
            //      j++;
            //  }
            // }
            return search(root,pattern);
        }
    
    }
    public static void main(String[] args) {
        // Create an instance of Trie
        patternMatching.Trie trie = new patternMatching().new Trie();

        // Sample input and pattern
        ArrayList<String> words1 = new ArrayList<>();
        words1.add("abc");
        words1.add("def");
        words1.add("ghi");
        words1.add("cba");
        String pattern1 = "de";

        // Test case 1
        boolean result1 = trie.patternMatching(words1, pattern1);
        System.out.println("Pattern \"" + pattern1 + "\" found in words: " + result1); // Expected: true

        // Sample input and pattern
        ArrayList<String> words2 = new ArrayList<>();
        words2.add("abc");
        words2.add("def");
        words2.add("ghi");
        words2.add("hg");
        String pattern2 = "hi";

        // Test case 2
        boolean result2 = trie.patternMatching(words2, pattern2);
        System.out.println("Pattern \"" + pattern2 + "\" found in words: " + result2); // Expected: true

        // Sample input and pattern
        ArrayList<String> words3 = new ArrayList<>();
        words3.add("abc");
        words3.add("def");
        words3.add("ghi");
        words3.add("hg");
        String pattern3 = "hif";

        // Test case 3
        boolean result3 = trie.patternMatching(words3, pattern3);
        System.out.println("Pattern \"" + pattern3 + "\" found in words: " + result3); // Expected: false
    }
}
