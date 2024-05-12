package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/21736
// 헌내기는 친구가 필요해

public class baekjoon21736 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int[][] move = new int[][] {{1, 0},{-1, 0}, {0, 1}, {0, -1}};

		int N = Integer.parseInt(st.nextToken()); //캠퍼스 세로 길이
		int M = Integer.parseInt(st.nextToken()); //캠퍼스 가로 길이

		char[][] campus = new char[N][M];
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String str = input.readLine();

			for (int j = 0; j < M; j++) {
				campus[i][j] = str.charAt(j);
				if (campus[i][j] == 'I') {
					queue.add(new int[] {i, j});
					visit[i][j] = true;
				}
			}
		}

		int answer = 0;
		while (queue.isEmpty() == false) {
			int[] cur = queue.poll();

			for (int i = 0; i < move.length; i++) {
				int[] next = new int[] {cur[0] + move[i][0], cur[1] + move[i][1]};

				if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < M && visit[next[0]][next[1]] == false) {
					if (campus[next[0]][next[1]] == 'P') {
						visit[next[0]][next[1]] = true;
						answer++;
						queue.add(next);
					} else if (campus[next[0]][next[1]] == 'O') {
						visit[next[0]][next[1]] = true;
						queue.add(next);
					}
				}
			}
		}

		output.append(answer == 0 ? "TT" : answer + "");

		output.flush();
		output.close();
		input.close();
	}
}