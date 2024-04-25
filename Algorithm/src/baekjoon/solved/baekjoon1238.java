package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1238
// 파티

public class baekjoon1238 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 99999999;
		StringTokenizer st = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생의 수
		int M = Integer.parseInt(st.nextToken()); // 도로의 수
		int X = Integer.parseInt(st.nextToken()) - 1; // 파티 위치[1index -> 0index]

		int[][] route = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					route[i][j] = MAX;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());

			route[start][end] = dist;
		}

		//모든 거리 계산
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					route[i][j] = Math.min(route[i][j], route[i][k] + route[k][j]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, route[i][X] + route[X][i]);
		}

		output.append(max + "");
		
		output.flush();
		output.close();
		input.close();
	}
}