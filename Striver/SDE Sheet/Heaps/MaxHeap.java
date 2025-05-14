public class MaxHeap {

    int[] arr = new int[10];
    int size;

    MaxHeap() {
        arr[0] = -1;
        size = 0;
    }

    private void insert(int val) {
        size++;
        int index = size;
        arr[index] = val;

        while (index > 1) {
            int parent = index / 2;

            if (arr[parent] < arr[index]) {
                swap(arr, index, parent);
                index = parent;
            } else {
                return;
            }
        }
    }

    private void delete() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return;
        }

        arr[1] = arr[size];
        arr[size] = 0;
        size--;

        // take root note to its correct position
        int i = 1;
        while (i < size) {
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;

            if (leftIndex < size && arr[i] < arr[leftIndex]) {
                swap(arr, i, leftIndex);
                i = leftIndex;
            } else if (rightIndex < size && arr[i] < rightIndex) {
                swap(arr, i, rightIndex);
                i = rightIndex;
            } else {
                return;
            }
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= n && arr[largest] < arr[left]) {
            largest = left;
        }

        if (right <= n && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void print() {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);
        // h.print();

        h.delete();
        // h.print();

        // Heapify
        // int[] arr = { -1, 54, 53, 55, 52, 50 };
        // int n = 5;
        
        int[] arr = { -1, 3, 2, 1, 5, 6, 4 };
        int n = 6;
        System.out.println("Before heapify ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = n / 2; i > 0; i--) {
            h.heapify(arr, n, i);
        }

        System.out.println("After heapify ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

// import java.util.Arrays;
//
// public class MaxHeap {
// private int[] heap;
// private int size;
// private int capacity;
//
// public MaxHeap(int capacity) {
// this.capacity = capacity;
// this.heap = new int[capacity];
// this.size = 0;
// }
//
// private int parent(int index) {
// return (index - 1) / 2;
// }
//
// private int leftChild(int index) {
// return 2 * index + 1;
// }
//
// private int rightChild(int index) {
// return 2 * index + 2;
// }
//
// private void ensureExtraCapacity() {
// if (size == capacity) {
// heap = Arrays.copyOf(heap, capacity * 2);
// capacity *= 2;
// }
// }
//
// private void swap(int indexOne, int indexTwo) {
// int temp = heap[indexOne];
// heap[indexOne] = heap[indexTwo];
// heap[indexTwo] = temp;
// }
//
// public void insert(int key) {
// ensureExtraCapacity();
// heap[size] = key;
// size++;
// heapifyUp();
// }
//
// private void heapifyUp() {
// int index = size - 1;
// while (index > 0 && heap[parent(index)] < heap[index]) {
// swap(parent(index), index);
// index = parent(index);
// }
// }
//
// public int extractMax() {
// if (size == 0)
// throw new IllegalStateException();
// int max = heap[0];
// heap[0] = heap[size - 1];
// size--;
// heapifyDown();
// return max;
// }
//
// private void heapifyDown() {
// int index = 0;
// while (leftChild(index) < size) {
// int largerChildIndex = leftChild(index);
// if (rightChild(index) < size && heap[rightChild(index)] >
// heap[largerChildIndex]) {
// largerChildIndex = rightChild(index);
// }
//
// if (heap[index] > heap[largerChildIndex]) {
// break;
// } else {
// swap(index, largerChildIndex);
// }
// index = largerChildIndex;
// }
// }
//
// public int getMax() {
// if (size == 0)
// throw new IllegalStateException();
// return heap[0];
// }
//
// public int getSize() {
// return size;
// }
//
// public boolean isEmpty() {
// return size == 0;
// }
//
// private void print() {
// for (int i : heap) {
// System.out.print(i + " ");
// }
// System.out.println();
// }
//
// public static void main(String[] args) {
// MaxHeap maxHeap = new MaxHeap(10);
// maxHeap.insert(3);
// maxHeap.insert(10);
// maxHeap.insert(5);
// maxHeap.insert(6);
// maxHeap.insert(1);
// maxHeap.insert(8);
//
// System.out.println("Max value: " + maxHeap.getMax()); // 10
// System.out.println("Heap size: " + maxHeap.getSize()); // 6
// maxHeap.print();
// System.out.println("Extracted max: " + maxHeap.extractMax()); // 10
// System.out.println("New max value: " + maxHeap.getMax()); // 8
// System.out.println("Heap size after extraction: " + maxHeap.getSize()); // 5
// maxHeap.print();
// }
// }