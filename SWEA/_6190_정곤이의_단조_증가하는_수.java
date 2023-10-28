package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6190_정곤이의_단조_증가하는_수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int count = 1;
		while(count<=T) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			boolean danjoCheck = true;

			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
//					if(arr[i]>arr[j]) {
//						danjoCheck = false;
//						break;
//					}
					int num = arr[i] * arr[j];
					if(danjoPlus(String.valueOf(num))) {
						if(max<num) {
							max = num;
						}
					}
				}
				if(!danjoCheck) {
					break;
				}
			}
			if(!danjoCheck || max == 0) {
				max = -1;
			}
			System.out.printf("#%d %d\n",count,max);
			count++;
		}
	}
	static boolean danjoPlus(String num) {
		if(num.length()<2) {
			return false;
		}

		for(int i=0; i<num.length(); i++) {
			int first = num.charAt(i) - '0';
			for(int j=i+1; j<num.length(); j++) {
				int second = num.charAt(j)-'0';
				if(first>second) {
					return false;
				}
			}
		}
		return true;
	}

}
