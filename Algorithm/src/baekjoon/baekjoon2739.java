package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2739
// 구구단

public class baekjoon2739 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine());

		for (int i = 1; i <= 9; i++) {
			output.append(N + " * " + i + " = " + (N*i) + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}