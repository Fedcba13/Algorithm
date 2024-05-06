package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10026
// 적록색약

public class baekjoon10026 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(input.readLine()); //칸의 수
		char[][][] grid = new char[2][N][N]; //0 : 정상인, 1 : 적록색약
		int[][][] visit = new int[2][N][N];

		for (int i = 0; i < N; i++) {
			String str = input.readLine();

			for (int j = 0; j < str.length(); j++) {
				char tmp = str.charAt(j);
				grid[0][i][j] = tmp;

				if (tmp == 'G') {
					tmp = 'R';
				}
				grid[1][i][j] = tmp;
			}
		}

		int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<int[]> queue = new LinkedList<>();

		for (int k = 0; k < 2; k++) {
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[k][i][j] == 0) {
						result++;
						queue.add(new int[] {i, j});
						visit[k][i][j] = 1;

						while(queue.isEmpty() == false) {
							int[] cur = queue.poll();

							for (int l = 0; l < move.length; l++) {
								int[] next = new int[] {cur[0] + move[l][0], cur[1] + move[l][1]};
								if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < N && visit[k][next[0]][next[1]] == 0 && grid[k][cur[0]][cur[1]] == grid[k][next[0]][next[1]]) {
									visit[k][next[0]][next[1]] = 1;
									queue.add(next);
								}
							}
						}
					}
				}
			}
			output.append(result + " ");
		}
		


		output.flush();
		output.close();
		input.close();
	}
}