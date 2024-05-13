package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16236
// 아기 상어

public class baekjoon16236 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(input.readLine());
		int[][] sea = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		int[] shark = new int[4];
		int time = 0;
		int[][] moves = {{-1, 0}, {0, -1}, {1,0 }, {0, 1}};

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());

				if (sea[i][j] == 9) {
					shark = new int[] {i, j, 2, 0};
					sea[i][j] = 0;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		while (true) {
			queue.clear();
			visit = new boolean[N][N];
			queue.add(new int[]{shark[0], shark[1], 0});
			visit[shark[0]][shark[1]] = true;
			int[] eat = null;
			int dist = Integer.MAX_VALUE;

			while (!queue.isEmpty()) {
				int[] cur = queue.poll();

				if (dist != 0 && dist < cur[2]) {
					break;
				}

				if (sea[cur[0]][cur[1]] != 0 && sea[cur[0]][cur[1]] < shark[2]) {
					if (eat == null) {
						eat = cur;
					} else {
						if (cur[0] < eat[0]) {
							eat = cur;
						} else if (cur[0] == eat[0] && cur[1] < eat[1]) {
							eat = cur;
						}
					}
					dist = cur[2];
				}

				if (dist == cur[2]) {
					continue;
				}

				for (int[] move : moves) {
					int[] next = new int[] {cur[0] + move[0], cur[1] + move[1], cur[2] + 1};

					if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < N && sea[next[0]][next[1]] <= shark[2] && !visit[next[0]][next[1]]) {
						visit[next[0]][next[1]] = true;
						queue.add(next);
					}
				}
			}

			if (eat == null) {
				break;
			} else {
				shark[0] = eat[0];
				shark[1] = eat[1];
				time += eat[2];
				shark[3]++;
				if (shark[2] == shark[3]) {
					shark[2]++;
					shark[3] = 0;
				}
				sea[shark[0]][shark[1]] = 0;
			}
		}

		output.append(time + "");

		output.flush();
		output.close();
		input.close();
	}

	static void sort (int[][] sea, int[] shark) {

	}

}