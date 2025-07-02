import string.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-18        koiw1       최초 생성
 */

public class GcTest {

    public static  void  main(String args[]){

        List<String> list = new ArrayList<>();
        list.add("123");
        Queue que = new LinkedList();
        que.add(list);

        list.remove(0);

        List<String> list2 = (ArrayList) que.poll();
        System.out.println(list2.get(0));


    }




}
