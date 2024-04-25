package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1620
// 나는야 포켓몬 마스터 이다솜

public class baekjoon1620 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //포켓몬의 개수
		int M = Integer.parseInt(st.nextToken()); //문제의 개수

		HashMap<String, String> dogam = new HashMap<>();


		for (int i = 1; i <= N; i++) {
			String pokemon = input.readLine();

			dogam.put(i + "", pokemon);
			dogam.put(pokemon, i + "");
		}

		for (int i = 0; i < M; i++) {
			String quiz = input.readLine();

			output.append(dogam.get(quiz) + "\n");
		}


		output.flush();
		output.close();
		input.close();
	}
}