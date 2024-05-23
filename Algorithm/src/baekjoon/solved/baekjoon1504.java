package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1504
// 특정한 최단 경로

public class baekjoon1504 {

	static final int INF = 99999999;

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken()); //간선의 개수

		int[][] route = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					route[i][j] = INF;
				}
			}
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(input.readLine());

			int a = Integer.parseInt(st.nextToken()); //a번 정점
			int b = Integer.parseInt(st.nextToken()); //b번 정점
			int c = Integer.parseInt(st.nextToken()); //거리

			route[a][b] = c;
			route[b][a] = c;
		}

		st = new StringTokenizer(input.readLine());

		//거쳐야 하는 정점
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					route[i][j] = Math.min(route[i][j], route[i][k] + route[k][j]);
				}
			}
		}

		int answer = Math.min(route[1][v1] + route[v1][v2] + route[v2][N], route[1][v2] + route[v2][v1] + route[v1][N]);
		if (answer >= INF) {
			answer = -1;
		}

		output.append(answer + "");
		output.flush();
		output.close();
		input.close();
	}
}