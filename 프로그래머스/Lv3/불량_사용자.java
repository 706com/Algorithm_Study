package 프로그래머스.Lv3;

//[250307] 🔍

import java.util.*;

public class 불량_사용자 {
    //내부에 있는건 순서가 보장되어야함
    HashSet<LinkedHashSet<String>> result = new HashSet<>();
    boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        visited = new boolean[user_id.length];

        // userId가 나올 수 있는 모든 경우의 수 추출
        dfs(0,new LinkedHashSet<String>(),user_id,banned_id);

        // for(LinkedHashSet<String> x : result){
        //     System.out.println(x);
        // }

        return result.size();
    }

    public void dfs(int depth,LinkedHashSet<String> hs, String[] userId, String[] bannedId){
        if(depth == bannedId.length){
            // System.out.println(hs);

            //banned_id 에 부합하는지 검증
            if(checkBanList(bannedId,hs)){
                result.add(new LinkedHashSet<String>(hs));
            }
        }

        for(int i=0; i<userId.length; i++){
            if(!visited[i]){
                visited[i] = true;
                hs.add(userId[i]);
                dfs(depth+1,hs,userId,bannedId);
                hs.remove(userId[i]);
                visited[i] = false;
            }
        }
    }

    public boolean checkBanList(String[] banList, LinkedHashSet<String> list){
        int cnt = 0;

        for(String x : list){
            // System.out.println(banList[cnt]+" " + x);
            if(x.length() != banList[cnt].length()){
                return false;
            }
            for(int i=0; i<banList[cnt].length(); i++){
                if(banList[cnt].charAt(i) == '*'){
                    continue;
                }
                if(banList[cnt].charAt(i) != x.charAt(i)){
                    return false;
                }
            }
            cnt++;
        }
        // System.out.println("gotcha");
        return true;
    }
}
