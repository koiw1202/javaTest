package funtionalInterface;

import java.sql.SQLOutput;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws Exception {

        String str = "TEST" ;

        Predicate<String> predicate = (String s) -> s.equals("TEST") ;

        System.out.println(predicate.test(str)) ;
        System.out.println(predicate.test("232332")) ;

        Consumer<String> consumer = (String s) -> {
            System.out.println(s);
        } ;

        consumer.accept(str) ;

        Supplier<String> s = () -> {

            return "123" ;
        } ;

        s.get() ;


    }
}
















