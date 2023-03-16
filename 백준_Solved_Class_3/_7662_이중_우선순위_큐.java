package 백준_Solved_Class_3;
//[백준]7662 : 이중 우선순위 큐 - JAVA(자바)

//< 나의 알고리즘 >
// 우선순위 큐 이므로 PriorityQueue 로 접근
// 막힘 : Deque 와 우선순위 큐를 어떻게 합쳐서 사용할지 모르겠음.

//< 답안 알고리즘 >
// TreeMap : 정렬이 가능한 Map
// TreeMap은 이진 트리를 기반으로 오름차순으로 정렬된 형태로 저장

//< 새로 알게된 것 >
// PriorityQueue<Integer> Q = new PriorityQueue<>() 오름차순
// PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder()) 내림차순
// map.getOrDefault(key,0) +1 = 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드

//< 궁금한 것 >


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _7662_이중_우선순위_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    //테스트 데이터

        while(T-- > 0){
            int k = Integer.parseInt(br.readLine());    //적용할 연산의 개수  (k ≤ 1,000,000)
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i=0; i<k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String command  = st.nextToken();   // I,D
                int value = Integer.parseInt(st.nextToken());

                // 넣기. (이미 있는 키면 값 증가)
                if(command.equals("I")) {
                    map.put(value,map.getOrDefault(value,0) +1);
                }

                else if(command.equals("D")){
                    //Q가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시해도 좋다
                    if(map.isEmpty()){
                        continue;
                    }
                    //D 1 일 때 : 최댓값 삭제 (value 가 1개면 삭제, 2개 이상이면 값 -1)
                    if(value == 1){
                        if(map.get(map.lastKey())==1){
                            map.pollLastEntry();
                        }
                        else{
                            map.put(map.lastKey(),map.get(map.lastKey())-1);
                        }
                    }
                    //D -1 일 때 : 최솟값 삭제 (value 가 1개면 삭제, 2개 이상이면 값 -1)
                    else if (value == -1){
                        if(map.get(map.firstKey())==1) {
                            map.pollFirstEntry();
                        }
                        else{
                            map.put(map.firstKey(),map.get(map.firstKey())-1);
                        }
                    }
                }
            }

            if(map.isEmpty()){
                System.out.println("EMPTY");
            }
            else{
                System.out.println(map.lastKey()+" "+map.firstKey());
            }

        }

    }
}
