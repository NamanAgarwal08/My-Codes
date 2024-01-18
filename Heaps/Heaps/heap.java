// package Heaps;

// Heap(properties):

// 1-> Binary Tree:
//     at most 2 children

// 2-> Complete Binary Tree:
//     CBT is a BT in which all the levels are completely filled except possibly the last one, which is filled from left to right;

// 3-> Heap Order Property:
//     Children >= Parent (minHeap)
//     Children <= Parent (maxHeap)

//Note:
//Heap is never implemented as class as it would take more time(O(n)) to add or remove an element and it will be very large time interval for this process as we have already studied that it should be O(logn).
// that's why we implement heap as arraylist where we try to show parent child relationship as minHeap or maxHeap

//Impt.
// In array list:
// if node is at index i, then:
// its left child will be at (2*i + 1), and
// its right child will be at (2*i + 2)

//Insert function:
// for inserting(add) an element in heap(arraylist):
// step-1. add element at last index.
// step-2. fix heap (for minHeap):
//     while(child.val < parent.val){
//         swap(child,parent)
//
// impt:
// if we want to insert(add) the value in heap at index x, then (always)
// the corressponding parent node index will be (x-1)/2


//Delete function:
// deleting in minHeap means deleting the minimum element in the heap i.e. the root node value.
//It is a three step process :
// 1. swap first and last index element.
// 2. remove last element from arraylist (O(1)).
// 3. fix the heap (so that it will retain its properties). [heapify] [(logn)]

import java.util.*;

public class heap {

    //implementing Heap with arraylist
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // 1. add at last index.
            arr.add(data);

            //2. fix heap
            int x = arr.size() - 1; // x is child index
            int par = (x - 1) / 2; // par is parent index

            while (arr.get(x) < arr.get(par)) { //O(logn)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public int remove() { // O(logn)
            int data = arr.get(0);

            // step-1: swap first and last index
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, data);

            //step-2: remove last element
            arr.remove(arr.size() - 1);

            // step-3: fix the Heap (heapify function)
            heapify(0);

            return data;
        }

        //it is a private function to fix the heap after making changes to it which can't be used outside the class
        private void heapify(int idx) {
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int minIdx = idx;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != idx) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }

        }
        
        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }
    
    public static void main(String args[]) {
        Heap h = new Heap();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) { // heap sort (O(nlogn))
            System.out.println(h.peek());
            h.remove();
        }
    }

}
