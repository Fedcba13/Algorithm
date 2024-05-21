package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17626
// Four Squares

public class baekjoon17626 {

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine());

		for (int i = (int) Math.sqrt(N); i > (int) Math.sqrt(N) / 2; i--) {
			dfs(N, i * i, 1);
		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}

	static void dfs(int N, int cur, int cnt) {
		if (answer <= cnt) {
			return;
		}

		if (cur == N) {
			answer = cnt;
			return;
		}

		for (int i = (int) Math.sqrt(N - cur); i > (int) Math.sqrt(N - cur) / 2; i--) {
			dfs(N, cur + i * i, cnt + 1);
		}

	}

}