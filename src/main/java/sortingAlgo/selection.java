package sortingAlgo;

/**
 * 常用于取序列中最大最小的几个数时。
 * (如果每次比较都交换，那么就是交换排序；如果每次比较完一个循环再交换，就是简单选择排序。)
 * 首先确定循环次数，并且记住当前数字和当前位置。
 * 将当前位置后面所有的数与当前数字进行对比，小数赋值给key，并记住小数的位置。
 * 比对完成后，将最小的值与第一个数的值交换。
 * 重复2、3步。
 * https://upload-images.jianshu.io/upload_images/1441907-4d52b967174d8003.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/531/format/webp
 */
public class selection {
    public void selectSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {//循环次数
            int key = a[i];
            int position=i;
            for (int j = i + 1; j < length; j++) {//选出最小的值和位置
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            a[position]=a[i];//交换位置
            a[i]=key;
        }
    }
}
