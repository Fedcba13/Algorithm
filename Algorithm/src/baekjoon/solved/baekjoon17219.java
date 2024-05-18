package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17219
// 비밀번호 찾기

public class baekjoon17219 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //저장된 사이트의 수
		int M = Integer.parseInt(st.nextToken()); //비밀번호를 찾으려는 사이트의 수

		HashMap<String, String> password = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());

			String site = st.nextToken();
			password.put(site, st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			String site = input.readLine();

			output.append(password.get(site) + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}