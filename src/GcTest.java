import stream.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-18        koiw1       최초 생성
 */
public class GcTest {



    public static  void  main(String args[]){

        Person p1 = new Person("123");
        Person p2 = new Person("123");
        Person p3 = p1;

        if(p1.equals(p2)) {
            System.out.println("1");
        }

        if(p1.equals(p3)) {
            System.out.println("2");
        }


    }
}