package BOJ._3_Gold;
//[백준]1107 : 리모컨 - JAVA(자바)

//<새로 알게된 것>
// 완전탐색문제
// Math.abs = 절댓값 반환
// Integer.MAX_VALUE : 정수중 최댓값
// Character.getNumericValue : (char to int)

//<궁금한 것>
// 완전탐색, 브루트포스 문제인데.. 이걸 어떻게 보고 바로 판단할 수 있을까? (알고리즘으로 해결이 안될 때.,?)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1107_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //이동하려는 채널 (0<=N<=500,000)
        int M = Integer.parseInt(br.readLine());    //고장난 버튼의 개수(0<=M<=10)
        ArrayList<Integer> brokenBtn= new ArrayList<>();

        //입력 (고장난 버튼) (조건문 안걸어주면 런타임 에러)
        if(M!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int btn = Integer.parseInt(st.nextToken());
                brokenBtn.add(btn);
            }
        }

        //입력받은 값이 100이면 바로 결과 출력
        if(N==100){
            System.out.println("0");
            return;
        }

        // 100에서 +- 로만 이동했을 경우.
        int result = Math.abs(N - 100); //채널 초기값은 100 이므로 ex) 채널 98 or 102일때, result == 2
        int count = 0;
        int min = Integer.MAX_VALUE;
        //완전탐색
        for(int i=0; i<=999999; i++){
            String num = String.valueOf(i);
            int numLen = num.length();
            boolean check = false;

            //0~999999 의 자릿수를 각각 쪼개서, 하나라도 고장난 버튼이면 건너뛰어버리는 과정
            for(int j=0; j<numLen; j++){
                char c = num.charAt(j);
                if(brokenBtn.contains(Character.getNumericValue(c))){
                    check = true;
                    break;
                }
            }
            //해당되는 i에 고장난 버튼이 하나라도 있으면 건너뛰기
            if(check){
                continue;
            }

            count = num.length() + Math.abs(N-i);   //고장난 버튼없이 입력된 채널에서 +-로 이동한 값

            if(min > count){
                min = count;
            }
        }

        //0~999999 를 돌아서 얻은 최솟값과 맨 처음 100에서 눌렀을 때 값 비교
        if(result>min){
            System.out.println(min);
        }
        else{
            System.out.println(result);
        }

    }
}
