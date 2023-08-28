package 백준.Silver;
//[백준]9375 : 패션왕 신해빈 - JAVA(자바)

//< 나의 알고리즘 >
// 해쉬를 사용하여 값을 저장하고, 조합하여 더해나가기!

//< 답안 알고리즘 >
// 더해 나가는 것이 아니라 전체에서 예외(모두 입지 않은 것) 하나만 빼는것이 정답

//< 새로 알게된 것 >
// Iterator<>

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _9375_패션왕_신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int answer = 1;

            HashMap<String, Integer> map = new HashMap<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                String clothes = st.nextToken();
                String type = st.nextToken();

                // 각 종류별 옷의 갯수와 + 없을때 (1개) 더하기
                map.put(type,map.getOrDefault(type,1)+1);
            }

            Iterator<Integer> it = map.values().iterator();

            while(it.hasNext()){
                answer *= it.next().intValue();
            }
            answer--; //아무것도 입지 않은 것 하나 빼기
            System.out.println(answer);

        }
    }
}
