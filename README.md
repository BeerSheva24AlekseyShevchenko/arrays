# Arrays

Utilities for working with arrays.

## Methods

**search**

Search element in array.
Return index of element in array.

```java
  int[] arr = new arr[] {9, 3, 6);

  int result = Arrays.search(arr, 3);
  // result = 1

  int result = Arrays.search(arr, 99);
  // result = -1
```

**add**

Add element to array.
Return new array.

```java
  int[] arr = new arr[] {9, 3);

  int result = Arrays.add(arr, 6);
  // result = {9, 3, 6}
```

**insert**

Insert element to array.
Return new array.

```java
  int[] arr = new arr[] {9, 6);

  int result = Arrays.insert(arr, 1, 3);
  // result = {9, 3, 6}
```

**remove**

Remove element from array.
Return new array.

```java
  int[] arr = new arr[] {9, 3, 6);

  int result = Arrays.remove(arr, 1);
  // result = {9, 6}
```

**swap**

Swap two elements in array.
Return array.

```java
  int[] arr = new arr[] {9, 3, 6);

  int result = Arrays.swap(arr, 0, 2);
  // result = {6, 3, 9}
```

**sort**

Sort array (asc).
Return array.

```java
  int[] arr = new arr[] {9, 3, 6);

  int result = Arrays.sort(arr);
  // result = {3 ,6, 9}
```

**isSorted**

Check sorted array (asc).
Return true - if sorted array, false - if unsorted array.

```java
  int[] arr = new arr[] {3, 6, 9);

  int result = Arrays.isSorted(arr);
  // result = true
```

**binarySearch**

Search element in sorted array.
Return index of element in array.

```java
  int[] arr = new arr[] {3, 6, 9);

  int result = Arrays.binarySearch(arr, 6);
  // result = 1;
```

**insertSorted**

Insert element to sorted array.
Return new array.

```java
  int[] arr = new arr[] {3, 6, 9);

  int result = Arrays.insertSorted(arr, 4);
  // result = {3, 4, 6, 9};
```

**isOneSwapForSorted**

Checks that only one swap is needed for the sorted array
Return true if a given array has exactly one swap to get sorted array.

```java
  int[] arr = new arr[] {12, 3, 6, 9, 0);

  int result = Arrays.isOneSwapForSorted(arr);
  // result = true;
```

## Test report

![Screenshot of a test report](test_report.png)

