package BOJ.fail;

//[250110] 🔍 실패

import java.io.*;
import java.util.*;

public class _16974_레벨_햄버거 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, String> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long result = 0;
        String a = "aa";
        String b = "bb";

        map.put(1,"P");
        for(int i=2; i<=N; i++){
            String level = String.valueOf(i-1);
            map.put(i,"B"+level+"P"+level+"B");
        }

        String burger = map.get(N);
        while(N-->0){
            String level = "";
            for(int i=0;i<burger.length();i++){
                if(burger.charAt(i)-'0' <= 9 && burger.charAt(i)-'0'>=0){
                    level += (String.valueOf(burger.charAt(i)));
                }
                else if(burger.charAt(i)== 'P'){
                    System.out.println(level);
                    burger.concat(map.get(Integer.parseInt(level)));
                }
            }
        }

//        for(int x : map.keySet()){
//            System.out.println(map.get(x));
//        }
    }
}
