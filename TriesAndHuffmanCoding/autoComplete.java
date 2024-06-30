package TriesAndHuffmanCoding;
import java.util.*;
/*Problem statement
Given n number of words and an incomplete word w. You need to auto-complete that word w.

That means, find and print all the possible words which can be formed using the incomplete word w.

Note : Order of words does not matter.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
7
do dont no not note notes den
no
Sample Output 1 :
no
not
note
notes
Sample Input 2 :
7
do dont no not note notes den
de
Sample Output 2 :
den
Sample Input 3 :
7
do dont no not note notes den
nom
Sample Output 3 :
(Empty) There is no word which starts with "nom" */
public class autoComplete {
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
        
        
        public void autoComplete(ArrayList<String> input, String word) {
    
            // Write your code here
                int i=0; 
            while(i<input.size()){
                String a=input.get(i);
                add(root,a); 
                i++;
             }  
            if(root == null || root.childCount == 0) { 
                return;
            }
           TrieNode a=findword(root,word);
            String output = ""; 
            allwords(a,word,output); 
    
        }
           public void allwords(TrieNode root,String word,String output){
               if(root == null){
                   return;
               }
               
            if(root!=null && root.childCount == 0) { 
                if(output.length() > 0) {
                    System.out.println(word + output); 
                }
                return; 
            }
            if(root!=null && root.isTerminating == true) {
                System.out.println(word + output);
            }
    
            for(int i = 0; i < root.children.length; i++) {
                if(root.children[i] != null) {
                    String ans = output + root.children[i].data; 
                    allwords(root.children[i],word,ans);
                }
           }
        }
           public TrieNode findword(TrieNode root, String word) { 
            if(word.length() == 0){
                return root;
            }
            int childIndex = word.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
            if(child == null){
                return null; 
            }
            return findword(child, word.substring(1));
        } 
    }
    public static void main(String[] args) {
        // Create an instance of Trie
        autoComplete.Trie trie = new autoComplete().new Trie();

        // Sample input
        ArrayList<String> words1 = new ArrayList<>();
        words1.add("do");
        words1.add("dont");
        words1.add("no");
        words1.add("not");
        words1.add("note");
        words1.add("notes");
        words1.add("den");

        // Test case 1
        String prefix1 = "no";
        System.out.println("Autocompleting for prefix '" + prefix1 + "':");
        trie.autoComplete(words1, prefix1);

        System.out.println();

        // Sample input
        ArrayList<String> words2 = new ArrayList<>();
        words2.add("do");
        words2.add("dont");
        words2.add("no");
        words2.add("not");
        words2.add("note");
        words2.add("notes");
        words2.add("den");

        // Test case 2
        String prefix2 = "de";
        System.out.println("Autocompleting for prefix '" + prefix2 + "':");
        trie.autoComplete(words2, prefix2);

        System.out.println();

        // Sample input
        ArrayList<String> words3 = new ArrayList<>();
        words3.add("do");
        words3.add("dont");
        words3.add("no");
        words3.add("not");
        words3.add("note");
        words3.add("notes");
        words3.add("den");

        // Test case 3
        String prefix3 = "nom";
        System.out.println("Autocompleting for prefix '" + prefix3 + "':");
        trie.autoComplete(words3, prefix3);
    }
}
