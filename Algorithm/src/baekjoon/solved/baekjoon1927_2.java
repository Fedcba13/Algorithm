package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1927
// 최소 힙

public class baekjoon1927_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine());

		MinHeap minHeap = new MinHeap();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(input.readLine());

			if (num == 0) {
				output.append(minHeap.remove() + "\n");
			} else {
				minHeap.add(num);
			}

		}

		output.flush();
		output.close();
		input.close();
	}

	static class MinHeap {
		int[] minHeap = new int[100001];
		int size = 0;

		MinHeap() {

		}

		void add(int num) {
			minHeap[++size] = num;

			int i = size;
			while (i != 1) {
				if (minHeap[i/2] > minHeap[i]) {
					int temp = minHeap[i/2];
					minHeap[i/2] = minHeap[i];
					minHeap[i] = temp;

					i = i / 2;
				} else {
					break;
				}
			}
		}

		int remove() {
			if (size == 0) {
				return 0;
			}
			int result = minHeap[1];
			minHeap[1] = minHeap[size];
			minHeap[size--] = 0;


			int i = 1;
			while (i <= size) {
				int left = i * 2;
				int right = left + 1;
				int target = 0;

				//좌측 자식 노드와 비교
				if (left <= size && minHeap[left] < minHeap[i]) {
					target = left;
				}

				//우측 자식 노드와 비교
				if (right <= size && minHeap[right] < minHeap[i]) {
					if (target == 0 || minHeap[left] > minHeap[right]) {
						target = right;
					}
				}

				if (target != 0) {
					int temp = minHeap[target];
					minHeap[target] = minHeap[i];
					minHeap[i] = temp;

					i = target;
					continue;
				}

				break;
			}

			return result;
		}

	}

}