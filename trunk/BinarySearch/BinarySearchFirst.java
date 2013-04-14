package com.blainesmith.binarysearch;

import java.util.Scanner;

/**
 *
 * @author Blaine
 */
public class BinarySearchFirst {

    private static int numbers[] = {1, 35, 3, 66, 6, 6, 7, 8, 9, 12, 54, 67, 88, 90, 122, 324, 434, 554, 23, 24, 3, 2};
    private int temp = 0;
    private int arrayMid = 0;
    private static int num = 0;
    
    

    public BinarySearchFirst() {
//        sort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
    }

    private void sort(int array[]) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
    
    private void searchResult(){
        
    }
    
    public void askQuestion(){
        Scanner console = new Scanner(System.in);
        System.out.println("Which number would you like to search for: ");
        num = console.nextInt();
    }

    private int binarySearch(int[] array, int left, int right, int index) {
        arrayMid = (left + right) / 2;       
        if (left > right) {
            return -1;
        }        
        if (array[arrayMid] == index) {
            return arrayMid;
        } else if (array[arrayMid] > index) {
            return binarySearch(array, left, arrayMid - 1, index);
        } else {
            return binarySearch(array, arrayMid + 1, right, index);
        }
    }

    private int compare(int left, int right) {
        if (left < right) {
            return -1;
        } else if (left == right) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        
        
        BinarySearchFirst BSF = new BinarySearchFirst();
        BSF.sort(numbers);
        
        System.out.println("Here is the list of sorted numbers: ");        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        BSF.askQuestion();
        int result = BSF.binarySearch(numbers, numbers[0], numbers[numbers.length +1], num);
        System.out.println(result);
        
                

    }
}
