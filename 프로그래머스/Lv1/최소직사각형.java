package 프로그래머스.Lv1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;

        int widthMax = 0;
        int heightMax = 0;

        for(int i=0; i<sizes.length; i++){
            widthMax = Math.max(Math.max(sizes[i][0],sizes[i][1]),widthMax);
            heightMax = Math.max(Math.min(sizes[i][0],sizes[i][1]),heightMax);
        }
        answer = widthMax * heightMax;

//        System.out.println(answer);
        return answer;
   }
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        최소직사각형 sol = new 최소직사각형();
        sol.solution(sizes);
    }
}
