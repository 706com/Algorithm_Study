package 백준_Solved_Class_3;
//[백준]1620: 나는야 포켓몬 마스터 이다솜 - JAVA(자바)

//<새로 알게된 것>
//try-catch 구문

//<궁금한 것>
//예외처리 공부해보기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1620_나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        HashMap<Integer,String> hash = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());   //포켓몬의 개수 1<=N<=100,000
        int M = Integer.parseInt(st.nextToken());   //맞춰야 하는 문제의 개수 1<=M<=100,000

        //입력
        for(int i=1; i<=N; i++){
            hash.put(i, br.readLine());
        }

//        for(int i=0; i<N; i++){
//            System.out.println(hash.get(i));
//        }

        //문제 맞추기
        for(int i=0; i<M; i++){
            String question = br.readLine();
            try {
                Integer.parseInt(question);
                System.out.println(hash.get(Integer.parseInt(question)));
            }catch(NumberFormatException e){
                //System.out.println("들어왔숑 "+question);
                for(int j=1; j<=N; j++){
                    if(hash.get(j).equals(question)){
                        System.out.println(j);
                        break;
                    }
                }
            }
        }
    }
}
