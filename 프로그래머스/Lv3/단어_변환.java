package 프로그래머스.Lv3;

//소요시간 : 30분
//[240613] : 17분 🔍

import java.util.*;

class 단어_변환 {

    /*
    * HashMap + Queue 풀이
    * */
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target,words);

        return answer;
    }
    public int bfs(String begin,String target, String[] words){
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(begin,0);

        while(!q.isEmpty()){
            String curWord = q.poll();
            for(int i=0; i<words.length; i++){
                if(!hm.containsKey(words[i]) && check(curWord,words[i])){
                    q.offer(words[i]);
                    hm.put(words[i],hm.get(curWord)+1);
                }
            }
            if(hm.containsKey(target)){
                return hm.get(target);
            }
        }
        return 0;
    }
    public boolean check(String curWord, String otherWord){
        int count = 0;
        for(int i=0; i<curWord.length(); i++){
            if(curWord.charAt(i) != otherWord.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }

    /*
    * DFS 풀이
    * */

    static boolean[] visited;
    static int answer;
    public int solution2(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];

        dfs(begin,target,words,0);
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        return answer;
    }
    public void dfs(String begin,String target, String[] words, int depth){
        if(begin.equals(target)){
            int result = depth;
            answer = Math.min(answer,result);
            return;
        }

        for(int i=0; i<words.length; i++){
            if(!visited[i] && check(begin,words[i])){
                visited[i] = true;
                dfs(words[i],target,words,depth+1);
                visited[i] = false;
            }
        }
    }
    public boolean check2(String begin, String word){
        int count = 0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i) != word.charAt(i)){
                count ++;
            }
        }
        //다른게 오직 한 개
        if(count == 1){
            return true;
        }
        return false;
    }
}