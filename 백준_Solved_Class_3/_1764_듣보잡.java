package 백준_Solved_Class_3;
//[백준]1764 : 듣보잡 - JAVA(자바)

//<새로 알게된 것>
//박성배 재수업슴

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
        HashMap<String,Integer> hash = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());   //듣도 못한 사람의 수 1<=N<=500,000
        int M = Integer.parseInt(st.nextToken());   //보도 못한 사람의 수 1<=M<=500,000



        for(int i=0; i<N; i++){
            hash.put(br.readLine(),1);
        }


        int count = 0;
        for(int i=0; i<M; i++){
            String check = br.readLine();
            if(arr.contains(check)){
                count++;
                result.add(check);
            }
        }

        Collections.sort(result);

        sb.append(count).append("\n");

        for(int i=0; i<result.size(); i++){
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);

    }
}
