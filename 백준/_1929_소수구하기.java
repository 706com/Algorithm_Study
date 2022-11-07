package 백준;//1929 : 소수구하기
//<새로 알게된 것>
//소수란? :1보다 큰 자연수 중 1과 그 수 자기 자신만을 약수로 갖는 자연수
//소수 구하는 알고리즘 : 에라토스테네스 체

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1929_소수구하기 {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        //boolean의 디폴트값 : false;
        //배열은 0번지 부터 시작하므로 16까지 들어가려면 +1
        prime = new boolean[N+1];

        check_prime();

        for(int i=M; i<=N; i++){
            if(!prime[i]){
                System.out.println(i);
            }
        }
    }

    public static void check_prime(){
        //true = 소수가 아님
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            //prime 안에 배열이 true(소수 아님) 면 스킵
            if(prime[i]) {
                continue;
            }
            //prime.length = 17
            for(int j = i*i; j<prime.length; j= j+i){
                prime[j] = true;
            }
        }
    }
}
