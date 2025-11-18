package awtTest;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class BeepTest {

    public static void main(String[] args) {
        // 알림 시점 (밀리초)
        final long FIRST_MS  = Duration.ofMinutes(2).plusSeconds(30).toMillis(); // 2분 30초
        final long SECOND_MS = Duration.ofMinutes(4).toMillis();                 // 4분

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(3);
        Instant start = Instant.now();
        AtomicBoolean finished = new AtomicBoolean(false);

        // 매초 경과 시간 출력 (mm:ss), 마지막에 줄바꿈 정리
        ScheduledFuture<?> ticker = exec.scheduleAtFixedRate(() -> {
            if (finished.get()) return;
            long elapsedMs = Duration.between(start, Instant.now()).toMillis();
            long seconds = elapsedMs / 1000;
            long mm = seconds / 60;
            long ss = seconds % 60;
            System.out.printf("\r경과 시간: %02d:%02d", mm, ss);
            System.out.flush();
        }, 0, 1, TimeUnit.SECONDS);

        // 2분 30초 알림
        exec.schedule(() -> {
            System.out.print("\r"); // 줄 덮어쓰기 제거
            System.out.println("🔔 알림: 2분 30초 경과!");
            beep();
        }, FIRST_MS, TimeUnit.MILLISECONDS);

        // 4분 알림 (마지막)
        exec.schedule(() -> {
            System.out.print("\r");
            System.out.println("🔔 알림: 4분 경과! 프로그램을 종료합니다.");
            beep();
            finished.set(true);
            ticker.cancel(false);
            exec.shutdown();
        }, SECOND_MS, TimeUnit.MILLISECONDS);

        // Ctrl+C 등으로 종료 시 정리
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            finished.set(true);
            ticker.cancel(true);
            exec.shutdownNow();
            System.out.println("\n종료되었습니다.");
        }));
    }

    private static void beep() {
        try {
            java.awt.Toolkit.getDefaultToolkit().beep(); // GUI 환경에서 시스템 비프음
        } catch (Throwable t) {
            // GUI 없는 환경이면 콘솔 벨 문자 시도
            System.out.print("\007");
            System.out.flush();
        }
    }

}
