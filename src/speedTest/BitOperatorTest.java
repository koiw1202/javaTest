package speedTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-27        koiw1       최초 생성
 */
public class BitOperatorTest {

    // 1.529
//    public static void main(String argsp[]) {
//
//        long stTime = System.currentTimeMillis();
//
//        int[] arr = new int[1000000000];
//
//        for(long i = 0 ; i < 1000000000; i++) {
//            arr[(int) i] = 3/2;
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println( (double) (endTime - stTime) / 1000 );
//    }

    // 1.533
    public static void main(String argsp[]) {

        long stTime = System.currentTimeMillis();

        int[] arr = new int[1000000000];

        for(long i = 0 ; i < 1000000000; i++) {
            arr[(int) i] = 3 >>> 1;
        }

        long endTime = System.currentTimeMillis();
        System.out.println( (double) (endTime - stTime) / 1000 );

    }
}