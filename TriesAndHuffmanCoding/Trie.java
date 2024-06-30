package TriesAndHuffmanCoding;
import java.util.*;

public class Trie {
     
    private TrieNode root;
    
    // TrieNode represents each node in the Trie
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        
        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
    public Trie() {
        root = new TrieNode();
    }
    
    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            
            current = node;
        }
        
        // Mark the end of the word
        current.isEndOfWord = true;
    }
    
    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            
            if (node == null) {
                return false; // Not found
            }
            
            current = node;
        }
        
        // Check if the end of the word is reached
        return current.isEndOfWord;
    }
    
    // Delete a word from the Trie
    public void delete(String word) {
        delete(root, word, 0);
    }
    
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            // When end of word is reached, only delete if current node is end of word
            if (!current.isEndOfWord) {
                return false; // Word not found in Trie
            }
            
            current.isEndOfWord = false; // Unmark the end of word
            return current.children.size() == 0; // Return true if no more children
        }
        
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false; // Word not found in Trie
        }
        
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
        
        // Delete the node if it's marked for deletion
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");
        
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("banana")); // true
        System.out.println(trie.search("orange")); // true
        System.out.println(trie.search("grape")); // false
        
        trie.delete("banana");
        System.out.println(trie.search("banana")); // false
    }
}
