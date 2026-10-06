package Misce;

import java.util.*;

public class BinaryTreeBoundary {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    private static boolean isLeaf(Node node){
        return node != null && node.left == null && node.right == null;
    }

    private static void addLeftBoundary(Node root, List<Node> result){
        Node curr = root.left; 
        while(curr != null){
            if(!isLeaf(curr)){
                result.add(curr);
            }
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    private static void addLeafNodes(Node node, List<Node> result){
        if(node == null) return;
        if(isLeaf(node)){
            result.add(node);
        }

        addLeafNodes(node.left, result);
        addLeafNodes(node.right, result);
    }

    private static void addRightBoundary(Node node, List<Integer> res) {
        Node curr = node.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }
            curr = (curr.right != null) ? curr.right : curr.left;
        }
        // Add bottom-up (reverse order)
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    public static void main(String[] args) {
        
    }
    
}
