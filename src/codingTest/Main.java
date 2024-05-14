package codingTest;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static int staticIndex = 0 ;

    public static void main(String args[]) {
        int cnt = 5 ;
        int cntTemp = cnt ;


        Node node = new Node()  ;

        Queue<Node> que = new LinkedList<>() ;
        Queue<Node> tempQueue = new LinkedList<>() ;
        Stack<Node> stack = new Stack<>();

        que.add(node) ;
        tempQueue.add(node) ;
        stack.add(node) ;

        while(cntTemp > 0) {

            Node tempNode = tempQueue.poll() ;

            tempNode.left = new Node() ;
            cntTemp-- ;

            tempQueue.add(tempNode.left) ;
            que.add(tempNode.left) ;
            stack.add(tempNode.left) ;

            if(cnt <= 0) {
                break ;
            }

            tempNode.right = tempNode.addNode() ;
            cntTemp-- ;

            tempQueue.add(tempNode.right) ;
            que.add(tempNode.right) ;
            stack.add(tempNode.right) ;
        }

        while (!stack.isEmpty()) {
            Node tempNode1 = stack.pop() ;

            System.out.println(tempNode1) ;

            if(!stack.isEmpty()) {
                Node tempNode2 = stack.pop() ;
                tempNode2 = null ;
                System.out.println(tempNode2) ;

            }

            tempNode1 = null ;
        }

        System.out.println() ;
        System.out.println(node.left.right) ;

    }

    static class Node {
        public Node left ;
        public Node right ;
        public int index ;

        public Node() {
            this.index = staticIndex++ ;
        }

        public Node addNode() {
            return new Node() ;
        }
    }

}













