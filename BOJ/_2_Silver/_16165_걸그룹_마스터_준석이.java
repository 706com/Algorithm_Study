package BOJ._2_Silver;

//[241231] 20분

import java.io.*;
import java.util.*;

public class _16165_걸그룹_마스터_준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        Map<String,List<String>> team = new HashMap<>();
        Map<String,String> member = new HashMap<>();

        //걸그룹 수
        for(int i=0; i<N; i++){
            String girlGroup = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();
            for(int j=0; j<memberCount; j++){
                String memberName = br.readLine();
                members.add(memberName);
                member.put(memberName,girlGroup);  // key : 개인 이름 , val : 그룹명
            }
            //정렬 후, 걸그룹에 멤버들 넣기
            Collections.sort(members);
            team.put(girlGroup,members);
        }

        // 문제 풀기
        for(int i=0; i<M; i++){
            String name = br.readLine();
            int quiz = Integer.parseInt(br.readLine());
            //걸그룹 맞추기
            if(quiz == 1){
                sb.append(member.get(name)).append('\n');
            } else{ // 멤버 나열
                List<String> members = team.get(name);
                for(String x : members){
                    sb.append(x).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
