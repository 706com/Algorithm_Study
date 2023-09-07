package 백준.Gold;

// < 알고리즘 유형 >
//

// < 풀이 접근 >
// *. 조합 : 순서(x) 중복 허용x
// *. 시간복잡도 : O(2^n)  n<15 이므로 통과!
// 1. 단어를 정렬시킨다.
// 2. combination 함수를 이용해 값을 출력한다.
// -> 조합된 문자에 모음 1개, 자음 2개가 포함되어 있는지 판별한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759_암호_만들기 {

    static int L;
    static int C;
    static char[] arr;
    static char[] output;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        L = Integer.parseInt(st.nextToken());   //depth
        C = Integer.parseInt(st.nextToken());   //N

        arr = new char[C];
        output = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<C; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        // 정렬
        Arrays.sort(arr);

//        for(int i=0; i<C; i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();

        combination(0,0);

    }
    static void combination(int depth, int start){
        if(depth == L){

            // 조합문자중, 모음찾기
            int count = 0;
            for(int i=0; i<depth; i++){
                if(output[i] == 'a' || output[i] == 'e' || output[i] == 'i'|| output[i] == 'o'|| output[i] == 'u'){
                    count++;
                }
            }
            // 모음이 한개도 없거나, 자음이 2개 미만일 때
            if(count == 0 || L-count < 2){
                return;
            }

            // 단어 출력
            for(int i=0; i<depth; i++){
                System.out.print(output[i]);
            }
            System.out.println();
            return;
        }

        for(int i=start; i<C; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                combination(depth+1,i+1);
                visited[i] = false;
            }
        }
    }
}
