package stream;

import PackageTest.a.b.c.Package2;

import java.util.List;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-22        koiw1       최초 생성
 */
public class StreamTest {
    static List<Person> list = List.of(new Person("김성훈"), new Person("정혜미"), new Person("김성훈"), new Person("1")) ;

    public static void main(String args[]) {

        list.stream()
            .forEach(v -> {
                
            }) ;

//        list.stream().forEach(System.out::println) ;

    }
}
