package enumTest;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-15        koiw1       최초 생성
 */
public class EnumTest {


    public enum FruitTypeCheck {
         APPLE((param) -> {
             if(param.equals(Fruit.APPLE.getName()))
                 return true ;

             return false ;
         })

        ,GRAPE((param) -> {
            if (param.equals(Fruit.GRAPE.getName()))
                return true;

            return false;
        })
        ;

        FruitTypeCheck(Function function) {
            this.typeCheck = function;
        }
        private Function<Object, Boolean> typeCheck ;
    }

    public enum FruitTypeCheck2 {
        APPLE((param) -> {
            if(param.equals(Fruit.APPLE.getName()))
                return true ;

            return false ;
        })

        ,GRAPE((param) -> {
            if (param.equals(Fruit.GRAPE.getName()))
                return true;

            return false;
        })
        ;

        private Predicate<Object> typeCheck2 ;
        FruitTypeCheck2(Predicate predicate) {
            this.typeCheck2 = predicate ;
        }
    }

    public static void main(String args[]) {
        final String apple = "apple" ;
        final String APPLE = "APPLE" ;

        System.out.println(FruitTypeCheck.APPLE.typeCheck.apply(apple)) ;
        System.out.println(FruitTypeCheck.APPLE.typeCheck.apply(APPLE)) ;


        System.out.println(FruitTypeCheck2.APPLE.typeCheck2.test(apple)) ;
        System.out.println(FruitTypeCheck2.APPLE.typeCheck2.test(APPLE)) ;

    }
}




























