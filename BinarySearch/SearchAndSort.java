/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namespacemedia.searchandsort;

/**
 *
 * @author Christopher
 */
public class SearchAndSort {
    
    private static boolean found;
    private static int foundIndex = -1;
    
    private SearchAndSort () {
        
    }
    
    public static void sort (int[] data) {
        recSort(data, 0, data.length - 1);
    }
    
    private static void recSort (int []data, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int median = partition(data, startIndex, endIndex);
            recSort(data, startIndex, median - 1);
            recSort(data, median + 1, endIndex);
        }
    }
    
    private static int partition (int[] data, int startIndex, int endIndex) {
            int pivotIndex = startIndex + ((endIndex - startIndex) / 2);
            int swapIndex = startIndex;
            
            swap(data, startIndex, pivotIndex);
            
            for (int i = startIndex + 1; i <= endIndex; i++) {              
                if (data[i] < data[startIndex]) {
                    swap(data, i, ++swapIndex);
                }
            }

            swap(data, startIndex, swapIndex);
            
            return swapIndex;
    }
    
    private static void swap (int[] data, int firstIndex, int secondIndex) {
        int temp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }
       
    
    
    public static int search (int[] data, int searchValue) {
        return search(data, searchValue, false);
    }
    
    public static int search (int[] data, int searchValue, boolean sort) {
        
        int[] d;
        if (!sort) {
            d = new int[data.length];
            
            for (int i = 0; i < data.length; i++) {
                d[i] = data[i];
            }
        }
        else
            d = data;
            
        sort(d);
        
        found = false;
        recSearch(d, searchValue, 0, d.length - 1);
        
        return foundIndex;
    }
    
    private static void recSearch (int[] data, int searchValue, int firstIndex, int endIndex) {       
        if (endIndex <= firstIndex && searchValue == data[firstIndex]) {
            found = true;
            foundIndex = firstIndex;
        }
        else if (endIndex <= firstIndex) 
            return;
        else {
            int medianIndex = ((endIndex - firstIndex) / 2) + firstIndex;
            
            if (data[medianIndex] == searchValue) {
                found = true;
                foundIndex = medianIndex;
                return;
            }
            
            if (searchValue < data[medianIndex])
                recSearch(data, searchValue, firstIndex, medianIndex - 1);
            else
                recSearch(data, searchValue, medianIndex + 1, endIndex);
        }
    }
    
    public static void main (String[] args) {
        int[] data = {1, 3, 4, 7, 9, 12, 30};
        
        System.out.println(BinarySearchFirst.searchFirst(data, 7));
        System.out.println(BinarySearchLast.searchLast(data, 7));
        //System.out.println(fi);
    }
}
