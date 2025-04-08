package completableFuture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-01        koiw1       최초 생성
 */
public class Main {

    public static void main(String args[]) throws IOException {

        List<CompletableFuture> list = new ArrayList<>();

        for(int i = 0; i < 1000; i++) {
            list.add(CompletableFuture.runAsync(() -> {

                System.out.println(Thread.currentThread() + " 실행");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        for(CompletableFuture completableFuture : list) {
            completableFuture.join();
        }
    }
}
