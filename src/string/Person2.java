package string;

import java.util.logging.Logger;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-03        koiw1       최초 생성
 */
public class Person2 {

    public Person personBuilder(String name) {
        final Person person ;

        try {
            person = new Person() ;
        } catch(Exception e ) {

        }
        Logger log = Logger.getLogger("TEST") ;

        return person ;
    }

}
