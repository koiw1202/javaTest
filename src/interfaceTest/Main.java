package interfaceTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-19        koiw1       최초 생성
 */
public class Main {

    public static void main(String args[]) {
        MainInterface mi = new MainJob() ;
        mi.doMain() ;

        MainSubInterface msi = new MainJob() ;
        msi.doMainSub() ;
        msi.doMain() ;



    }
}
