package optionalTest;

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

        String str1 = "" ;
        String str2 = "" ;
        String str3 = "" ;

        Optional.ofNullable(str1)
                .filter(s -> !s.isEmpty())
                    .or(() -> Optional.ofNullable(str2)) ;
//                .orElseThrow(() -> new Exception("공백")) ;

    }

}
