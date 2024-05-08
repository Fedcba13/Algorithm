package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11659
// 구간 합 구하기 4

public class baekjoon11659 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //수의 개수
		int M = Integer.parseInt(st.nextToken()); //합을 구해야 하는 횟수

		int[] sum = new int[N + 1];

		st = new StringTokenizer(input.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			output.append((sum[end] - sum[start - 1]) + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}