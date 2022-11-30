package 백준;
//[백준]2798 : 블랙잭 - JAVA(자바)

//<새로 알게 된 것>
// 블랙잭: 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임
// 브루트포스 문제 : N 의범위가 100 미만이다 (범위가 적다) -> 삼중포문이라도 가능
// Loop1: -> break(Loop) 로 다중반복문 빠져나올 수 있음!
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798_블랙잭 {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st= new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int temp = 0;
        int result = 0;


        //찾는 과정 중(temp), M과 일치 하는게 있으면 반복문 즉시 종료 후 출력
        //M 과 일치하는 값이 하나도 없으면, 그 중 최솟값 출력
        Loop1:
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for (int k=j+1; k<N; k++){
                     temp = arr[i] + arr[j] + arr[k];

                     if(temp == M){
                         System.out.println(temp);
                         break Loop1;
                     }
                     else if(result < temp && temp < M){
                         result = temp;
                     }
                }
            }
        }
        //이 값이 출력되는 조건은 앞선 temp가 출력되지 않아야함
        //앞선 temp출력 조건 : temp == M
        if(temp != M){
            System.out.println(result);
        }
    }
}
