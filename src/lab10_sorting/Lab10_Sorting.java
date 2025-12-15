/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab10_sorting;

/**
 *
 * @author vrund
 */

import java.util.Arrays;
import java.util.Comparator;

public class Lab10_Sorting {

    // Required: insertion sort using Comparable
    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        if (list == null || list.length <= 1) return;

        for (int i = 1; i < list.length; i++) {
            E current = list[i];
            int k = i - 1;

            while (k >= 0 && list[k].compareTo(current) > 0) {
                list[k + 1] = list[k];
                k--;
            }
            list[k + 1] = current;
        }
    }

    // Required: bubble sort using Comparator (lab name: bubleSort)
    public static <E> void bubleSort(E[] list, Comparator<? super E> comparator) {
        if (list == null || list.length <= 1) return;
        if (comparator == null) throw new IllegalArgumentException("Comparator cannot be null");

        for (int pass = 0; pass < list.length - 1; pass++) {
            boolean swapped = false;

            for (int j = 0; j < list.length - 1 - pass; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        Integer[] nums = {9, 4, 5, 7, 4, 1};
        System.out.println("Before insertionSort: " + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("After  insertionSort: " + Arrays.toString(nums));

        System.out.println();

        String[] words = {"Humber", "CPAN211", "Java", "Sorting", "Lab10"};
        System.out.println("Before bubleSort:     " + Arrays.toString(words));
        bubleSort(words, Comparator.comparingInt(String::length));
        System.out.println("After  bubleSort:     " + Arrays.toString(words));
    }
}
