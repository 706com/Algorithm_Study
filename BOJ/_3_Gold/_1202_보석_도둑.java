package BOJ._3_Gold;

//[241210] 🔍

// 1) 가방, 보석 무게 기준 오름차순 정렬한다
// 2) 가방을 돌면서 해당 가방에서 담을 수 있는 보석을 모두 담는다.
// 3) 담은 보석 중 가장 가격이 높은것을 추출한다.

import java.io.*;
import java.util.*;

public class _1202_보석_도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //보석 개수
        int K = Integer.parseInt(st.nextToken());   //가방 개수

        PriorityQueue<Jewelry> pq = new PriorityQueue<>();

        List<Jewelry> jewelries = new ArrayList<>();
        List<Integer> bag = new ArrayList<>();

        Long result = 0L;

        //보석 담기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            Jewelry j = new Jewelry(M,V);
            jewelries.add(j);
        }
        // 보석 무게 오름차순
        Collections.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                return o1.M - o2.M;
            }
        });

        //가방 용량 기준 오름차순
        for(int i=0; i<K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bag);

        // 현재 가방 기준 담을 수 있는 보석 다 담기
        int k=0;
        for(int i=0; i<bag.size(); i++){
            for(int j=k; j<jewelries.size(); j++){
                if(jewelries.get(j).M <= bag.get(i)){
                    pq.add(jewelries.get(j));
                } else{
                    k=j;
                    break;
                }
                //끝까지 돌았을 때
                k=j+1;
            }
            //현재 가방에서 가격 가장 큰 값 추출
            if(!pq.isEmpty()) {
                result += pq.poll().V;
            }
        }
        System.out.println(result);
    }
    static class Jewelry implements Comparable<Jewelry>{
        int M;  //무게
        int V;  //가격
        Jewelry(int m, int v){
            this.M = m;
            this.V = v;
        }

        @Override
        public int compareTo(Jewelry o) {
            if(this.V == o.V){
                return this.M - o.M;
            }
            //무게 내림차순
            return o.V - this.V;
        }

        @Override
        public String toString(){
            return this.M +" "+this.V;
        }
    }
}
