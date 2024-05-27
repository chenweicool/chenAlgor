package com.chen.algor.sort;

/**
 */
public class SortAlgorCollection {

    /**
     *  * 冒泡排序
     *  * 优点：实现简单，比较直观
     *  * 缺点时间复杂度比较高,如果数组是有序的，那么复杂度并不会降低
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n-1 ; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 基于第一层来交换的，减少了交换次数，代码复杂度也是n2
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
             int minIndex = i;
             // 遍历找到最小小标
            for (int j = i+1; j <array.length; j++) {
                if (array[j] < array[minIndex]) {
                     minIndex = j;
                }
            }
            // 数据交换
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 插入排序算法
     * 往已经排序好的数组里面放入数据一种算法
     * @param array
     */
    public static void insertSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
             int key = array[i];
             int j = i-1;
             // 找出这个范围里面最小的,向右，插入最左数据
            while (j >=0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
             //
            array[j + 1] = key;
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 取出中间值，进行递归
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i =  low-1;
        // 遍历数组
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                 i++;
                 // 交换
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        //进行最后的交换
        int temp =  array[i+1];
        array[i + 1] = pivot;
        pivot = temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 6};
        int[] selectArray = {1, 9, 5, 7, 6};
        int[] insertSort = {2, 1, 5, 4, 2, 1};
        int[] quickSort = {4, 6, 1, 3, 6, 9};
        SortAlgorCollection.bubbleSort(array);
        System.out.println("sorted result:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        SortAlgorCollection.selectSort(selectArray);
        System.out.print("selected result:");
        for (int i : selectArray) {
            System.out.print(i + " ");
        }
        SortAlgorCollection.insertSort(insertSort);
        System.out.println();
        for (int i : insertSort) {
            System.out.print(i + " ");
        }
        System.out.println();
        SortAlgorCollection.quickSort(quickSort, 0, quickSort.length - 1);
        System.out.println();
        for (int i : quickSort) {
            System.out.print(i + " ");
        }
    }
}
