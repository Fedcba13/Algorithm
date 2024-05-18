package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11723
// 집합

public class baekjoon11723 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int M = Integer.parseInt(input.readLine()); //연산의 수

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());

			String command = st.nextToken();

			if (command.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			} else if (command.equals("remove")) {
				set.remove(Integer.parseInt(st.nextToken()));
			} else if (command.equals("check")) {
				output.append((set.contains(Integer.parseInt(st.nextToken())) == true ? 1 : 0) + "\n");
			} else if (command.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if (set.contains(num)) {
					set.remove(num);
				} else {
					set.add(num);
				}
			} else if (command.equals("all")) {
				set.clear();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
			} else if (command.equals("empty")) {
				set.clear();
			}

		}

		output.flush();
		output.close();
		input.close();
	}
}