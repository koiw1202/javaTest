package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-01        koiw1       최초 생성
 */
public class Main {

    static List<String> list= new ArrayList<>();

    public static void dfs(int depth, String[] arr, String str, boolean[] visited) {
        if(depth == arr.length) {
            list.add(str);
            return;
        }

        String result = str;
        for(int i=0; i < arr.length; i++) {
            if( ! visited[i]) {
                dfs(depth + 1, arr, str + arr[i], visited);
            }
        }
    }

    public static void main(String args[]) {
        dfs(0, new String[]{"1","2","3"}, "", new boolean[3]);

        for(String str: list){
            System.out.println(str);
        }



    }
}