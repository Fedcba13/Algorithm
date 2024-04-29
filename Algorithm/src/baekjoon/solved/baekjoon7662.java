package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7662
// 이중 우선순위 큐

public class baekjoon7662 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		HashMap<Integer, Integer> nums = new HashMap<>();
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		int T = Integer.parseInt(input.readLine()); //테스트케이스의 개수

		for (int i = 0; i < T; i++) {
			int cnt = Integer.parseInt(input.readLine()); //입력 개수
			nums.clear();
			minQueue.clear();
			maxQueue.clear();

			for (int j = 0; j < cnt; j++) {
				st = new StringTokenizer(input.readLine());

				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (command.equals("I")) {
					minQueue.add(num);
					maxQueue.add(num);
					nums.put(num, nums.getOrDefault(num, 0) + 1);
				} else {
					PriorityQueue<Integer> targetQueue;
					if (num == 1) {
						targetQueue = maxQueue;
					} else {
						targetQueue = minQueue;
					}
					while (targetQueue.isEmpty() == false) {
						num = targetQueue.poll();
						if (nums.get(num) != null) {
							if (nums.get(num) == 1) {
								nums.remove(num);
							} else {
								nums.put(num, nums.get(num) - 1);
							}
							break;
						}
					}

				}
			}

			while (maxQueue.isEmpty() == false) {
				int num = maxQueue.poll();

				if (nums.get(num) != null) {
					output.append(num + " ");
					break;
				}
			}

			while (minQueue.isEmpty() == false) {
				int num = minQueue.poll();

				if (nums.get(num) != null) {
					output.append(num + " \n");
					break;
				}
			}

			if (nums.isEmpty()) {
				output.append("EMPTY\n");
			}

		}

		output.flush();
		output.close();
		input.close();
	}
}