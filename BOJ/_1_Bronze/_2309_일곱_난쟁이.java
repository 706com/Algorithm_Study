package BOJ._1_Bronze;

// < 알고리즘 유형 >
// 완전탐색(조합)

// < 풀이 접근 >
// *. 9명중 7명을 뽑아(순서상관x , 중복x)  100을 찾는 문제 -> 조합
// *. 조합: 2^n  이므로 시간복잡도 통과
// 1. 배열에 난쟁이 키들을 입력받는다,
// 2. 배열을 정렬시킨다. (어차피 후에 오름차순으로 출력해야하므로)
// 3. combination 함수를 이용하여 sum 이 100일 경우를 찾는다.
// 4. 값이 여러개일 경우, 한개만 출력하면 되니, check하는 불린값을 만든다.
// 5. 결과값을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2309_일곱_난쟁이 {
    static int N = 9;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[N];
        output = new int[7];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0,0,0);
    }

    static void dfs(int start ,int depth, int sum){
        if(depth == 7){
            if(sum == 100) {
                Arrays.sort(output);
                for(int i=0; i<7; i++){
                    System.out.println(output[i]);
                }
                System.out.println();
                //여러번의 정답이 있을경우 하나만 출력
                check = true;
            }
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                dfs(i,depth+1,sum+arr[i]);
                visited[i] = false;
            }
            //여러번의 정답이 있을경우 하나만 출력
            if(check){
                return;
            }
        }
    }
}
