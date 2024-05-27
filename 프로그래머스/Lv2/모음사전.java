package 프로그래머스.Lv2;

//소요시간 : 59분
//[240527] : 20분

class Solution {
    static int N;
    static String[] arr;
    static String[] output;
    static int count = 0;
    static boolean end = false;
    public int solution(String word) {
        int answer = 0;
        N = 5;
        int len = word.length();
        arr = new String[]{"A","E","I","O","U"};
        output = new String[5];

        dfs(0, 0,len,word);
        return count -1;
    }

    public void dfs(int start, int depth, int len,String word){
        if(end){
            return;
        }
        count++;
        if(depth == len){
            String str = "";
            for(int i=0; i<depth; i++){
                str += output[i];
            }
            // System.out.println(str+" : "+count);
            if(str.equals(word)){
                end = true;
                return;
            }
        }
        if(depth == N){
            // System.out.println(Arrays.toString(output)+" : "+count);
            return;
        }

        for(int i=0; i<N; i++){
            output[depth] = arr[i];
            dfs(i,depth+1,len,word);
            if(end){
                return;
            }
        }
    }
}