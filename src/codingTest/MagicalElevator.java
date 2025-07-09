package codingTest;

public class MagicalElevator {

    public static void main(String[] args) {

        int storey = 4155;
        int answer = 0;

        while(storey>0){
            int left = storey%10;

            if(left>5){
                answer+=(10-left);
                storey+= (10-left);
            } else if(left<5) {
                answer+=left;
                storey-=left;
            } else {
                int tmp = (storey/10)%10;
                if (tmp+1>5){
                    answer+=left;
                    storey+=left;
                }else {
                    answer+=(10-left);
                    storey-=left;
                }
            }
            storey/=10;

        }
        System.out.println(answer);
    }

}
