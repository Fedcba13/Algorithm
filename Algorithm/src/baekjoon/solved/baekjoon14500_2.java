package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14500
// 테트로미노

public class baekjoon14500_2 {

	final static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(st.nextToken()); //세로 크기
		int M = Integer.parseInt(st.nextToken()); //가로 크기

		int[][] paper = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(paper, visit, i, j, paper[i][j], 1);
				visit[i][j] = false;
			}
		}

		output.append(max + "\n");

		output.flush();
		output.close();
		input.close();
	}

	static void dfs(int[][] paper, boolean[][] visit, int i, int j, int sum, int depth) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int k = 0; k < move.length; k++) {
			int[] next = new int[] {i + move[k][0], j + move[k][1]};

			if (0 <= next[0] && next[0] < paper.length && 0 <= next[1] && next[1] < paper[i].length && visit[next[0]][next[1]] == false) {
				if (depth == 2) {
					visit[next[0]][next[1]] = true;
					dfs(paper, visit, i, j, sum + paper[next[0]][next[1]], depth + 1);
					visit[next[0]][next[1]] = false;
				}
				visit[next[0]][next[1]] = true;
				dfs(paper, visit, next[0], next[1], sum + paper[next[0]][next[1]], depth + 1);
				visit[next[0]][next[1]] = false;
			}
		}


	}
}