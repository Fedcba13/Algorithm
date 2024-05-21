package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9375
// 패션왕 신해빈

public class baekjoon9375 {

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(input.readLine()); //테스트 케이스의 수

		for (int i = 0; i < T; i++) {
			HashMap<String, Set<String>> map = new HashMap<>();

			int n = Integer.parseInt(input.readLine()); //가지고 있는 의상의 수

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(input.readLine());

				String clothes = st.nextToken();
				String type = st.nextToken();

				if (!map.containsKey(type)) {
					map.put(type, new HashSet<>());
				}
				map.get(type).add(clothes);
			}

			int answer = 1;
			for (String key : map.keySet()) {
				map.get(key).add("nothing");
				answer *= map.get(key).size();
			}

			output.append((answer - 1)+ "\n");

		}

		output.flush();
		output.close();
		input.close();
	}
}