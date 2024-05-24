package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15652
// N과 M (4)

public class baekjoon15652 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			dfs(N, M, output, i, 1, i + "");
		}

		output.flush();
		output.close();
		input.close();
	}

	static void dfs(int N, int M, BufferedWriter output, int index, int cnt, String str) throws Exception {
		if (M == cnt) {
			output.append(str + "\n");
			return;
		}

		for (int i = index; i <= N; i++) {
			dfs(N, M, output, i, cnt+1, str + " " + i);
		}

	}

}