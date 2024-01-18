// package HeapSort;


// for sorting in ascending order => we have to make maxHeap.
// for sorting in descending order => we have to make minHeap.
public class heapsort {

    public static void heapSort(int arr[]) { // O(n*logn)
        // step-1. Build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) { // we have to make call for all nodes except leaf nodes (call fo all non-leaf nodes).
            heapify(arr,i, n);
        }

        // step-2. Push largest at end
        for (int i = n - 1; i > 0; i--) {
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,0, i);
        }

    }
    
    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }
    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 5, 3, 0 };
        heapSort(arr);

        //print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(2.0/3);
    }
}
