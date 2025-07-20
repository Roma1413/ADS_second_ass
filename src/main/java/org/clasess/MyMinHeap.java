package org.clasess;
public class MyMinHeap {
    private MyArrayList<Integer> heap = new MyArrayList<>();

    public void add(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public int peek() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    public int poll() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                swap(i, parent);
                i = parent;
            } else break;
        }
    }

    private void heapifyDown(int i) {
        int left, right, smallest;
        while ((left = 2 * i + 1) < heap.size()) {
            right = left + 1;
            smallest = left;
            if (right < heap.size() && heap.get(right) < heap.get(left))
                smallest = right;
            if (heap.get(i) > heap.get(smallest)) {
                swap(i, smallest);
                i = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
