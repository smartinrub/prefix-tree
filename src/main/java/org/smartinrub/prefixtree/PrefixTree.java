package org.smartinrub.prefixtree;

import java.util.ArrayList;
import java.util.List;

public class PrefixTree {

    private TrieNode head;

    private class TrieNode {
        Character letter;
        List<TrieNode> nodes;
    }

    public void addEntry(String prefix) {
        if (head == null) {
            head = new TrieNode();
            head.nodes = new ArrayList<TrieNode>();
        }

        TrieNode tail = head;

        for (int i = 0; i < prefix.length(); i++) {

            boolean found = false;

            for (int j = 0; j < tail.nodes.size(); j++) {
                if (tail.nodes.get(j).letter.equals(prefix.charAt(i))) {
                    tail = tail.nodes.get(j);
                    found = true;
                    break;
                }
            }

            if (!found) {
                TrieNode newTrieNode = new TrieNode();
                newTrieNode.nodes = new ArrayList<TrieNode>();
                newTrieNode.letter = prefix.charAt(i);
                tail.nodes.add(newTrieNode);
                tail = newTrieNode;
            }
        }
    }

    public boolean lookup(String string) {
        TrieNode tail = head;

        for (int i = 0; i < string.length(); i++) {
            if (tail.nodes.size() == 0 ) {
                return true;
            }

            boolean found = false;

            for (int j = 0; j < tail.nodes.size(); j++) {
                if (tail.nodes.get(j).letter.equals(string.charAt(i))) {
                    found = true;
                    tail = tail.nodes.get(j);
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }
        return false;
    }
}