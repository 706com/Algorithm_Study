package BOJ._1_Bronze;

//소요시간 : 20분(실패) : 답봄
//소요시간 : 4분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1919_애너그램_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        int result =0;

        String word1 = br.readLine();
        String word2 = br.readLine();

        // 첫번째 배열에 첫번째 단어 알파벳 개수 저장
        for(char c : word1.toCharArray()){
            alpha1[(c-'0')-49]++;
        }

        // 두번째 배열에 두번째 단어 알파벳 개수 저장
        for(char c : word2.toCharArray()){
            alpha2[(c-'0')-49]++;
        }

        // 애너그램 조건 : 결국 "같은 문자열" 이어야 한다.
        // 빼야 할 개수 = a~z 까지 살펴봐서 차이가 있는만큼 빼야함
        for(int i=0; i<26; i++){
            result += Math.abs(alpha1[i]-alpha2[i]);
        }
        System.out.println(result);

    }
}
