package memoryTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-31        koiw1       최초 생성
 */
public class Main {

    public static void main(String args[]) {

        MemoryObj1Impl MemoryObj1Impl = new MemoryObj1Impl() ;
        MemoryObj2Impl MemoryObj2Impl = new MemoryObj2Impl() ;

        for(int i = 0 ; i < 1000000000; i++){
            MemoryObj obj1 = MemoryObj1Impl ;
            System.out.println(obj1);

            MemoryObj obj2 = MemoryObj2Impl ;
            System.out.println(obj2);

        }

        System.out.println("123");

    }

}
