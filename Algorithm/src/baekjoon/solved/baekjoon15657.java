package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15657
// N과 M (8)

public class baekjoon15657 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(input.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			dfs(N, M, arr, output, i, 1 , arr[i] + "");
		}

		output.flush();
		output.close();
		input.close();
	}

	static void dfs(int N, int M, int[] arr, BufferedWriter output, int index, int cnt, String str) throws Exception {
		if (M == cnt) {
			output.append(str + "\n");
			return;
		}

		for (int i = index; i < N; i++) {
			dfs(N, M, arr, output, i, cnt + 1, str + " " + arr[i]);
		}
	}
}