package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11279
// 최대 힙

public class baekjoon11279 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine()); //연산의 개수
		MaxHeap maxHeap = new MaxHeap();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(input.readLine());

			if (num != 0) {
				maxHeap.add(num);
			} else {
				output.append(maxHeap.remove() + "\n");
			}
		}

		output.flush();
		output.close();
		input.close();
	}

	static class MaxHeap {
		int[] heap = new int[100001];
		int heapSize = 0;

		MaxHeap() {

		}

		void add(int num) {
			heap[++heapSize] = num;

			int index = heapSize;

			while (index != 1) {
				if (heap[index / 2] < heap[index]) {
					int temp = heap[index / 2];
					heap[index / 2] = heap[index];
					heap[index] = temp;
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
				int answer = heap[1];
				heap[1] = heap[heapSize];
				heap[heapSize--] = 0;

				int index = 1;

				while (index <= heapSize) {
					int left = index * 2;
					int right = index * 2 + 1;
					int target = 0;

					if (heapSize < left) {
						break;
					} else if (heapSize < right) {
						target = left;
					} else {
						if (heap[left] >= heap[right]) {
							target = left;
						} else {
							target = right;
						}
					}

					if (heap[target] > heap[index]) {
						int temp = heap[index];
						heap[index] = heap[target];
						heap[target] = temp;
						index = target;
					} else {
						break;
					}
				}

				return answer;
			}
		}

	}

}