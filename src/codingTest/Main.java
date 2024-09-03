package codingTest;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.util.*;

public class Main {
    static int staticIndex = 0 ;

    public static void main(String args[]) {
        int n = 6;
        int sum = 0;

        for(int i = 1 ; i <= n -1; i++){
            sum += (n-i );
        }

        System.out.println(sum);

    }

    static class Node {
        public Node left ;
        public Node right ;

        public Node() {

        }

        void addNode(Node node) {
            if(node.left != null) {
                node.right = new Node();
            } else {
                node.left = new Node();
            }
        }

        public Node addNode() {
            return new Node() ;
        }
    }

}













