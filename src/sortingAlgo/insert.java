package sortingAlgo;

import org.junit.Test;

/**
 * 经常碰到这样一类排序问题：把新的数据插入到已经排好的数据列中。
 * loop from selecting a element in back unsorted set to a fronted one.
 * 首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
 * 设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
 * 从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
 * 将当前数放置到空着的位置，即j+1。
 * https://upload-images.jianshu.io/upload_images/1441907-5b0cb554db41f153.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/661/format/webp
 */
public class insert {
    public void insertSort(int[] a){
        int length = a.length; // enhance speed while get length value out
        int insertNum; // the number you want to insert
        for(int i = 1;i<length;i++ ){ // how many times insert will execute
            insertNum = a[i];
            int j = i - 1; //numbers of already sorted (starting with [0])
            while (j>=0 && a[j]>insertNum){// loop backwards and compare from end j to the head.
                a[j+1] = a[j]; //element increase 1 position
                j--;
            }
            a[j+1] = insertNum; // insert to the right position
        }
    }

    @Test
    public void test(){
        int[] a = {32,43,23,13,5};
        insertSort(a);
        for (int x:
             a) {
            System.out.print(x+" ");
        }
        System.out.println();
    }
}
