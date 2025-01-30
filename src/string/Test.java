package string;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-31        koiw1       최초 생성
 */
public class Test {

    public static String transFormTest(String s) {
        return "transFormTest" ;
    }

    public static void main(String args[]){
        String s = "123" ;
        System.out.println(s.transform(Test::transFormTest)) ;
        String output = """
                        Name: %s
                        Phone: %s
                        """.formatted("test", "01012341234") ;

        System.out.println(output);

        switch (s) {
            case "1", "2", "3" -> System.out.println("1,2,3") ;
            case "4", "5", "123" -> System.out.println("4,5,123") ;
        }
    }


}
