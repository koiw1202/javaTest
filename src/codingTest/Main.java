package codingTest;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        Solution2 solution2 = new Solution2();
//        int answer = solution2.solution(28, 18, 26, 10, 8, new int[]{0, 0, 1, 1, 1, 1, 1});
        int answer = solution2.solution(11,8,10,10,1, new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1});

        System.out.println(answer);
    }
}













