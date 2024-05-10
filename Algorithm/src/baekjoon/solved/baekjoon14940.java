package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14940
// 쉬운 최단거리

public class baekjoon14940 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //세로의 크기
		int M = Integer.parseInt(st.nextToken()); //가로의 크기

		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					queue.add(new int[] {i, j});
					map[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}

		while (queue.isEmpty() == false) {
			int[] cur = queue.poll();

			for (int i = 0; i < move.length; i++) {
				int[] next = new int[]{cur[0] + move[i][0], cur[1] + move[i][1]};

				if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < M && visit[next[0]][next[1]] == false && map[next[0]][next[1]] == 1) {
					queue.add(next);
					map[next[0]][next[1]] = map[cur[0]][cur[1]] + 1;
					visit[next[0]][next[1]] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] == false && map[i][j] == 1) {
					map[i][j] = -1;
				}
				output.append(map[i][j] + " ");
			}
			output.append("\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}