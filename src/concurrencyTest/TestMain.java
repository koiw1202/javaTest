package concurrencyTest;

import abstractTest.InterfaceTest;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-20        koiw1       최초 생성
 */
public class TestMain {

    static InterfaceTest interfaceTest ;

    static AtomicInteger aI = new AtomicInteger(1) ;

    public static void main(String args[]) {
        List<CompletableFuture> list = new ArrayList<>() ;

        for(int i = 0 ; i < 1000 ; i++) {
            list.add(
                CompletableFuture.runAsync(() -> {
                    UUID uuid = UUID.randomUUID();

                    if(aI.getAndIncrement() % 2 == 0) {
                        interfaceTest = new TestA() ;
                        System.out.println(uuid + " => AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                        interfaceTest.print1(uuid);
                    }else {
                        interfaceTest = new TestB() ;
                        System.out.println(uuid + " => BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                        interfaceTest.print1(uuid);
                    }
                })
            ) ;
        }

        for(CompletableFuture com : list)
            com.join() ;



    }
}
