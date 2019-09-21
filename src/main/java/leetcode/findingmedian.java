package leetcode;

import org.junit.jupiter.api.Test;

class findingmedian {
    final int MAX = 2147483647;
    final int MIN = -2147483648;
    public  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保m是大于等于n的，用于后面i的加减变化不会导致无解
        int[] A = nums1.length >= nums2.length ? nums1 : nums2;
        int[] B = A==nums1 ? nums2 : nums1;
        double rs = 0;
        int m = A.length;
        int n = B.length;
        if(n==0){
            if(m%2==0)
                rs = ((double) A[m/2-1]+A[m/2])/2;
            else
                rs = A[m/2];

        }else{
            // i与j分别代表数组种的划分位置
            int i = 1; //default
            int j = (int)(Math.ceil(((double) m+n)/2))-i; //default 向上取整
            // left长度 始终大于 right长度
            int lmax = Math.max(ifOutOfBound(i-1,A), ifOutOfBound(j-1,B)); //需要修改，每种情况均有越界，判断大小界
            int rmin = Math.min(ifOutOfBound(i,A),ifOutOfBound(j,B));

            while(lmax > rmin){
                if(ifOutOfBound(i-1,A) > ifOutOfBound(j,B)){
                    // i is so big but check whether nums[i-1] out of boundray
                    i = Math.min(i - 1, 0);
                    j = (int)Math.ceil(((double)m+n)/2)-i;

                    lmax = Math.max(ifOutOfBound(i-1,A), ifOutOfBound(j-1,B));
                    rmin = Math.min(ifOutOfBound(i,A),ifOutOfBound(j,B));
                }else if(ifOutOfBound(j-1,B) > ifOutOfBound(i,A)){
                    // i is so small
                    i = Math.min(i + 1, m);
                    j = (int)Math.ceil(((double)m+n)/2)-i;

                    lmax = Math.max(ifOutOfBound(i-1,A), ifOutOfBound(j-1,B));
                    rmin = Math.min(ifOutOfBound(i,A),ifOutOfBound(j,B));
                    continue;
                }

            }
            if((m+n)%2==0){
                rs = ((double) lmax+rmin)/2;
            }else{
                rs = lmax;

            }

        }
        return rs;
    }
    public int ifOutOfBound(int index,int[] test){
        if(index<0){
            return MIN;
        }else if(index>=test.length){
            return MAX;
        }else{
            return test[index];
        }
    }
    @Test
    public void test() {
        int[] a = {100001};
        int[] b = {100000};
        //double x = Math.ceil(3/2.0);
        //System.out.println(x);

        System.out.println(findMedianSortedArrays(a,b));
    }
}