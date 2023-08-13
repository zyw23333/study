package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode hot-100 208
 */
public class Trie {
    Node root;
    class Node {
        char value;
        List<Node> child;

        Node() {
            child = new ArrayList<>();
        }
        Node(char value) {
            this.value = value;
            child = new ArrayList<>();
        }
    }
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            boolean flag = true;
            for (Node temp : curr.child) {
                if (temp.value == c) {
                    flag = false;
                    curr = temp;
                    break;
                }
            }
            if (flag) {
                Node temp = new Node(c);
                curr.child.add(temp);
                curr = temp;
            }
        }
        curr.child.add(new Node('#'));
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            boolean flag = true;
            for (Node temp : curr.child) {
                if (temp.value == c) {
                    flag = false;
                    curr = temp;
                    break;
                }
            }
            if (flag) {
                return false;
            }
        }
        boolean flag = false;
        for (Node temp : curr.child) {
            if (temp.value == '#') {
                flag = true;
            }
        }
        return flag;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            boolean flag = true;
            for (Node temp : curr.child) {
                if (temp.value == c) {
                    flag = false;
                    curr = temp;
                    break;
                }
            }
            if (flag) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie test = new Trie();
        test.insert("abc");
        System.out.println(test.startsWith("ab"));
        System.out.println(test.search("abcd"));
    }
}
