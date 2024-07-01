package collections;

import java.util.*;

public class Main {

    public static void main(String args[]) {
//        List<String> list2 = List.of("1","2","3") ; // List.of 또한 불변 List를 반환함
//        List<String> list2 = new ArrayList<>() ;
//        List<String> list = Collections.unmodifiableList(list2) ; // 불변 List 선언

//        List<String> list3 = new ArrayList<>() ;
//        list3.add("1") ;

//        List<String> list4 = Collections.unmodifiableList(list3) ; // 불변 List 선언
//        list2.add("4") ; // --> 에러 발생

//        list2.stream().forEach(System.out::println) ;

        listFromTrustedArray("1", "2") ;

    }

    static <E> List<E> listFromTrustedArray(Object... input) {
        assert input.getClass() == Object[].class;

        for (Object o : input) { // implicit null check of 'input' array
            Objects.requireNonNull(o);
        }

        return null ;

//        return switch (input.length) {
//            case 0  -> (List<E>) ImmutableCollections.EMPTY_LIST;
//            case 1  -> (List<E>) new ImmutableCollections.List12<>(input[0]);
//            case 2  -> (List<E>) new ImmutableCollections.List12<>(input[0], input[1]);
//            default -> (List<E>) new ImmutableCollections.ListN<>(input, false);
//        };
    }
}














