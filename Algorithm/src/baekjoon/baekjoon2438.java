package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2438
// 별 찍기 - 1

public class baekjoon2438 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				output.append("*");
			}
			output.append("\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}