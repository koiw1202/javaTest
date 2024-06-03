package packageTest;

import packageTest.a.b.c.Package2;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-22        koiw1       최초 생성
 */
public class PackageTest {
    String test = this.getClass().getPackageName() ;
    static Package2 package2 = new Package2() ;

    public static void main(String args[]) {
        System.out.println(package2.packageName) ;
    }
}
