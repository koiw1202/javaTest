package codingTest;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class ParkingFee {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };

        Map<String, List<String>> carRecords = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String car = parts[1];
            carRecords.computeIfAbsent(car, k -> new ArrayList<>()).add(time + " " + parts[2]);
        }

        Map<String, Integer> totalTimeMap = new HashMap<>();

        for (String car : carRecords.keySet()) {
            List<String> logs = carRecords.get(car);
            logs.sort(Comparator.naturalOrder());

            int totalMinutes = 0;

            for (int i = 0; i < logs.size(); i += 2) {
                String inTime = logs.get(i).split(" ")[0];
                String outTime;
                if (i + 1 < logs.size() && logs.get(i + 1).contains("OUT")) {
                    outTime = logs.get(i + 1).split(" ")[0];
                } else {
                    outTime = "23:59"; // 출차 기록 없는 경우
                }

                LocalTime in = LocalTime.parse(inTime);
                LocalTime out = LocalTime.parse(outTime);
                totalMinutes += Duration.between(in, out).toMinutes();
            }

            totalTimeMap.put(car, totalMinutes);
        }

        // 결과 계산 및 정렬
        List<String> sortedCars = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(sortedCars);

        int[] result = new int[sortedCars.size()];
        for (int i = 0; i < sortedCars.size(); i++) {
            int time = totalTimeMap.get(sortedCars.get(i));
            result[i] = calculateFee(time, fees);
        }

        System.out.println(Arrays.toString(result));
    }

    public static int calculateFee(int time, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= basicTime) return basicFee;

        return basicFee + (int) Math.ceil((time - basicTime) / (double) unitTime) * unitFee;
    }
}