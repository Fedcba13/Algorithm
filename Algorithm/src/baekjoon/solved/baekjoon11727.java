package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11727
// 2×n 타일링 2

public class baekjoon11727 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] tile = new int[1002];
		int n = Integer.parseInt(input.readLine());

		tile[1] = 1;
		tile[2] = 3;

		for (int i = 3; i <= n; i++) {
			tile[i] += tile[i-1]; //1 * 2 타일
			tile[i] += tile[i-2]; //2 * 1 타일
			tile[i] += tile[i-2]; //2 * 2 타일
			tile[i] %= 10007;
		}

		output.append(tile[n] + "");

		output.flush();
		output.close();
		input.close();
	}
}