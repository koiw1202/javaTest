package OptionalTest;

import java.util.Optional;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-17        koiw1       최초 생성
 */
public class OptionalTest {
    public static void main(String args[]) throws Exception {

        String str = "" ;

        Optional.ofNullable(str)
                        .filter(s -> !s.isEmpty())
                                .orElseThrow(() -> new Exception("공백")) ;

         System.out.println(Optional.ofNullable(str).orElse("123")) ;
    }
}
