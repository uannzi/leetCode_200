package LeetCode_200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class D7_connect {
    Node last = null, nextStart = null;
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node start = root;
        while (start != null){
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next){
                if(p.left != null){
                    handle(p.left);
                }
                if(p.right != null){
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    private void handle(Node p) {
        if(last != null){
            last.next = p;
        }
        if(nextStart == null){
            nextStart = p;
        }
        last = p;
    }
}
