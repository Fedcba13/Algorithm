package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1987
// 알파벳

public class baekjoon1987 {

	final static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int answer = 0;
	static int R = 0;
	static int C = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] board = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = input.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		HashSet<Character> visited = new HashSet<>();
		visited.add(board[0][0]);
		dfs(board, 0, 0, 1, visited);

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}

	static void dfs(char[][] board, int i, int j, int cnt, HashSet<Character> visited) {
		answer = Math.max(answer, cnt);

		for (int[] move : moves) {
			int[] next = new int[] {i + move[0], j + move[1], cnt + 1};

			if (0 <= next[0] && next[0] < R && 0 <= next[1] && next[1] < C && !visited.contains(board[next[0]][next[1]])) {
				visited.add(board[next[0]][next[1]]);
				dfs(board, next[0], next[1], next[2], visited);
				visited.remove(board[next[0]][next[1]]);
			}
		}

	}

}