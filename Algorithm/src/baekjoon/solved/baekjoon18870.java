package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/18870
// 좌표 압축

public class baekjoon18870 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine()); //좌표의 개수
		int[] answer = new int[N];

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(input.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.get(num) == null) {
				map.put(num, new ArrayList<>());
			}
			map.get(num).add(i);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (Integer key : map.keySet()) {
			pq.add(key);
		}

		int tmp = 0;
		while (!pq.isEmpty()) {
			int key = pq.poll();
			for (Integer index : map.get(key)) {
				answer[index] = tmp;
			}
			tmp++;
		}

		for (int i = 0; i < N; i++) {
			output.append(answer[i] + " ");
		}

		output.flush();
		output.close();
		input.close();
	}
}