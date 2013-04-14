/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namespacemedia.searchandsort;

/**
 *
 * @author Christopher
 */
public class BinarySearchFirst {
    
    public static int searchFirst(int[] data, int searchValue) {
        return searchFirst(data, searchValue, false);
    }
    
    public static int searchFirst(int[] data, int searchValue, boolean sort) {
        int fi = SearchAndSort.search(data, searchValue, sort);
        int tempIndex = fi;
        
        if (fi == -1)
            return -1;
        
        try {
            while (data[tempIndex] == searchValue) {
                tempIndex--;
            }
        
            tempIndex++;
        
            return tempIndex;
        }
        catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            return ++tempIndex;
        }
    }
}
