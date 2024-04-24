package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1389
// 케빈 베이컨의 6단계 법칙

public class baekjoon1389 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //유저의 수
		int M = Integer.parseInt(st.nextToken()); //친구 관계의 수

		int[][] dist = new int[N+1][N+1];

		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i != j) {
					dist[i][j] = 99999999;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			dist[start][end] = 1;
			dist[end][start] = 1;

		}

		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int min = 99999999;
		int index = -1;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				dist[i][0] += dist[i][j];
			}
			if (min > dist[i][0]) {
				min = dist[i][0];
				index = i;
			}
		}

		output.append(index + "");

		output.flush();
		output.close();
		input.close();
	}
}