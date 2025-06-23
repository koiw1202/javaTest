package codingTest;

import java.util.*;

public class GetMineral {

    static class Mineral {
        int diamond ;
        int iron ;
        int stone ;

        public Mineral(int diamond, int iron, int stone){
            this.diamond = diamond ;
            this.iron = iron ;
            this.stone = stone ;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        List<Mineral> mineralList = new ArrayList<>() ;
        final int MINERAL_LEN = minerals.length ;
        int cnt = MINERAL_LEN % 5 == 0 ? MINERAL_LEN / 5 : (MINERAL_LEN / 5) + 1 ;
        int totalPicks = Arrays.stream(picks).sum();

        for(int i = 0 ; i < cnt ; i++) {
            if(totalPicks ==0) break ;
            int diamonSum = 0 ;
            int ironSum = 0 ;
            int stoneSum = 0 ;

            for(int j = (i*5) ; j < (i*5) + 5; j++ ) {
                if( j >= minerals.length) break ;
                switch (minerals[j].charAt(0)) {
                    case 'd' :
                        diamonSum += 1 ;
                        ironSum += 5 ;
                        stoneSum += 25 ;
                        break;

                    case 'i' :
                        diamonSum += 1 ;
                        ironSum += 1 ;
                        stoneSum += 5 ;
                        break;

                    case 's' :
                        diamonSum += 1 ;
                        ironSum += 1 ;
                        stoneSum += 1 ;
                        break;
                }
            }
            totalPicks-- ;
            mineralList.add(new Mineral(diamonSum, ironSum, stoneSum)) ;
        }

        Collections.sort(mineralList, (o1, o2)-> (o2.stone - o1.stone)) ;
        int answer = 0 ;

        for(Mineral m : mineralList) {
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;

            if(picks[0] > 0) {
                answer += dia ;
                picks[0]-- ;
                continue ;
            }
            if(picks[1] > 0) {
                answer += iron ;
                picks[1]-- ;
                continue ;
            }
            if(picks[2] > 0) {
                answer += stone ;
                picks[2]-- ;
                continue ;
            }
        }
        return answer;
    }
}