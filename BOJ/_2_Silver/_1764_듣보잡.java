package BOJ._2_Silver;
//[백준]1764 : 듣보잡 - JAVA(자바)

//<새로 알게된 것>
// Hash 가 list 보다 시간이 훨씬 단축될 수 있다.

//<궁금한 것>


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i=0; i<N; i++){
            String listener = br.readLine();
            map.put(listener,map.getOrDefault(listener,0) +1);
        }

        int count = 0;
        for(int i=0; i<M; i++){
            String viewer = br.readLine();
            if(map.containsKey(viewer)){
                count++;
                result.add(viewer);
            }
        }
        Collections.sort(result);
        System.out.println(count);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}




//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        HashMap<String,Integer> hash = new HashMap<>();
//
//        List<String> result = new ArrayList<>();
//
//        int N = Integer.parseInt(st.nextToken());   //듣도 못한 사람의 수 1<=N<=500,000
//        int M = Integer.parseInt(st.nextToken());   //보도 못한 사람의 수 1<=M<=500,000
//
//        //듣도 못한사람 입력
//        for(int i=0; i<N; i++){
//            hash.put(br.readLine(),i);
//        }
//
//        int count = 0;
//
//        //보도 못한 사람의 수 검색
//        for(int i=0; i<M; i++){
//            String check = br.readLine();
//
//            if(hash.containsKey(check)){
//                result.add(check);
//            }
//        }
//
//        Collections.sort(result);
//
//        sb.append(result.size()).append("\n");
//
//        for(int i=0; i<result.size(); i++){
//            sb.append(result.get(i)).append("\n");
//        }
//
//        System.out.println(sb);
//
//    }