package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/2577
// 숫자의 개수

public class baekjoon2577 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = Integer.parseInt(input.readLine());
		int B = Integer.parseInt(input.readLine());
		int C = Integer.parseInt(input.readLine());

		String multiple = (A * B * C) + "";

		int[] numCnt = new int[10];

		for (int i = 0; i < multiple.length(); i++) {
			numCnt[multiple.charAt(i) - '0']++;
		}

		for (int i = 0; i < numCnt.length; i++) {
			output.append(numCnt[i] + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}