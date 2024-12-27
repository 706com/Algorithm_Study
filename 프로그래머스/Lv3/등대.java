package 프로그래머스.Lv3;
//[241226] 🔍
//[241227] 🔍

import java.util.*;

public class 등대 {
    static List<Integer>[] list;
    static int[] haveToTurnOn;

    public int solution(int n, int[][] edges) {
        list = new ArrayList[n+1];
        haveToTurnOn = new int[n+1];

        // 인접리스트 입력
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        dfs(1, 0);
        // System.out.println(Arrays.toString(haveToTurnOn));

        int result = 0;
        for(int i=1; i<=n; i++){
            if(haveToTurnOn[i] != 0){
                result++;
            }
        }

        return result;
    }

    // dfs
    // 1과 0을 반대로 생성한 이유 -> return 값이 이래야 부모노드
    public int dfs(int cur, int parent) {
        // 리프노드면 1 반환 (킬 필요가 있는 상태)
        if (list[cur].size() == 1 && list[cur].get(0) == parent)
            return 1;

        // 리프노드가 아니면 dfs 탐색
        for (int i=0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            //다음이 부모면 생략
            if (next == parent) {
                continue;
            };
            // return 되는 값 저장 (자식들의 리턴값)
            haveToTurnOn[cur] += dfs(next, cur);
        }
        // 자식들이 모두 0 이면 (모두 킬 필요가 없는 상태)
        // 1 리턴 (나는 킬 필요가 있다 상태)
        if (haveToTurnOn[cur] == 0){
            return 1;
        }
        // 킬 필요가 없음을 리턴
        return 0;
    }
}
