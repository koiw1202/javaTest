package codingTest;

public class Main {
    private static int nodeCnt ;
    private static int answer = 0 ;
    private static int totalIndex = 0 ;
    static class Node {

        private Node left = null ;
        private Node right = null ;
        private int index ;

        private void add(Node node) {
            node.left = new Node() ;
            node.left.index = totalIndex++ ;

            node.right = new Node() ;
            node.right.index = totalIndex++ ;

            nodeCnt += 2 ;

        }

        private void searchLastNode(Node node) {

            //현재 노드가 마지막 인덱스
            if(node.left == null && node.right == null) {
                nodeCnt-- ;

                System.out.println(node.index);

                node = null ;
                answer += nodeCnt ;


            } else if(node.left != null) {
                searchLastNode(node.left);
            } else if(node.right != null) {
                searchLastNode(node.right) ;
            }
        }
    }

    public static void main(String args[]) {
        Node node = new Node() ;
        node.index = totalIndex++ ;

        int depth = 3 ;
        nodeCnt = 1 ;

        for(int i = 1 ; i < depth ; i++) {
            node.add(node) ;
        }

        while(nodeCnt > 2) {
            node.searchLastNode(node) ;
        }

        System.out.println(answer);

    }
}













