import java.util.HashMap;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-12        koiw1       최초 생성
 */
public class A {

    public static void main(String args[]) {
        B b = new B();

        b.map = new HashMap<>();
        GcTest gcTest = new GcTestChild();


        b.map.put("gcTest", gcTest);

        System.out.println(b.map.get("gcTest").getClass().getName());

        GcTestChild gcTestChild = (GcTestChild) b.map.get("gcTest");




    }
}