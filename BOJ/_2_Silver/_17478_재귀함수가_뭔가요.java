package BOJ._2_Silver;

//소요시간 : 21분 (너무 길다..!)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17478_재귀함수가_뭔가요 {

    static int N;

    static String A = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String B = "\"재귀함수가 뭔가요?\"";
    static String C = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String D = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String E = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String F = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String G = "라고 답변하였지.";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(A);

        recursion(0);
    }
    static void recursion(int depth){
        String bar = "_".repeat(depth*4);
        System.out.println(bar+B);
        if(depth == N){
            System.out.println(bar+F);
            System.out.println(bar+G);
            return;
        }
        System.out.println(bar+C);
        System.out.println(bar+D);
        System.out.println(bar+E);
        recursion(depth+1);
        System.out.println(bar+G);
    }
}
