package 프로그래머스.Lv3;
//[프로그래머스] 베스트앨범 - JAVA(자바)

//< 알고리즘 유형 >
// 해쉬

//< 알고리즘 풀이 >
// 오로지 해쉬로 풀려했으나 , 담아야 할 정보가 너무 많으니, class로 접근해야겠다..

//< 새로 알게된 것 >
// 람다식 : Collections.sort(albList, (o1,o2) -> o2.play - o1.play);

//< 궁금한 것 >


import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] answer = {};

        // 장르중 plays 수의 총 합 담기 (가장 많이 들은 종류 담기 위해)
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
        }

        // 1. 장르 선정하기
        ArrayList<String> list = new ArrayList<>();
        while(!map.isEmpty()){
            int max = Integer.MIN_VALUE;
            String maxKey = "";

            for(String key : map.keySet()){
                int temp = map.get(key);
                if(max<temp){
                    max = temp;
                    maxKey = key;
                }
            }
            //리스트에 크기 별 장르 넣고 , hash에서는 삭제
            list.add(maxKey);
            map.remove(maxKey);
        }

//        //리스트에 크기 별 장르  출력
//        for(int i=0; i<list.size(); i++){
//            System.out.println(list.get(i)+" ");
//        }

        // 2.장르 내 노래 선정
        ArrayList<Album> result = new ArrayList<>();

        // 리스트에 클래스 담기
        for(String genr : list){
            ArrayList<Album> albList = new ArrayList<>();
            for(int i=0; i< genres.length; i++){
                if(genres[i].equals(genr)){
                    albList.add(new Album(i,genres[i],plays[i]));
                }
            }

            //내림차순 정렬 (장르) 중 plays수에 따라
            Collections.sort(albList, (o1,o2) -> o2.play - o1.play);

            //한개는 무조건 담고, 앨범 내 수록곡이 2개 이상이면 하나 더 담기
            result.add(albList.get(0));
            if(albList.size()>1){
                result.add(albList.get(1));
            }
        }

        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).index;
        }

//        for(int i=0; i<result.size(); i++){
//            System.out.println(answer[i]+" ");
//        }
        return answer;
    }
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        베스트앨범 sol = new 베스트앨범();
        System.out.println(sol.solution(genres,plays));

    }
    static class Album{
        int index;
        String genre;
        int play;
        Album(int index, String genre , int play){
            this.index=index;
            this.genre = genre;
            this.play = play;
        }
    }
}
