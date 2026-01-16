package com.github.pedrovgs.trie;

import java.util.HashMap;
import java.util.Map;
/**
 * In computer science, a trie, also called digital tree, radix tree or prefix tree
 * is a kind of search tree—an ordered tree data structure used to store a dynamic
 * set or associative array where the keys are usually strings. Unlike
 * a binary search tree, no node in the tree stores the key associated
 * with that node; instead, its position in the tree defines the key with which it is associated.
 * All the descendants of a node have a common prefix of the string associated with that node,
 * and the root is associated with the empty string. Keys tend to be associated with leaves, though
 * some inner nodes may correspond to keys of interest.
**/
/**
 * @author Kashish Soni.
 */

public class Trie {
    public boolean isEndOfWord;         // used to checkif a string ends here
    public Map<Character, Trie> m;

    public Trie() {
        m = new HashMap<Character, Trie>();     // Hashmap used to link char values to Trie Nodes
    }

    public Trie trieCreateNode() {
        Trie t = new Trie();
        t.isEndOfWord = false; // End of Word false by default
        return t;
    }

    public void insertIntoTrie(Trie root, String s) { // Function to insert a String into the Trie
        for (int i = 0; i < s.length(); i++) {
            if (!root.m.containsKey(s.charAt(i))) { // Checks if The Trie already contains that character or not
                root.m.put(s.charAt(i), new Trie()); // if not then create a new node for that character
            }
            root = root.m.get(s.charAt(i)); // root iterates through the trie
        }
        root.isEndOfWord = true; // denotes end of a string/pattern
    }

    public boolean searchInTrie(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(root.m.containsKey(s.charAt(i)))) { // if a node does not exist in the trie
                return false; // then return not found
            }
            root = root.m.get(s.charAt(i));
        }
        if (root.isEndOfWord) {    // The pattern may exist partially in // <- |
            return true;           // another pattern but this does not  // <- | Can be removed to
        }                          // mean that the search is complete as// <- | implement pattern in pattern search
        return false;              // word endings may not match         // <- | change to  return true;
    }

}
