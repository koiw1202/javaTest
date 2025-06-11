package codingTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Players {

    class Server {
        int time = 1;
    }
    public int solution() {
        int answer = 0;
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        List<Server> servers = new LinkedList<>();

        for(int i = 0; i < players.length; i++) {
            Iterator<Server> iterator = servers.iterator();
            while(iterator.hasNext()) {
                Server server = iterator.next();

                server.time++;
                if(server.time > k) {
                    iterator.remove();
                }
            }

            int isServerNeeds = players[i] / m;
            isServerNeeds -= servers.size();

            if( isServerNeeds > 0) {
                for(int j = 0; j < isServerNeeds; j++) {
                    servers.add(new Server());
                    answer++;
                }
            }
        }

        return answer;
    }

}