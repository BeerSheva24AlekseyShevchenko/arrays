package telran.util;

final public class Arrays {
    private Arrays() {}

    /**
     * Search element in array.
     *
     * @return index of element in array.
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
     * @return new array.
     */
    public static int[] add(int[] arr, int number) {
        int[] result = java.util.Arrays.copyOf(arr, arr.length + 1);

        result[arr.length] = number;

        return result;
    }

    /**
     * Insert element to array.
     *
     * @return new array.
     */
    public static int[] insert(int[] arr, int index, int number) {
        if (index < 0 || index > arr.length) {
            throw new IllegalArgumentException("incorrect index");
        }

        int[] result = new int[arr.length + 1];

        System.arraycopy(arr, 0, result, 0, index);

        result[index] = number;

        System.arraycopy(arr, index, result, index + 1, arr.length - index);

        return result;
    }

    /**
     * Remove element from array.
     *
     * @return new array.
     */
    public static int[] remove(int[] numbers, int index) {
        if (index < 0 || index > numbers.length - 1) {
            throw new IllegalArgumentException("incorrect index");
        }

        int[] result = new int[numbers.length - 1];

        System.arraycopy(numbers, 0, result, 0, index);
        System.arraycopy(numbers, index + 1, result, index,  numbers.length - index - 1);

        return result;
    }
}
