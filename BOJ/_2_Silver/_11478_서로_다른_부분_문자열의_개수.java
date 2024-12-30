package BOJ._2_Silver;

//[241230] 7분

import java.io.*;
import java.util.*;

public class _11478_서로_다른_부분_문자열의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set<String> set = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            for(int j=i; j<=str.length(); j++){
//                System.out.println(str.substring(i,j));
                set.add(str.substring(i,j));
            }
        }
        System.out.println(set.size()-1);   //공백 제거
    }
}
