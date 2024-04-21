package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1157
// 단어 공부

public class baekjoon1157_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = input.readLine().toUpperCase();

		int[] alpha = new int[26];
		int max = 0;
		char answer = ' ';

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 65;
			alpha[index]++;
			max = Math.max(max, alpha[index]);
		}

		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] == max) {
				if (answer == ' ') {
					answer = (char) (i + 65);
				} else {
					answer = '?';
					break;
				}
			}
		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}
}