package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2805
// 나무 자르기

public class baekjoon2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //나무의 수
		int M = Integer.parseInt(st.nextToken()); //필요한 나무의 길이

		Integer[] trees = new Integer[N];
		int height = 0;
		st = new StringTokenizer(input.readLine());

		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			height = Math.max(height, trees[i]);
		}

		Arrays.sort(trees, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int index = 0;
		int cur = 0;

		for (; height >= 0; height--) {
			for (int j = index; j < trees.length; j++) {
				if (trees[j] > height) {
					index++;
				} else {
					break;
				}
			}
			cur += index;
			if (cur >= M) {
				break;
			}
		}

		output.append(height + "");

		output.flush();
		output.close();
		input.close();
	}
}