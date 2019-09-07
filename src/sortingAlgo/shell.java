package sortingAlgo;

/**
 * 对于直接插入排序问题，数据量巨大时。
 * 首先确定分的组数。
 * 然后对组中元素进行插入排序。
 * 然后将length/2，重复1,2步，直到length=0为止。
 * https://upload-images.jianshu.io/upload_images/1441907-5db88083f6d1df10.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/466/format/webp
 */
public class shell {
    public  void sheelSort(int[] a){
        int d  = a.length;
        while (d!=0) {
            d=d/2;
            for (int x = 0; x < d; x++) {//分的组数
                for (int i = x + d; i < a.length; i += d) {//组中的元素，从第二个数开始
                    int j = i - d;//j为有序序列最后一位的位数
                    int temp = a[i];//要插入的元素
                    for (; j >= 0 && temp < a[j]; j -= d) {//从后往前遍历。
                        a[j + d] = a[j];//向后移动d位
                    }
                    a[j + d] = temp;
                }
            }
        }
    }
}
