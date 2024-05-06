package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11286
// 절댓값 힙

public class baekjoon11286 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		Heap heap = new Heap();
		int N = Integer.parseInt(input.readLine()); //연산의 개수

		for (int i = 0; i < N; i++) {
			int oper = Integer.parseInt(input.readLine());

			if (oper != 0) {
				heap.add(oper);
			} else {
				output.append(heap.remove() + "\n");
			}
		}

		output.flush();
		output.close();
		input.close();
	}

	static class Heap {
		int[][] heap = new int[100001][2];
		int heapSize = 0;

		Heap() {

		}

		void add(int num) {
			heapSize++;
			heap[heapSize][0] = Math.abs(num);
			heap[heapSize][1] = num;

			int index = heapSize;
			while (index != 1) {
				int[] cur = heap[index];
				int[] next = heap[index / 2];

				if ((cur[0] < next[0]) || (cur[0] == next[0] && cur[1] < next[1])) {
					int[] tmp = next.clone();
					next[0] = cur[0];
					next[1] = cur[1];
					cur[0] = tmp[0];
					cur[1] = tmp[1];

					index = index / 2;
				} else {
					break;
				}
			}

		}

		int remove() {
			if (heapSize == 0) {
				return 0;
			} else {
				int result = heap[1][1];

				heap[1] = heap[heapSize].clone();
				heap[heapSize][0] = 0;
				heap[heapSize][1] = 0;
				heapSize--;

				int index = 1;

				while (index <= heapSize) {
					int left = index * 2;
					int right = index * 2 + 1;
					int target = 0;

					if (left > heapSize) {
						break;
					} else if (right > heapSize) {
						target = left;
					} else if (heap[left][0] < heap[right][0]) {
						target = left;
					} else if (heap[left][0] == heap[right][0]) {
						if (heap[left][1] <= heap[right][1]) {
							target = left;
						} else {
							target = right;
						}
					} else {
						target = right;
					}

					if ((heap[target][0] < heap[index][0]) || (heap[target][0] == heap[index][0] && heap[target][1] < heap[index][1])) {
						int[] tmp = heap[target].clone();
						heap[target][0] = heap[index][0];
						heap[target][1] = heap[index][1];
						heap[index][0] = tmp[0];
						heap[index][1] = tmp[1];

						index = target;
					} else {
						break;
					}

				}

				return result;
			}
		}

	}

}