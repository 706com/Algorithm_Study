package 프로그래머스.Lv2;
// https://school.programmers.co.kr/learn/courses/30/lessons/86971

//소요시간 : 50분
//[250204] : 40분🔍

import java.util.*;

class 전력망을_둘로_나누기 {
    List<Integer>[] list;
    boolean[] visited;

    public int solution(int n, int[][] wires) {

        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b= wires[i][1];
            list[a].add(b);
            list[b].add(a);
        }

        // for(List<Integer> x : list){
        //     System.out.println(x);
        // }

        int result = 100;
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            //끊고 돌리기
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));

            //bfs 돌리기
            result = Math.min(result,Math.abs(n- 2*bfs(a)));

            //다시 붙이기
            visited = new boolean[n+1];
            list[a].add(b);
            list[b].add(a);
        }

        return result;
    }
    public int bfs(int start){
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0; i<list[num].size(); i++){
                int x = list[num].get(i);
                if(visited[x]){
                    continue;
                }
                q.offer(x);
                visited[x] = true;
                count++;
            }
        }
        return count;
    }
}