package TriesAndHuffmanCoding;
import java.util.*;
/*Problem statement
Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word, which itself is a palindrome or not.


Note: The function should return either true or false. You don't have to print anything.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
Sample Output 1 :
true
Explanation of Sample Input 1:
"abc" and "cba" forms a palindrome
Sample Input 2 :
2
abc def
Sample Output 2 :
false
Explanation of Sample Input 2:
Neither their exists a pair which forms a palindrome, nor any of the words is a palindrome in itself. Hence, the output is 'false.' */
public class palindromePair {
    public class Trie {

        private TrieNode root;
        public int count;
    
        public Trie() {
            root = new TrieNode('\0');
        }
    
        private void add(TrieNode root, String word){
            if(word.length() == 0){
                root.isTerminating = true;
                return;
            }		
    
            int childIndex = word.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
    
            if(child == null) {
                child = new TrieNode(word.charAt(0));
                root.children[childIndex] = child;
                root.childCount++;
            }
    
            add(child, word.substring(1));
        }
    
        public void add(String word){
            add(root, word);
        }
    
        private boolean search(TrieNode root, String word) {
            if(word.length() == 0) {
                return true;
            }
    
            int childIndex=word.charAt(0) - 'a';
            TrieNode child=root.children[childIndex];
    
            if(child == null) {
                return false;
            }
    
            return search(child,word.substring(1));
    
        }
    
        public boolean search(String word) {
            return search(root,word);
        }
    
        private void print(TrieNode root, String word) {
            if (root == null) {
                return;
            }
            
            if (root.isTerminating) {
                System.out.println(word);
            }
            
            for (TrieNode child : root.children) {
                if (child == null) {
                    continue;
                }
                String fwd = word + child.data;
                print(child, fwd);
            }
        }
        
        public void print() {
            print(this.root, "");
        }
    
    
    
    
    
        /*..................... Palindrome Pair................... */
    
    
        
        public String reverse(String word) {
            
            String xString="";
            for(int i=word.length()-1;i>=0;i--) {
                xString+=word.charAt(i);
            }
            return xString;
            
        }
        public boolean isPalindromePair(ArrayList<String> words) {
            
            for(int i=0;i<words.size();i++) {
                
                String string = reverse(words.get(i));
                
                Trie suffixTrie = new Trie();
                for(int j=0;j<string.length();j++) {
                    suffixTrie.add(string.substring(j));
                }
                for(String word : words) {
                    if(suffixTrie.search(word)) {
                        return true;
                    }
                }
                
                
            }
            return false;
            
        }
    
    
        
    } 
    public static void main(String[] args) {
        // Create an instance of Trie
        palindromePair.Trie trie = new palindromePair().new Trie();

        // Sample input
        ArrayList<String> words1 = new ArrayList<>();
        words1.add("abc");
        words1.add("def");
        words1.add("ghi");
        words1.add("cba");

        // Test case 1
        boolean result1 = trie.isPalindromePair(words1);
        System.out.println("Are there any palindrome pairs? " + result1); // Expected: true

        // Sample input
        ArrayList<String> words2 = new ArrayList<>();
        words2.add("abc");
        words2.add("def");

        // Test case 2
        boolean result2 = trie.isPalindromePair(words2);
        System.out.println("Are there any palindrome pairs? " + result2); // Expected: false
    }
}
