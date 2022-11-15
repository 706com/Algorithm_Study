package 백준;

//[백준]2775 : 부녀회장이 될테야 - JAVA(자바)

//<새로 알게된 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2775_부녀회장이_될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T != 0) {
            T--;
            int[] people = new int[15]; //n<=14 , 인덱스 -1 가 헷갈리지 않게 그냥 배열에 +1 만큼 증가해주자.
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            //0층 사람 수 지정
            //0층의 i호에는 i명이 산다
            for(int i=0; i<=14; i++){
                people[i] = i;
            }

            //층 수 만큼만 반복 (그림과 같이 이해해보자)
            for(int i=0; i<k; i++) {
                for (int j = 2; j <= 14; j++) {
                    people[j] = people[j] + people[j-1] ;
                }
            }

            //배열에 해당하는 호 출력
            System.out.println(people[n]);

        }
    }
}
