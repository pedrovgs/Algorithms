package com.github.pedrovgs.trie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Kashish Soni.
 */

public class TrieTest {
    @Before
    public void setUp() {
        new TrieTest();
    }
    @Test public void shouldReturnTrueIfStringIsFound() {
        ArrayList<String> s = new ArrayList<String>();
        s.add("Kashish");
        s.add("Pedro");
        s.add("Lorem");
        s.add("ipsum");
        s.add("dolor");
        s.add("sit");
        s.add("amet");
        trie root = new trie();
        for (int i = 0; i < s.size(); i++) {
            root.insertIntoTrie(root, s.get(i));
        }
        assertTrue(root.searchInTrie(root, "Kashish"));
    }
    @Test public void shouldReturnTrueIfStringIsFound1() {
        String s = "Kashish Kashisk Lorem ipsum dolor dolo sit si amrt amet";
        String[] arr = s.split(" ");
        trie root = new trie();
        for (int i = 0; i < arr.length; i++) {
            root.insertIntoTrie(root, arr[i]);
        }
       // System.out.println("Code checking");
        assertTrue(root.searchInTrie(root, "Kashish"));
        assertTrue(root.searchInTrie(root, "Kashisk"));
        assertFalse(root.searchInTrie(root, "Kashis"));
        assertTrue(root.searchInTrie(root, "dolo"));
    }
}