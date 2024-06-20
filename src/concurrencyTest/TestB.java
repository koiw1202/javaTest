package concurrencyTest;

import abstractTest.InterfaceTest;

import java.util.UUID;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-20        koiw1       최초 생성
 */
public class TestB implements InterfaceTest {
    @Override
    public void print1(UUID uuid) {
        System.out.println(uuid + " ==> testB");
    }
}
