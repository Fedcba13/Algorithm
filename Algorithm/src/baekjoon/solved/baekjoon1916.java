package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1916
// 최소비용 구하기

public class baekjoon1916 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(input.readLine()); //도시의 개수
		int M = Integer.parseInt(input.readLine()); //버스의 개수

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());

			if (map[start][end] == -1 || map[start][end] > dist) {
				map[start][end] = dist;
			}
		}

		st = new StringTokenizer(input.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;

		Queue<int[]> queue = new LinkedList<>();
		int[] visit = new int[N];
		for (int i = 0; i < N; i++) {
			visit[i] = -1;
			if (map[start][i] != -1) {
				queue.add(new int[] {start, i, map[start][i]});
				visit[i] = map[start][i];
			}
		}

		while (queue.isEmpty() == false) {
			int[] cur = queue.poll();

			if (visit[cur[1]] < cur[2]) {
				continue;
			}

			if (cur[1] == end) {
				continue;
			}

			for (int i = 0; i < N; i++) {
				if (map[cur[1]][i] != -1 && (visit[i] == -1 || cur[2] + map[cur[1]][i] < visit[i])) {
					queue.add(new int[] {cur[1], i, cur[2] + map[cur[1]][i]});
					visit[i] = cur[2] + map[cur[1]][i];
				}
			}
		}

		output.append(visit[end] + "");

		output.flush();
		output.close();
		input.close();
	}
}