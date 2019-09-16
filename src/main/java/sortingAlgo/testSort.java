package sortingAlgo;

import org.junit.Test;

public class testSort {

    @Test
    public void test(){

        int[] a = {32,43,23,13,5};
        //new insert().insertSort(a);
        new shell().sheelSort(a);
        for (int x:
                a) {
            System.out.print(x+" ");
        }
        System.out.println();
    }
}
