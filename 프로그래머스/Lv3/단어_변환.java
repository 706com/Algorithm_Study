package 프로그래머스.Lv3;

//소요시간 : 23분

class 단어_변환 {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];

        dfs(begin,target,words,answer);
        return answer;
    }
    public void dfs(String begin,String target, String[] words, int depth){
        if(begin.equals(target)){
            answer = depth;
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
    public boolean check(String begin, String word){
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