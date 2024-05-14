package fieldReflectionTest;

import java.lang.reflect.Field;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        DtoA a = new DtoA() ;
        DtoB b = new DtoB() ;

        a.setName("A TEST") ;
        a.setNum(10) ;

        reflectionTest(a,b) ;

        System.out.println(b.getName()) ;
        System.out.println(b.getNum()) ;

        List<String> listTest = List.of("111", "222", "333") ;
        b.setList(listTest);

        System.out.println(a.getList().get(0));

    }

    public static void reflectionTest(Object obj, Object target) throws Exception {

        Field[] fieldArr = obj.getClass().getDeclaredFields() ;
        Field[] targetField = target.getClass().getDeclaredFields() ;

        for(Field i : targetField) {
            for(Field j : fieldArr) {

                if(j.getName().equals(i.getName())) {
                    i.setAccessible(true) ;
                    j.setAccessible(true) ;

                    i.set(target, j.get(obj)) ;
                }
            }
        }
    }
}
















