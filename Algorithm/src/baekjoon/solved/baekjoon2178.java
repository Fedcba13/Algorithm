package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2178
// 미로 탐색

public class baekjoon2178 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] maze = new int[N][M];
		int[][] visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			String row = input.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = row.charAt(j) - '0';
			}
		}

		Queue<int[]> queue = new LinkedList<>(); //{x, y, 거리}
		queue.add(new int[] {0, 0, 1});
		visit[0][0] = 1;

		int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while (queue.isEmpty() == false) {
			int[] cur = queue.poll();

			if (cur[0] == N-1 && cur[1] == M-1) {
				output.append(cur[2] + "\n");
				break;
			}

			for (int i = 0; i < move.length; i++) {
				int[] next = new int[] {cur[0] + move[i][0], cur[1] + move[i][1], cur[2] + 1};

				if (next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < M && visit[next[0]][next[1]] == 0 && maze[next[0]][next[1]] == 1) {
					queue.add(next);
					visit[next[0]][next[1]] = 1;
				}
			}

		}


		output.flush();
		output.close();
		input.close();
	}
}