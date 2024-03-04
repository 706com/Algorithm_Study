package 프로그래머스.Lv2;

//소요시간 : 59분

class 모음사전 {
    static int N;
    static String[] arr = {"A","E","I","O","U"};
    static int answer = -1;
    static boolean end = false;
    StringBuffer sb = new StringBuffer();
    public int solution(String word) {
        N = arr.length;

        dfs(0,0,word);
        return answer;
    }
    public void dfs(int start, int depth, String word){
        answer++;
        System.out.println(sb);
        if(word.equals(sb.toString())){
            System.out.println("correct"+" "+ answer);
            end = true;
            return;
        }
        if(depth >= 5){
            return;
        }
        for(int i=0; i<N; i++){
            sb.append(arr[i]);
            dfs(i,depth+1,word);
            if(end){
                return;
            }
            sb.deleteCharAt(depth);
        }

    }
}