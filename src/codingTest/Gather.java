package codingTest;

public class Gather {

    static final String[] str = {"A", "E", "I", "O", "U"};
    static int answer = 0;
    static boolean end = false;

    public static void main(String args[]) {

//        "AAAAE"	6
//        "AAAE"	10
//        "I"	1563
//        "EIO"	1189
        String word = "AAAE";
        dfs("", 1, word);
        System.out.println(answer);

    }

    public static void dfs(String target, int depth, String word) {

        if(word.equals(target)) {
            end = true;
        }

        if( ! end) answer++;

        if(target.length() == 5) {
            return;
        }

        for(int i=0; i < str.length; i++) {

            dfs(target + str[i], depth + 1, word);

        }
    }

}
