package 프로그래머스.Lv3;
//[프로그래머스] 베스트앨범 - JAVA(자바)

//[251124] 34분

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {

        List<Integer> result = new ArrayList<>();

        Map<String,Integer> score = new HashMap<>();
        Map<String,PriorityQueue<Node>> album = new HashMap<>();

        // 1. 장르 순회 및 적재
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];

            //점수 책정
            score.put(genre,score.getOrDefault(genre,0)+play);

            //앨범 장르별 적재
            if(!album.containsKey(genre)){
                PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> {
                    // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
                    if(o1.plays==o2.plays){
                        return o1.idx - o2.idx;
                    }
                    //2. 장르 내에서 많이 재생된 노래를 먼저 수록
                    return o2.plays - o1.plays;
                });
                album.put(genre, pq);
            }
            album.get(genre).add(new Node(i,genre,play));
        }

        //2. score에서 장르 순위 매기기
        List<Node> list = new ArrayList<>();
        for(String x : score.keySet()){
            Node node = new Node(0,x,score.get(x));
            list.add(node);
        }
        Collections.sort(list,(o1,o2)-> o2.plays - o1.plays);
        // System.out.println(list);

        //3. 순위별로 앨범 수록하기 (최대 2개)
        for(Node x : list){
            String genre = x.genre;
            PriorityQueue<Node> pq = album.get(genre);
            int count = 0;
            while(!pq.isEmpty()){
                if(count==2){
                    break;
                }
                result.add(pq.poll().idx);
                count++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    class Node{
        int idx;
        String genre;
        int plays;
        Node(int idx,String genre, int plays){
            this.idx = idx;
            this.genre = genre;
            this.plays = plays;
        }
        public String toString(){
            return idx +" "+genre+" "+ plays;
        }
    }
}

