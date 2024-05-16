package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15650
// N과 M (2)

public class baekjoon15650 {

	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		// 1~N까지 자연수 중 중복 없이 M개 고른 수열
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			dfs(N, M, i, 1, i+"");
		}

		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				output.append("\n");
			}
			output.append(list.get(i));
		}

		output.flush();
		output.close();
		input.close();
	}

	static void dfs(int N, int M, int index, int cnt, String str) {
		if (M == cnt) {
			list.add(str);
			return;
		}

		if ((N - index) + cnt < M) {
			return;
		}

		for (int i = index + 1; i <= N; i++) {
			dfs(N, M, i, cnt+1, str + " " + i);
		}

	}
}