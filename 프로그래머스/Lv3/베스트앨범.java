package 프로그래머스.Lv3;
//< 알고리즘 유형 >
// 해쉬

//< 알고리즘 풀이 >
//전체를 구하고, 아무것도 입지 않는경우 -1 을 해준다.

//< 새로 알게된 것 >
// 해쉬에 list담는법.
// -> 기존에 있는 list를 꺼내오고 그 list에 추가하고 다시 넣기.

//< 궁금한 것 >


import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer,Integer> order = new HashMap<>();

        int[] answer = {};

        for(int i=0; i< genres.length; i++){
            String genre = genres[i];
            int play = plays[i];

            // 1. 순서를 기억하기 위한 해쉬 작성
            // key : play 횟수
            // value : 인덱스값
            order.put(play,i);

            // 2. 각 종류별 횟수를 기억하기 위한 해쉬 작성
            // key : 장르(claasic,pop)
            // value : play 횟수
            ArrayList<Integer> list = new ArrayList<>();
            //처음
            if(!map.containsKey(genre)){
                list.add(play);
            }
            //기존에 있으면
            else{
                list = map.get(genre);
                list.add(play);
            }
            map.put(genre,list);
        }

        //정렬
        Arrays.sort(plays);

        for(int i= plays.length-1; i>=0; i++){
            
        }



        System.out.println(map.get("classic"));




        return answer;
    }
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        베스트앨범 sol = new 베스트앨범();
        System.out.println(sol.solution(genres,plays));
    }
}
