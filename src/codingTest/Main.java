package codingTest;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        PerfectCrime perfectCrime = new PerfectCrime();

        System.out.println(perfectCrime.solution(new int[][]{{1,2}, {2,3}, {2,1}},4,4));

    }
}













