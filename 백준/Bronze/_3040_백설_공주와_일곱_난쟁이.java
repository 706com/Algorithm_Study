package 백준.Bronze;

// < 알고리즘 유형 >
// 브루트포스

// < 풀이 접근 >
// 0. 입력은 9개 그 중 7개만 찾으면 되니, 브루트 포스로 접근 가능하다.
// 0. 순서를 생각하지 않고 9명중 7명을 뽑는것(찾는것) == 조합 nCr
// 1. Combination 함수를 구현한다.
// or
// 1. 9개의 총 합을 구한 후 , 100이 되는 값을 찾는다 (2개의 합이 sum - 100)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3040_백설_공주와_일곱_난쟁이 {

    static int[] arr = new int[9];
    static int[] output = new int[7];
    static boolean[] visited = new boolean[9];
    static boolean endPoint ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int depth = 0;

        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        combination(0,9,7);
    }

    public static void combination(int depth, int n, int r){
        if(depth == r){
            int sum=0;
            for(int i=0; i<output.length; i++){
                sum += output[i];
            }
            if(sum == 100){
                for(int i=0;i< output.length; i++){
                    System.out.print(output[i]);
                    System.out.println();
                }
                endPoint = true;
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                combination(depth+1,n,r);
                visited[i] = false;
                if(endPoint){
                    return;
                }
            }
        }
    }
}
