package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/5430
// AC

public class baekjoon5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(input.readLine()); //테스트케이스의 수

		for (int i = 0; i < T; i++) {
			String p = input.readLine(); //수행할 함수

			int n = Integer.parseInt(input.readLine()); // 배열의 길이
			int[] arr = new int[n];

			String tempStr = input.readLine();
			String[] splitStr = tempStr.substring(1, tempStr.length() - 1).split(",");

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(splitStr[j]);
			}

			boolean flag = true; //true일 경우 left + 1, false일 경우 right - 1
			int left = 0;
			int right = arr.length;

			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == 'R') {
					flag = !flag;
				} else {
					if (flag) {
						left++;
					} else {
						right--;
					}
				}
			}

			if (left > right) {
				output.append("error\n");
			} else {
				output.append("[");
				if (flag) {
					for (int j = left; j < right; j++) {
						output.append(arr[j] + "");
						if (j != right - 1) {
							output.append(",");
						}
					}
				} else {
					for (int j = right - 1; j >= left; j--) {
						output.append(arr[j] + "");
						if (j != left) {
							output.append(",");
						}
					}
				}
				output.append("]\n");
			}

		}

		output.flush();
		output.close();
		input.close();
	}
}