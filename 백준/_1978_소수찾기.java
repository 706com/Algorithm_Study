package 백준;//1978 : 소수 찾기
//<새로 알게된 것>
//StringTokenizer 의 위치를 잘 고려해야한다. (맨 위에 썼다가 오류발생)
//에라토스테네스 체 알고리즘 복기하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[N];

        int cnt = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            isPrime(arr[i]);
            //isPrime 에서 넘어오는 값이 false 라면 그것은 소수이다.
            if(!isPrime(arr[i])){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    public static boolean isPrime(int num){
        //매개변수로 넘어온 num이 7 이라면 7까지 포함해야 하니, +1을 해준다
        boolean prime[] = new boolean [num+1];
        prime[0] = true;
        prime[1] = true;

        //에라토스테네스 체 알고리즘
        //매개변수로 넘어온 num이 7 이라면 7까지 포함해야 하니, +1을 해준다(물론 <=num 을 해도 된다)
        for(int i=2; i<Math.sqrt(num+1); i++){
            if(prime[i]){
                continue;
            }
            for(int j = i*i; j<num+1; j =j+i){
                prime[j] = true;
            }
        }
        //prime 안에 num 이 false라면 그것은 소수이다
        if(!prime[num]){
            return false;
        }
        else
            return true;
    }
}
