package awtTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AlertTimerGUI extends JFrame {

    private JLabel timeLabel;
    private JLabel infoLabel;

    // 경과 시간(초)
    private int elapsedSeconds = 0;

    // 사용할 사운드 파일 경로 (프로젝트 폴더에 alarm.wav 라고 저장했다고 가정)
    private static final String ALARM_SOUND_PATH = "C:\\Users\\koiw1\\Desktop\\alarm.wav";

    // 15분 = 900초
    private static final int ALARM_LIMIT_SECONDS = 900;

    public AlertTimerGUI() {
        setTitle("타이머 알람 (30초마다, 15분까지)");
        setSize(320, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙 배치

        initUI();
        startTimer();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        timeLabel = new JLabel("경과 시간: 00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Dialog", Font.BOLD, 20));

        infoLabel = new JLabel("30초마다 알람, 15분 이후에는 알람 없음", SwingConstants.CENTER);

        add(timeLabel, BorderLayout.CENTER);
        add(infoLabel, BorderLayout.SOUTH);
    }

    private void startTimer() {
        int delay = 1000; // 1초
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                updateTimeLabel();
                checkAlarms();
            }
        });
        timer.start();
    }

    private void updateTimeLabel() {
        int hours = elapsedSeconds / 3600;
        int minutes = (elapsedSeconds % 3600) / 60;
        int seconds = elapsedSeconds % 60;

        String timeStr = String.format("경과 시간: %02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(timeStr);
    }

    private void checkAlarms() {
        // 15분(900초) 이후에는 알람 X
        if (elapsedSeconds > ALARM_LIMIT_SECONDS) {
            return;
        }

        // 0초는 제외, 30초 단위로 알람
        if (elapsedSeconds > 0 && elapsedSeconds % 30 == 0) {
            String msg = String.format("알람! (경과: %02d:%02d:%02d)",
                    elapsedSeconds / 3600,
                    (elapsedSeconds % 3600) / 60,
                    elapsedSeconds % 60);
            fireAlarm(msg);
        }
    }

    private void fireAlarm(String message) {
        // 사운드 재생 (WAV 기준)
        playSound(ALARM_SOUND_PATH);
    }

    /**
     * WAV 사운드 파일 재생
     */
    private void playSound(String filePath) {
        // 사운드 재생은 별도 스레드에서 실행 (GUI 멈추지 않게)
        new Thread(() -> {
            File soundFile = new File(filePath);
            if (!soundFile.exists()) {
                System.err.println("사운드 파일을 찾을 수 없습니다: " + filePath);
                return;
            }

            try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile)) {
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();

                // 재생이 끝날 때까지 기다렸다가 리소스 정리
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });

            } catch (UnsupportedAudioFileException e) {
                System.err.println("지원하지 않는 오디오 포맷입니다: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("오디오 파일을 읽는 중 오류: " + e.getMessage());
            } catch (LineUnavailableException e) {
                System.err.println("오디오 라인을 사용할 수 없습니다: " + e.getMessage());
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AlertTimerGUI frame = new AlertTimerGUI();
            frame.setVisible(true);
        });
    }
}