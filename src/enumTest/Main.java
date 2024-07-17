package enumTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-17        koiw1       최초 생성
 */
public class Main {

    public static void main(String args[]) throws Exception {
        InterfaceTest interfaceTest = new InterfaceTestImpl() ;
        paramTest(interfaceTest.getClass(), interfaceTest) ;
    }

    public static void paramTest(Class<? extends InterfaceTest> interfaceTest, InterfaceTest interfaceTest2) throws Exception {
        Method method = interfaceTest.getMethod("print") ;
        method.setAccessible(true) ;
        method.invoke(interfaceTest2) ;
    }


}
