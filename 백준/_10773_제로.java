package 백준;
//[백준]10773 : 제로 - JAVA(자바)

//<새로 알게된 것>
//char 은 비교할 때 != '0' 형식 ' ' 작은 따옴표
//String은 비교할 때 equals 형식 " " 큰 따옴표

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        //입력된 수 모두를 빌더에 담아서 함수에 보내기 ex) sb=4 3 0 4 , sb=1 3 5 4 0 0 ~~
        for(int i=0; i<K; i++){
            sb.append(br.readLine()).append(" ");
        }
        int result = stackSum(K, sb.toString());

        System.out.println(result);

    }
    public static int stackSum(int K, String sb){
        //띄어쓰기 단위로 토큰화
        StringTokenizer st = new StringTokenizer(sb," ");
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<K; i++){
            //
            String str = st.nextToken();

            //스택을 이용하여 0이 아니면 int 형변환 후 push , 0이면 pop
            if(!str.equals("0")){
                stack.push(Integer.parseInt(str));
            }
            else if(str.equals("0")) {
                stack.pop();
            }
        }

        int sum = 0;
        int size = stack.size();

        //sum 에 담아서 리턴
        for(int i=0; i<size; i++){
            sum += stack.pop();
        }
        return sum;
    }
}
