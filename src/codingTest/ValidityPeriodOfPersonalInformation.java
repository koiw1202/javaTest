package codingTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidityPeriodOfPersonalInformation {

    private static final Map<String, Integer> termMap = new HashMap<>();
    private static final int MAX_DAY = 28;
    private static final int MAX_YEAR = 336;

    public static void main(String[] args) {

//        "2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
//         1,3
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        String[] currentDate = today.split("\\.");

        int currentYear = Integer.parseInt(currentDate[0]);
        int currentMonth = Integer.parseInt(currentDate[1]);
        int currentDay = Integer.parseInt(currentDate[2]);
        List<Integer> answer = new ArrayList<>();

        for (String term : terms) {
            String[] termsArr = term.split(" ");
            termMap.put(termsArr[0], Integer.parseInt(termsArr[1]));
        }

        int index = 1;
        for (String privacy : privacies) {
            String[] privacyArr = privacy.split("\\.");
            String[] privacyValidity = privacyArr[2].split(" ");
            privacyArr[2] = privacyValidity[0];

            int privateYear = Integer.parseInt(privacyArr[0]);
            int privateMonth = Integer.parseInt(privacyArr[1]);
            int privateDay = Integer.parseInt(privacyArr[2]);
            String privateValidity = privacyValidity[1];

            LocalDate currentLd = LocalDate.of(currentYear, currentMonth, currentDay);
            LocalDate tempLd = sumDays(privateYear, privateMonth, privateDay, (termMap.get(privateValidity) * MAX_DAY) - 1);

            if(currentLd.isAfter(tempLd)) {
                System.out.println(index);
                answer.add(index);
            }
            index++;
        }

        int[] answerList = answer.stream().mapToInt(Integer::intValue).toArray();

    }

    private static LocalDate sumDays(int year, int month, int day, int sumDays) {

        int sumYears = (sumDays / MAX_YEAR);
        int sumResultOfYear = year + sumYears;
        sumDays -= (MAX_YEAR * sumYears);

        int sumMonthes = (sumDays / MAX_DAY);
        int sumResultOfMonth = month + sumMonthes;
        sumDays -= (MAX_DAY * sumMonthes);

        while(sumResultOfMonth > 12) {
            sumResultOfYear++;
            sumResultOfMonth -= 12;
        }

        int sumResultOfDays = day + sumDays;

        while(sumResultOfDays > MAX_DAY) {
            sumResultOfMonth++;

            if (sumResultOfMonth > 12) {
                sumResultOfYear++;
                sumResultOfMonth -= 12;
            }
            sumResultOfDays -= MAX_DAY;
        }

        return LocalDate.of(sumResultOfYear, sumResultOfMonth, sumResultOfDays);
    }
}














