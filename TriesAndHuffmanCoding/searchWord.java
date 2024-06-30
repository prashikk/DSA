package TriesAndHuffmanCoding;
/*Problem statement
Implement the function Search for the Trie class.

For a Trie, write the function for searching a word. Return true if the word is found successfully, otherwise return false.

Note : main function is given for your reference which we are using internally to test the code. */
public class searchWord {
    public class Trie {

        private TrieNode root;
        public int count;
        public Trie() {
            root = new TrieNode('\0');
        }
    
              private boolean search(TrieNode root,String word){
            if(word.length()==0)
            {
                if(root.isTerminating==true)
                    return true;
                else
                    return false;
            }
            boolean ans=false;
            int childIndex=word.charAt(0)-'a';
            TrieNode child=root.children[childIndex];
            // if(child==null)
            //     return false;
            if(child!=null)
                ans=search(child,word.substring(1));
            return ans;
    
    
        }
        public boolean search(String word){
            // Write your code here
                    return search(root,word);
    
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
    }

    public static void main(String[] args) {
          // Create an instance of searchWord to access the Trie class
          searchWord sw = new searchWord();

          // Create a Trie instance using the instance of searchWord
          searchWord.Trie trie = sw.new Trie();
  
          // Add some words to the Trie
          trie.add("hello");
          trie.add("world");
          trie.add("hey");
          trie.add("hi");
  
          // Search for existing and non-existing words
          System.out.println(trie.search("hello")); // Output: true
          System.out.println(trie.search("world")); // Output: true
          System.out.println(trie.search("hey")); // Output: true
          System.out.println(trie.search("hi")); // Output: true
          System.out.println(trie.search("how")); // Output: false
          System.out.println(trie.search("help")); // Output: false
    }
}
