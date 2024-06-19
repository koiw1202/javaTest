package interfaceTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-19        koiw1       최초 생성
 */
public class MainJob implements MainSubInterface {

    @Override
    public void doMain() {
        System.out.println("doMain Job");
    }

    @Override
    public void doMainSub() {
        System.out.println("doMain Sub Job");
    }
}
