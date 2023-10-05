package 백준.Silver;

// < 알고리즘 유형 >
// 백트래킹

// < 풀이 접근 >
// *. 일단 연산자의 조합부터 나열하기?
// *. switch - case 문 활용하기.
// 1. 정수를 입력받는 배열을 저장시킨다.
// 2. 부호를 입력받는 배열을 저장시킨다.
// 3. 부호에 입력받은 배열을 순열시킨다. (순서o, 중복x)
//  -> 개수는 11개 이하 이므로 시간복잡도 통과
// 4. switch case 문으로 연산을 진행한다.
//  -> 값을 넘길때 넘길 값 : 연산된 값, depth


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _14888_연산자_끼워넣기 {

    static int[] numArr;
    static int[] operArr;
    static String[] arr;

    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        operArr = new int[4];
        arr = new String[N-1];

        StringTokenizer stNum = new StringTokenizer(br.readLine());
        StringTokenizer stOper = new StringTokenizer(br.readLine());

        // 1. 정수를 입력받는 배열을 저장시킨다.
        for(int i=0; i<N; i++){
            numArr[i] = Integer.parseInt(stNum.nextToken());
        }

        // 2. 부호를 입력받는 배열을 저장시킨다.
        for(int i=0; i<4; i++){
            operArr[i] = Integer.parseInt(stOper.nextToken());
        }


        // 3. 부호에 입력받은 배열을 순열시킨다. (순서o, 중복x)
        // -> 개수는 11개 이하 이므로 시간복잡도 통과
        permutation(numArr[0],0);

        System.out.println(max);
        System.out.println(min);
    }
    static void permutation(int num, int depth){

        if(depth == N-1){
//            for(int i=0; i<depth; i++){
//                System.out.print(arr[i]+" ");
//            }
//            System.out.println(num);
            if(num>max){
                max = num;
            }
            if(num<min){
                min = num;
            }
            return;
        }

        for(int i=0; i<4; i++){
            // 4. switch case 문으로 연산을 진행한다.
            if(operArr[i] > 0) {
                operArr[i]--;
                switch (i) {
                    case 0:
                        arr[depth] = "+";
                        permutation(num+numArr[depth+1],depth+1);
                        break;
                    case 1:
                        arr[depth] = "-";
                        permutation(num-numArr[depth+1],depth+1);
                        break;
                    case 2:
                        arr[depth] = "*";
                        permutation(num*numArr[depth+1],depth+1);
                        break;
                    case 3:
                        arr[depth] = "/";
                        permutation(num/numArr[depth+1],depth+1);
                        break;
                }
                operArr[i]++;
            }
        }
    }
}
