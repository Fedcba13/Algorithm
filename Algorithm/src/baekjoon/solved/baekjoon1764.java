package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/1764
// 듣보잡

public class baekjoon1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람의 수
		int M = Integer.parseInt(st.nextToken()); //보도 못한 사람의 수

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N + M - 1; i++) {
			String name = input.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		ArrayList<String> list = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key) == 2) {
				list.add(key);
			}
		}

		Collections.sort(list);

		output.append(list.size() + "\n");
		for (int i = 0; i < list.size(); i++) {
			output.append(list.get(i) + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}