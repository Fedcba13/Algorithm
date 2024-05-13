package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11053
// 가장 긴 증가하는 부분 수열

public class baekjoon11053 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine()); //수열의 크기
		int[] arr = new int[N]; //수열
		int[] tmp = new int[N];

		StringTokenizer st = new StringTokenizer(input.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (tmp[i] == 0) {
				tmp[i] = 1;
				dp(arr, tmp, i, 1);
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, tmp[i]);
		}

		output.append(max + "");

		output.flush();
		output.close();
		input.close();
	}

	static void dp(int[] arr, int[] tmp, int index, int cnt) {
		if (cnt < tmp[index]) {
			return;
		}

		for (int i = index+1; i < arr.length; i++) {
			if (arr[index] < arr[i] && cnt + 1 > tmp[i]) {
				tmp[i] = cnt + 1;
				dp(arr, tmp, i, cnt+1);
			}
		}

	}
}