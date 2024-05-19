package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9019
// DSLR

public class baekjoon9019 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(input.readLine()); //테스트 케이스의 수

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(input.readLine());
			boolean[] visit = new boolean[10000];
			String answer = "";

			int num = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			Queue<Node> queue = new LinkedList<>();

			queue.add(new Node(num, ""));

			while (!queue.isEmpty()) {
				Node cur = queue.poll();

				if (cur.num == target) {
					answer = cur.str;
					break;
				} else if (visit[cur.num]) {
					continue;
				} else {
					visit[cur.num] = true;
				}

				Node D = new Node(cur.num * 2 % 10000, cur.str + "D");

				Node S = new Node(cur.num == 0 ? 9999 : cur.num - 1, cur.str + "S");

				int[] tempArr = new int[4];
				int tmpNum = cur.num;

				int index = 2;
				for (int j = 0; j < 4; j++) {
					if (index < 0) {
						index = 3;
					}
					tempArr[index] = tmpNum % 10;
					tmpNum /= 10;
					index--;
				}

				tmpNum = 0;
				for (int j = 0; j < 4; j++) {
					tmpNum *= 10;
					tmpNum += tempArr[j];
				}
				Node L = new Node(tmpNum, cur.str + "L");

				tempArr = new int[4];
				tmpNum = cur.num;

				index = 0;
				for (int j = 0; j < 4; j++) {
					if (index < 0) {
						index = 3;
					}
					tempArr[index] = tmpNum % 10;
					tmpNum /= 10;
					index--;
				}
				tmpNum = 0;
				for (int j = 0; j < 4; j++) {
					tmpNum *= 10;
					tmpNum += tempArr[j];
				}
				Node R = new Node(tmpNum, cur.str + "R");

				queue.add(D);
				queue.add(S);
				queue.add(L);
				queue.add(R);
			}
			output.append(answer + "\n");
		}


		output.flush();
		output.close();
		input.close();
	}

	static class Node {
		int num;
		String str;

		Node(int num, String str) {
			this.num = num;
			this.str = str;
		}
	}

}