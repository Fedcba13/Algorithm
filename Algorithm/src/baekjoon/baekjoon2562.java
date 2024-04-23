package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2562
// 최댓값

public class baekjoon2562 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = -1;
		int index = -1;
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(input.readLine());
			if (max < num) {
				max = num;
				index = i+1;
			}
		}

		output.append(max + "\n" + index);

		output.flush();
		output.close();
		input.close();
	}
}