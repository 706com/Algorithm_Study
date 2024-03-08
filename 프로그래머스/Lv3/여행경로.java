package 프로그래머스.Lv3;

//소요시간 : 2시간

import java.util.*;

class 여행경로 {

    static boolean[] visited;
    static List<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        visited = new boolean[tickets.length + 1];

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                dfs(i,0,"ICN",tickets);
            }
        }
        Collections.sort(list);

        // for(String x : list){
        //     System.out.println("-----"+ x);
        // }
        // System.out.println("====" + list.get(0));
        StringTokenizer st = new StringTokenizer(list.get(0)," ");
        for(int i=0; i<answer.length; i++){
            answer[i] = st.nextToken();
        }
        return answer;
    }
    public void dfs(int start, int depth,String path, String[][] tickets){
        if(depth == tickets.length-1){
            path += (" " + tickets[start][1]);
            // System.out.println(path);
            list.add(path);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[start][1].equals(tickets[i][0])){
                visited[start] = true;
                dfs(i,depth+1,path + " "+ tickets[i][0] ,tickets);
                visited[start] = false;
            }
        }
        visited[start] = false;
    }
}