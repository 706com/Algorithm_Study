package BOJ._1_Bronze;

// 소요 시간 : 12분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13300_방_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //인원수
        int K = Integer.parseInt(st.nextToken());   //방 수용 최대
        int result = 0;

        int[] male = new int[7];
        int[] female = new int[7];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int isMale = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if(isMale == 1){
                male[grade]++;
            }
            else{
                female[grade]++;
            }
        }

        // 남자 여자 기준 각 학년마다 필요 방 갯수 세주기.
        for(int i=1; i<=6; i++){
            // 만일 K=3인데 5명이다. 결과값에 몫을 더해주고 , 나머지가 존재하면 +1추가
            result += male[i] / K;
            if(male[i] % K >0){
                result++;
            }

            result += female[i] / K;
            if(female[i] % K >0){
                result++;
            }
        }
        System.out.println(result);

    }
}
