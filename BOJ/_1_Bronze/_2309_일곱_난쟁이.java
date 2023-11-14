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
    static int R = 7;   //depth

    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[N];
        output = new int[R];
        visited = new boolean[N];

        // 1. 배열에 난쟁이 키들을 입력받는다,
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 2. 배열을 정렬시킨다. (어차피 후에 오름차순으로 출력해야하므로)
        Arrays.sort(arr);

        // 3. combination 함수를 이용하여 sum 이 100일 경우를 찾는다.
        combination(0,0,0);
    }

    public static void combination(int depth, int start, int sum){
        if(depth==R){
            if(sum==100) {
                for (int i = 0; i < R; i++) {
                    System.out.println(output[i]);
                }
                check = true;
                return;
            }
            return;
        }

        for(int i=start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                combination(depth+1, i+1,sum+arr[i]);
                visited[i] = false;
                if(check){
                    return;
                }
            }
        }
    }
}
