package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기

public class baekjoon2206 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = input.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 1, 1}); //i j cnt wall

		int[][] moves = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		boolean[][][] visited = new boolean[2][N][M]; // 0 : 벽 통과 X, 1 : 벽 통과 O
		int answer = -1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == N - 1 && cur[1] == M - 1) {
				answer = cur[2];
				break;
			}

			if (cur[3] == 1) {
				if (!visited[0][cur[0]][cur[1]]) {
					visited[0][cur[0]][cur[1]] = true;
					visited[1][cur[0]][cur[1]] = true;
				} else {
					continue;
				}
			} else if (cur[3] == 0) {
				if (!visited[0][cur[0]][cur[1]] && !visited[1][cur[0]][cur[1]]) {
					visited[1][cur[0]][cur[1]] = true;
				} else {
					continue;
				}
			}

			for (int[] move : moves) {
				int[] next = new int[] {cur[0] + move[0], cur[1] + move[1], cur[2] + 1, cur[3]};

				if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < M) {
					if (map[next[0]][next[1]] == 0) { // 벽 X
						queue.add(next);
					} else if (map[next[0]][next[1]] == 1 && next[3] == 1) { // 벽 O, 통과 O
						next[3] = 0;
						queue.add(next);
					}
				}
			}

		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}
}