package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1074
// Z

public class baekjoon1074 {

	static int index = 0;
	static int answer = 0;
	static int r = 0;
	static int c = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); // 배열의 크기
		r = Integer.parseInt(st.nextToken()); // 목표 행
		c = Integer.parseInt(st.nextToken()); // 목표 열

		int size = (int) Math.pow(2, N);

		bfs(0, 0, size -1, size - 1);

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}

	static void bfs(int i, int j, int k, int l) {
		if (answer != 0) {
			return;
		}

		if (i == k && j == l) {
			if (i == r && j == c) {
				answer = index;
			}
			index++;
		} else if (i <= r && r <= k && j <= c && c <= l) {
			bfs(i, j, (i + k) / 2, (j + l) / 2);
			bfs(i, (j + l) / 2 + 1, (i + k) / 2, l);
			bfs((i + k) / 2 + 1, j, k, (j + l) / 2);
			bfs((i + k) / 2 + 1, (j + l) / 2 + 1, k, l);
		} else {
			index += Math.pow(k - i + 1, 2);
		}

	}

}