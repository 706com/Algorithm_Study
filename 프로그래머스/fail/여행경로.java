package 프로그래머스.fail;

//소요시간 : 00

import java.util.Arrays;
import java.util.Comparator;

class 여행경로 {
    static boolean[] visited;
    static String[] answer;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new String[tickets.length+1];
        Arrays.sort(tickets,new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });

        for(int i=0; i<tickets.length; i++){
            System.out.println(Arrays.toString(tickets[i]));
        }

        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals("ICN")){
                dfs(i,0,tickets);
            }
        }
        return answer;
    }
    public void dfs(int start, int depth,String[][] tickets){
        visited[start] = true;
        answer[depth] = tickets[start][0];

        System.out.println(tickets[start][0]);

        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[start][1].equals(tickets[i][0])){
                dfs(i,depth+1,tickets);
            }
        }
        if(depth == tickets.length-1){
            answer[depth+1] = tickets[start][1];
        }
    }
}