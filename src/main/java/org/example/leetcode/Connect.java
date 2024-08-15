package org.example.leetcode;

import org.example.configuration.Node;

import java.util.*;

/**
 * @Date 2024/8/9
 * @Author zhang
 * If any question, please mail infozyw@gmail.com
 **/
public class Connect {
    public static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2, new Node(4, null, null, null), new Node(5, null, null, null), null),
                new Node(3, null, new Node(7, null, null, null), null), null);
        Node result = connect(root);
        Integer[] pp = new Integer[10];
        List<Integer> other = Arrays.asList(pp);
    }
}
