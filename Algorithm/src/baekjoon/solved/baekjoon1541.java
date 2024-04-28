package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1541
// 잃어버린 괄호

public class baekjoon1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int result = 0;

		String str = input.readLine();

		String[] test = str.split("\\-");

		for (int i = 0; i < test.length; i++) {
			String[] tmp = test[i].split("\\+");
			int tmpResult = 0;
			for (int j = 0; j < tmp.length; j++) {
				tmpResult += Integer.parseInt(tmp[j]);
			}
			test[i] = tmpResult + "";
		}

		for (int i = 0; i < test.length; i++) {
			if (i == 0) {
				result = Integer.parseInt(test[i]);
			} else {
				result -= Integer.parseInt(test[i]);
			}
		}

		output.append(result + "");

		output.flush();
		output.close();
		input.close();
	}
}