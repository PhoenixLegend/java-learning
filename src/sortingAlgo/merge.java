package sortingAlgo;

/**
 * 速度仅次于快排，内存少的时候使用，可以进行并行计算的时候使用。
 * 选择相邻两个数组成一个有序序列。
 * 选择相邻的两个有序序列组成一个有序序列。
 * 重复第二步，直到全部组成一个有序序列。
 *https://upload-images.jianshu.io/upload_images/1441907-a95693cd7caa1003.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/490/format/webp
 */
public class merge {
    public static void mergeSort(int[] numbers, int left, int right) {
        int t = 1;// 每组元素个数
        int size = right - left + 1;
        while (t < size) {
            int s = t;// 本次循环每组元素个数
            t = 2 * s;
            int i = left;
            while (i + (t - 1) < size) {
                merge(numbers, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right)
                merge(numbers, i, i + (s - 1), right);
        }
    }
    private static void merge(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1)
            B[k++] = data[t++];
        else
            B[k++] = data[s++];
        for (int i = p; i <= r; i++)
            data[i] = B[i];
    }
}
