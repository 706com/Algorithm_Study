package 프로그래머스.Lv3;

//소요시간 : 19분

class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+triangle[i][j]);
                if(j!=i){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j]+triangle[i][j]);
                }
            }
        }
        // for(int[] x : dp){
        //     System.out.println(Arrays.toString(x));
        // }
        for(int x : dp[triangle.length-1]){
            answer = Math.max(answer,x);
        }
        return answer;
    }
}