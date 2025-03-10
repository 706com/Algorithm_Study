package 프로그래머스.Lv2;

//소요시간 : 17분 (시간초과 : 최적화)
//소요시간 : 12분 (같은실수)
//[240613] : 6분
//[250208] : 4분

class 타겟_넘버 {
    static int count = 0;
    public int solution(int[] numbers, int target) {

        dfs(0,0,numbers,target);
        return count;
    }
    public void dfs(int depth,int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }
        dfs(depth+1,sum+numbers[depth],numbers,target);
        dfs(depth+1,sum-numbers[depth],numbers,target);
    }
}

//아래는 같은 정답코드 이지만, 시간초과 발생 : 굳이 for문을 돌릴 필요가 없음!

//class 타겟_넘버 {
//    static int answer = 0;
//    static boolean[] visited;
//
//    public int solution(int[] numbers, int target) {
//
//        visited = new boolean[numbers.length];
//        dfs(0,0,0,numbers,target);
//
//        return answer;
//    }
//    public void dfs(int start,int depth,int sum,int[] numbers,int target){
//        if(depth == numbers.length){
//            if(sum == target){
//                answer++;
//            }
//            return;
//        }
//
//        for(int i=start; i<numbers.length; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                dfs(i,depth+1,sum+numbers[i],numbers,target);
//                dfs(i,depth+1,sum-numbers[i],numbers,target);
//                visited[i] = false;
//            }
//        }
//    }
//}