package awtTest;

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

    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    // Swing 타이머
    private Timer timer;

    // 경과 시간(초)
    private int elapsedSeconds = 0;

    // 타이머 동작 여부 플래그
    private boolean isRunning = false;

    // 최대 알람 시간 (15분 = 900초)
    private static final int MAX_ALARM_SECONDS = 15 * 60;

    // 사용할 사운드 파일 경로 (프로젝트 폴더에 alarm.wav 있다고 가정)
    private static final String ALARM_SOUND_PATH = "./alarm.wav";

    public AlertTimerGUI() {
        setTitle("30초 간격 알람 타이머 (최대 15분)");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙 배치

        initUI();
        initTimer();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // 경과 시간 표시 라벨
        timeLabel = new JLabel("경과 시간: 00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Dialog", Font.BOLD, 22));
        add(timeLabel, BorderLayout.CENTER);

        // 하단 패널 (안내 + 버튼들)
        JPanel bottomPanel = new JPanel(new BorderLayout());

        infoLabel = new JLabel("30초마다 사운드 재생, 15분 이후에는 알람이 울리지 않습니다.", SwingConstants.CENTER);
        bottomPanel.add(infoLabel, BorderLayout.NORTH);

        // 버튼 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        startButton = new JButton("재생");
        stopButton = new JButton("중지");
        resetButton = new JButton("초기화");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // 버튼 이벤트 등록
        registerButtonActions();
    }

    private void initTimer() {
        int delay = 1000; // 1초마다
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                updateTimeLabel();
                checkAlarm();
            }
        });
    }

    private void registerButtonActions() {
        // 재생 버튼 (시작/재시작)
        startButton.addActionListener(e -> {
            if (!isRunning) {
                timer.start();
                isRunning = true;
            }
        });

        // 중지 버튼 (일시정지)
        stopButton.addActionListener(e -> {
            if (isRunning) {
                timer.stop();
                isRunning = false;
            }
        });

        // 초기화 버튼 (0초로 리셋, 타이머 정지)
        resetButton.addActionListener(e -> {
            timer.stop();
            isRunning = false;
            elapsedSeconds = 0;
            updateTimeLabel();
        });
    }

    private void updateTimeLabel() {
        int hours = elapsedSeconds / 3600;
        int minutes = (elapsedSeconds % 3600) / 60;
        int seconds = elapsedSeconds % 60;

        String timeStr = String.format("경과 시간: %02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(timeStr);
    }

    private void checkAlarm() {
        // 15분(900초) 이후에는 알람 울리지 않음
        if (elapsedSeconds == 0 || elapsedSeconds > MAX_ALARM_SECONDS) {
            return;
        }

        // 30초 단위일 때마다 사운드 재생 (30, 60, 90, ... 900초)
        if (elapsedSeconds % 30 == 0) {
            playSound(ALARM_SOUND_PATH);
        }
    }

    /**
     * WAV 사운드 파일 재생
     */
    private void playSound(String filePath) {
        // GUI 멈추지 않도록 별도 스레드에서 실행
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

                // 재생이 끝나면 클립 닫기
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