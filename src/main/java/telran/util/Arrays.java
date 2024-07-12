package telran.util;

final public class Arrays {
    private Arrays() {}

    /**
     * Search element in array.
     *
     * @param arr Array.
     * @param key Element.
     * @return Index of element in array; -1 if element not found.
     */
    public static int search(int[] arr, int key) {
        int index = 0;

        while (index < arr.length && key != arr[index]) {
            index++;
        }

        return index == arr.length ? -1 : index;
    }

    /**
     * Add element to array.
     *
     * @param arr Array.
     * @param number Element.
     * @return New array.
     */
    public static int[] add(int[] arr, int number) {
        int[] result = java.util.Arrays.copyOf(arr, arr.length + 1);

        result[arr.length] = number;

        return result;
    }

    /**
     * Insert element to array.
     *
     * @param arr Array.
     * @param index Index of inserted element.
     * @param number Element.
     * @return New array.
     */
    public static int[] insert(int[] arr, int index, int number) {
        int[] result = new int[arr.length + 1];

        System.arraycopy(arr, 0, result, 0, index);

        result[index] = number;

        System.arraycopy(arr, index, result, index + 1, arr.length - index);

        return result;
    }

    /**
     * Remove element from array.
     *
     * @param arr Array.
     * @param index Index of removed element.
     * @return New array.
     */
    public static int[] remove(int[] arr, int index) {
        int[] result = new int[arr.length - 1];

        System.arraycopy(arr, 0, result, 0, index);
        System.arraycopy(arr, index + 1, result, index,  arr.length - index - 1);

        return result;
    }

    /**
     * Swap two elements in array.
     *
     * @param arr Array.
     * @param i First element index.
     * @param j Second element index.
     * @return Passed array with swapped elements.
     */
    public static int[] swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    
        return arr;
    }

    /**
     * @return True - if array sorted, false if array unsorted.
     */
    private static boolean pushMaxAtEnd(int[] arr, int length) {
        boolean res = true;

        for(int i = 0; i < length; i++) {
            if (arr[i] > arr[i + 1]) {
                res = false;
                swap(arr, i, i + 1);
            }
        }

        return res;
    }

    /**
     * Sort array (asc).
     *
     * @param arr Array.
     * @return Sorted array.
     */
    public static int[] sort(int[] arr) {
        int length = arr.length;
        boolean isSorted = false;
        while (!isSorted) {
            length--;
            isSorted = pushMaxAtEnd(arr, length);
        }

        return arr;
    }

    /**
     * Check sorted array (asc).
     *
     * @param arr Array.
     * @return True - if sorted array, false - if unsorted array.
     */
    public static boolean isSorted(int[] arr) {
        boolean res = true;
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                res = false;
                break;
            }
        }

        return res;
    }

    /**
     * Search element in sorted array.
     *
     * @param arr Sorted array.
     * @param key Element.
     * @return Index of element in array.
     */
    public static int binarySearch(int[] arr, int key) {
        int res = -1;
        int begin = 0;
        int end = arr.length - 1;

        while (begin <= end) {
            int cur = (begin + end) / 2;

            if (arr[cur] == key) {
                res = cur;
                break;
            }

            if (arr[cur] < key) {
                begin = cur + 1;
            } else {
                end = cur - 1;
            }
        }
        
        return res != -1 ? res : -(begin + 1);
    }

    /**
     * Insert element to sorted array.
     *
     * @param arr Sorted array.
     * @param number Element.
     * @return New array.
     */
    public static int[] insertSorted(int[] arr, int number) {
        int[] result = java.util.Arrays.copyOf(arr, arr.length + 1);
        int pos = binarySearch(arr, number);

        if (pos < 0) pos = -pos - 1;

        result[pos] = number;

        System.arraycopy(arr, pos, result, pos + 1, arr.length - pos);

        return result;
    }

    /**
     * Checks that only one swap is needed for the sorted array.
     *
     * @param arr Array.
     * @return True if a given array has exactly one swap to get sorted array.
     */
    public static boolean isOneSwapForSorted(int[] arr) {
        boolean res = false;
        int m = -1, n = -1;
        int i = 0;
        
        while ((i < arr.length - 1) && (m < 0 || n < 0)) {
            if (arr[i] > arr[i + 1]) {
                if (m < 0) {
                    m = i;
                } else {
                    n = i + 1;
                }
            }

            i++;
        }
        
        if (m != -1) {
            if (n == -1) n = m + 1; // for check neighbors elements

            int[] testArr = java.util.Arrays.copyOf(arr, arr.length);
            swap(testArr, n, m);
            res = isSorted(testArr);
        }

        return res;
    }
}
