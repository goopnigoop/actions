package com.example.tasks.demo.sort;

import java.util.Arrays;


public class Main {

    private final static int[] arr = new int[]{1, 5, 7, 3, 2, 6, 8, 3, 6, 34, 654, 234, 77};

    public static void main(String[] args) {
        System.out.println("Not Sorted: " + Arrays.toString(arr));
        int[] ints = sortWithBubbles(arr);
        System.out.println("Sorted with bubbles " + Arrays.toString(ints) + " " + isSorted(ints));
        System.out.println("Not Sorted: " + Arrays.toString(arr));
        ints = sortSimple(arr);
        System.out.println("Sorted simple " + Arrays.toString(ints) + " " + isSorted(ints));
        System.out.println("Not Sorted: " + Arrays.toString(arr));
        ints = sortInsertion(arr);
        System.out.println("Sorted with insertion " + Arrays.toString(ints) + " " + isSorted(ints));
        System.out.println("Not Sorted: " + Arrays.toString(arr));
        ints = sortQuick(arr);
        System.out.println("Sorted with quick sort " + Arrays.toString(ints) + " " + isSorted(ints));

    }

    private static int[] sortQuick(int[] arr) {
        final int[] ints = Arrays.copyOf(arr, arr.length);
        int start = 0;
        int end = arr.length - 1;
        qs(ints, start, end);
        return ints;
    }

    private static void qs(int[] ints, int start, int end) {
        int l = start;
        int h = end;
        int mid = l + (h - l) / 2;
        int m = ints[mid];
        while (l <= h) {
            while (ints[l] < m) {
                l++;
            }
            while (ints[h] > m) {
                h--;
            }
            if (l <= h) {
                swap(ints, l, h);
                l++;
                h--;
            }
        }
        if (start < h) {
            qs(ints, start, h);
        }
        if (l < end) {
            qs(ints, l, end);
        }
    }

    private static int[] sortInsertion(int[] arr) {
        final int[] ints = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < ints.length; i++) {
            for (int j = i; j > 0; j--) {
                if (ints[j] < ints[j - 1]) {
                    swap(ints, j, j - 1);
                }
            }
        }
        return ints;
    }

    private static int[] sortSimple(int[] arr) {
        final int[] ints = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    swap(ints, i, j);
                }
            }
        }
        return ints;
    }

    private static int[] sortWithBubbles(int[] arr) {
        final int[] ints = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < ints.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    swap(ints, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return ints;
    }

    private static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;

    }

    private static void swap(int[] ints, int j, int i) {
        int res = ints[j] * ints[i];
        ints[j] = res / ints[j];
        ints[i] = res / ints[i];
    }
}
