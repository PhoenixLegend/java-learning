package sortingAlgo;

/**
 * 一般不用。
 * 设置循环次数。
 * 设置开始比较的位数，和结束的位数。
 * 两两比较，将最小的放到前面去。
 * 重复2、3步，直到循环次数完毕。
 *https://upload-images.jianshu.io/upload_images/1441907-d56533b75c693313.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/396/format/webp
 */
public class bubble {
    public void bubbleSort(int[] a){
        int length=a.length;
        int temp;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
