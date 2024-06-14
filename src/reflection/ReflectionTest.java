package reflection;

import stream.Person;

import java.lang.reflect.InvocationTargetException;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-15        koiw1       최초 생성
 */
public class ReflectionTest {

    public static void main(String args[]) throws Exception {

        Person person = new Person("1") ;

        Class<?> cls = person.getClass() ;
         cls.getDeclaredConstructor().newInstance() ;

    }
}
