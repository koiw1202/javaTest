package codingTest;

import java.util.*;

public class MiningForMinerals {

    static final int GROUP_SIZE = 5;

    static final Map<String, Integer> fatigueMap = Map.ofEntries(
            Map.entry("diamond:diamond", 1), Map.entry("diamond:iron", 1), Map.entry("diamond:stone", 1),
            Map.entry("iron:diamond", 5), Map.entry("iron:iron", 1), Map.entry("iron:stone", 1),
            Map.entry("stone:diamond", 25), Map.entry("stone:iron", 5), Map.entry("stone:stone", 1)
    );

    static final Map<String, Integer> mineralValue = Map.of(
            "diamond", 25,
            "iron", 5,
            "stone", 1
    );

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] inputMinerals = {
                "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"
        };

        int totalPickUses = Arrays.stream(picks).sum() * GROUP_SIZE;
        int mineralCount = Math.min(inputMinerals.length, totalPickUses);

        List<MineralGroup> groups = makeGroups(inputMinerals, mineralCount);

        // 피로도 총합 기준으로 그룹 정렬 (가장 높은 우선순위부터 처리)
        groups.sort((a, b) -> Integer.compare(b.totalValue, a.totalValue));

        int answer = mine(groups, picks);
        System.out.println(answer);
    }

    private static List<MineralGroup> makeGroups(String[] minerals, int count) {
        List<MineralGroup> groups = new ArrayList<>();
        for (int i = 0; i < count; i += GROUP_SIZE) {
            int end = Math.min(i + GROUP_SIZE, count);
            List<String> groupMinerals = new ArrayList<>();
            int totalValue = 0;

            for (int j = i; j < end; j++) {
                groupMinerals.add(minerals[j]);
                totalValue += mineralValue.get(minerals[j]);
            }
            groups.add(new MineralGroup(groupMinerals, totalValue));
        }
        return groups;
    }

    private static int mine(List<MineralGroup> groups, int[] picks) {
        int fatigueSum = 0;

        for (MineralGroup group : groups) {
            String pickType = getAvailablePick(picks);
            if (pickType == null) break;

            for (String mineral : group.minerals) {
                fatigueSum += fatigueMap.get(pickType + ":" + mineral);
            }
        }

        return fatigueSum;
    }

    private static String getAvailablePick(int[] picks) {
        if (picks[0] > 0) {
            picks[0]--;
            return "diamond";
        } else if (picks[1] > 0) {
            picks[1]--;
            return "iron";
        } else if (picks[2] > 0) {
            picks[2]--;
            return "stone";
        }
        return null;
    }

    private static class MineralGroup {
        List<String> minerals;
        int totalValue;

        MineralGroup(List<String> minerals, int totalValue) {
            this.minerals = minerals;
            this.totalValue = totalValue;
        }
    }
}