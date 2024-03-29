public class Merge_Sort {
    public static void main(String args[]) {
        int array[] = { 6, 3, 9, 5,6, 2, 8 };
        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void mergeSort(int array[], int si, int ei) {
        //base case
        if (si >= ei) {
            return;
        }
        
        //kaam
        int mid = (si + ei) / 2;
        mergeSort(array, si, mid);
        mergeSort(array, mid + 1, ei);
        mergeArray(array, si, mid, ei);
    }

    public static void mergeArray(int array[],int si ,int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i=si;
        int j=mid+1;
        int k=0;
        while (i <= mid && j <= ei) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= ei) {
            temp[k++] = array[j++];
        }
        for (k = 0, i = si; k < temp.length; k++, i++) {
            array[i] = temp[k];
        }
    }
    
}