package BOJ._2_Silver;

//[250825] 30분

import java.util.*;
import java.io.*;

public class _11652_카드 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        MaxNode maxNode = new MaxNode("-1",-1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0 ; i<N; i++){
            String x = br.readLine();
            map.put(x,map.getOrDefault(x,0)+1);
            if(maxNode.val < map.get(x)){
                maxNode = new MaxNode(x,map.get(x));
                continue;
            }
            if(maxNode.val == map.get(x)){
                if(Long.parseLong(maxNode.num) > Long.parseLong(x)) {
                    maxNode = new MaxNode(x,map.get(x));
                }
            }
        }
        System.out.println(maxNode.num);
    }
    static class MaxNode{
        String num;
        int val;
        MaxNode(String num, int val){
            this.num = num;
            this.val = val;
        }
    }
}
