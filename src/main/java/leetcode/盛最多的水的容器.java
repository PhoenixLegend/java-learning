package leetcode;
//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
// 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例:
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49
// Related Topics 数组 双指针

// 思路，暴力法直接遍历找出矩形最大的那个
// 双指针会分别指向两边的线段，求出面积，然后向中间靠，由于面积取决于边长短的那一端。
// 所以要想得到比当前更大的面积，边长短的那一端必须舍弃
// 这可能会导致面积减小，但是有如果新的线段够长就有克服减小的可能


import org.junit.jupiter.api.Test;

//leetcode submit region begin(Prohibit modification and deletion)
class 盛最多的水的容器 {
    public int maxArea(int[] height) {
        int MaxArea = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            MaxArea = Math.max((right - left)*Math.min(height[left],height[right]), MaxArea);
            if(height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
        }
        return MaxArea;

    }
    @Test
    void test(){
        int[] a= {1,8,6,2,5,4,8,3,7};
        maxArea(a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
