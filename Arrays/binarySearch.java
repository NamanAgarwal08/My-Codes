public class binarySearch {
    
    public static int binarySearch(int array[], int element, int start, int end) {
        if (element < array[0] || element > array[array.length - 1]) {
            return -1;
        }
        else {
            if (element == array[((start + end) / 2)]) {
                return (start + end) / 2;
            } else if (element > array[((start + end) / 2)]) {
                return binarySearch(array, element, (start + end) / 2, end);
            } else {
                return binarySearch(array, element, start, (start + end) / 2);
            }
        }
        
    }
    public static void main(String args[]) {
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int element = 1;
        System.out.println(binarySearch(array, element,0,array.length));
    }
}
