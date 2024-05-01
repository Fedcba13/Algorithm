package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11726
// 2×n 타일링

public class baekjoon11726 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(input.readLine());

		if (n == 1) {
			output.append("1");
		} else if (n == 2) {
			output.append("2");
		} else {
			int[] tile = new int[n + 1];

			tile[1] = 1;
			tile[2] = 2;

			for (int i = 3; i < tile.length; i++) {
				tile[i] = (tile[i-1] + tile[i-2]) % 10007;
			}
			output.append(tile[n] + "");
		}

		output.flush();
		output.close();
		input.close();
	}
}