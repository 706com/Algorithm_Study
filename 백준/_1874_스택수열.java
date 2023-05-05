package 백준;

//<새로 알게된 것>
// stringbuilder에 내용이 담겨 있을 때, 초기화 방법 : length 를 0으로 해준다
// 조건문 안에 stack 이 비어있는채로 비교할 시 오류 발생 (if 문이던, while 문이던)

// <궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int start =0;

        while(N -- > 0){

            int now = Integer.parseInt(br.readLine());

            if(now > start) {
                for (int i = start+1; i <= now; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = now;
            }

            else if(stack.peek() != now){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append('\n');
        }

        System.out.println(sb);
    }
}


//    public static void main(String[] args) throws IOException {
//        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        Stack<Integer> stack = new Stack<>();
//        int n = Integer.parseInt(br.readLine());
//
////        for(int i=0; i<n; i++){
////            sb.append(br.readLine()).append(" ");
////        }
//
//        int start = 0;
//
//        for(int i=0; i<n; i++){
//            int now = Integer.parseInt(br.readLine());
//
//            //입력받은 숫자만큼 push 해주기
//            //만일 start 가 입력받은 숫자보다 크면 push 할 일이 없음.
//            for(int j=start+1; j<=now; j++){
//                stack.push(j);
//                sb.append("+").append("\n");
//            }
//
//            // NO 설명 : 만일 1 2 5 3 4 를 입력할시 3까지는 정상작동한다.
//            // 1)문제를 이해했다면 now 가 3 일때, 스택에는 현재 4(top) 3 이 들어가 있을 것이고, (스택은 오름차순으로 입력)
//            //   아래 while 문을 거쳐 3을 뽑아내야 하므로 (pop) (pop) 을 거쳐야 할 것 이다.
//
//            // 2) 그러나 now 가 4일 때, 아까 3을 뽑아낼 때 4까지 뽑아냈기에 스택은 비어있게된다. 따라서 이 수열은 불가능.
//
//            // 3) sb 를 '초기화'하고 "NO" 를 출력시키고 반복문을 빠져나간다.
//            if(stack.isEmpty()){
//                sb.setLength(0);
//                System.out.println("NO");
//                break;
//            }
//
//            //스택의 top이 now보다 같을 때까지 값 뽑아 내기.
//            while(stack.peek() >= now ){
//                stack.pop();
//                sb.append("-").append("\n");
//
//                //pop 하고나서 비었는지 체크하고 빠져나와야, while 조건문에서 오류 안남
//                if(stack.isEmpty()){
//                    break;
//                }
//            }
//
//            if(start <= now)
//                start = now;
//        }
//        //정상 출력하면 +- 담긴 sb 출력
//        //"NO" 조건문 만나면 초기화 되므로 아무것도 없음
//        System.out.println(sb);
//    }
