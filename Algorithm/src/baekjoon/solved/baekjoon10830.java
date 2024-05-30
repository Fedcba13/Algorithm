package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10830
// 행렬 제곱

public class baekjoon10830 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //행렬의 크기
		long B = Long.parseLong(st.nextToken()); //제곱수

		int cnt = 40;

		long[][][] arr = new long[cnt + 1][N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				arr[1][i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}

		for (int i = 2; i <= cnt; i++) {
			arr[i] = multiple(arr[i-1], arr[i-1]);
		}


		int cur = cnt;
		long value = (long) Math.pow(2, cnt - 1);

		long[][] result = null;

		while (B != 0) {
			if (B >= value) {
				B-= value;
				if (result == null) {
					result = arr[cur];
				} else {
					result = multiple(result, arr[cur]);
				}
			} else {
				value /= 2;
				cur--;
			}
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				output.append(result[i][j] + " ");
			}
			output.append("\n");
		}
		
		output.flush();
		output.close();
		input.close();
	}

	static long[][] multiple(long[][] A, long[][] B) {
		long[][] result = new long[A.length][B[0].length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < A[0].length; k++) {
					result[i][j] += A[i][k] * B[k][j];
				}
				result[i][j] %= 1000;
			}
		}

		return result;
	}
}