package BOJ._3_Gold;

//[260103] 46분(진행중)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _1043_거짓말 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기화
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        // 진실된 이야기를 알고있는 사람 초기화
        List<Integer> recognizeRealStoryMan = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for(int i=0; i<count; i++){
            recognizeRealStoryMan.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer>[] partyList = new ArrayList[M]; // 파티 참석자 기록 남기기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            List<Integer> party = new ArrayList<>();
            int participants = Integer.parseInt(st.nextToken()); // 참석자 수
            int first = Integer.parseInt(st.nextToken()); // 기준자
            party.add(first);

            // 참석자가 2명 이상일 때 경로 압축
            for (int j = 1; j < participants; j++) {
                int second = Integer.parseInt(st.nextToken());  // 기준자를 기준으로, 모든 참석자 경로압축 진행
                union(first,second);
                party.add(second);
            }
            partyList[i] = party;
        }
//        System.out.println(Arrays.toString(parent));
//
//        for(List x : partyList){
//            System.out.println(x);
//        }

        int result = 0;
        // 파티 참석자 기록을 보며, 어느 파티에 거짓말 가능한지 추출
//        System.out.println(recognizeRealStoryMan);

        //아는 사람이 한명도 없으면 파티 수 만큼 거짓말 가능
        if(recognizeRealStoryMan.size() == 0){
            System.out.println(M);
            return;
        }

        // 파티
        for(List<Integer> party : partyList){
            boolean failFlag = false;
            //알고있는 자
            for(int x : recognizeRealStoryMan){
                for(int participants : party){
                    if(parent[participants] == parent[x]){
                        failFlag = true;
                        break;
                    }
                }
            }
            if(!failFlag){
                result++;
            }
        }
        System.out.println(result);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return;
        }
        if(parent[x] < parent[y]){
            parent[y] = x;
        } else{
            parent[x] = y;
        }
    }
    public static int find(int x){
        if(x == parent[x]){
            return x;
        }
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }
}
