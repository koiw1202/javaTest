package string;

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
    }

}
