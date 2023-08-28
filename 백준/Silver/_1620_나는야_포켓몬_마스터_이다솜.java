package 백준.Silver;
//[백준]1620: 나는야 포켓몬 마스터 이다솜 - JAVA(자바)

//<새로 알게된 것>
//try-catch 구문 (예외처리)
//value를 통한 key찾는 방법은 힘듬. (차라리 2개 만들기)

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1620_나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        HashMap<Integer,String> keyNum = new HashMap<>();
        HashMap<String,Integer> keyName = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            String name = br.readLine();
            keyNum.put(i,name);
            keyName.put(name,i);
        }
        for(int i=0; i<M; i++){
            String answer = br.readLine();
            try {
                int num = Integer.parseInt(answer);
                System.out.println(keyNum.get(num));
            } catch(NumberFormatException num) {
                System.out.println(keyName.get(answer));
            }
        }
    }
}


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        StringBuilder sb = new StringBuilder();
//        HashMap<Integer,String> integerKeyHash = new HashMap<>();
//        HashMap<String,Integer> stringKeyHash = new HashMap<>();
//
//        int N = Integer.parseInt(st.nextToken());   //포켓몬의 개수 1<=N<=100,000
//        int M = Integer.parseInt(st.nextToken());   //맞춰야 하는 문제의 개수 1<=M<=100,000
//
//        //입력
//        for(int i=1; i<=N; i++){
//            String name = br.readLine();
//            integerKeyHash.put(i, name);    //번호, 이름
//            stringKeyHash.put(name,i);      //이름 , 번호
//        }
//
//        //문제 맞추기
//        for(int i=0; i<M; i++){
//            String question = br.readLine();
//            //입력받은 값이 숫자면
//            try {
//                Integer.parseInt(question);
//                sb.append(integerKeyHash.get(Integer.parseInt(question))).append("\n");
//
//                //입력받은 값이 문자면
//            }catch(NumberFormatException e){
//                sb.append(stringKeyHash.get(question)).append("\n");
//            }
//        }
//        System.out.println(sb);
//    }