package exception;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-15        koiw1       최초 생성
 */
public class ExceptionTest {

    public static void main(String[] args) throws Exception {

        try {
            System.out.println(3/0);

        } catch (Exception e) {
            throw e;
        }
    }
}


