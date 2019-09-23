package leetcode;

import org.junit.jupiter.api.Test;

import javax.xml.stream.util.XMLEventAllocator;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学
// 思路：
// 回文肯定想到的就是翻转
// 如果满足回文的话，就一定可以使用中位扩展的方法
// 但是这样会使用字符串去判断中位数。所以……
// 没思路了，那咋办嘛？
// 其实主要的问题就是不适用字符串的方法找到中间那个数，然后要么反转，要么中位扩展都可以
// x%10可以得到个位数，然后x/10可以得到剩下的位数，以此类推可以得到所有的位数
// 问题是你怎么知道我现在是到了一半？
// 请看大屏幕：
class intPalindrome{
    public boolean isPalindrome(int x) {
        int left = x;
        int right = 0;
        // 负数直接判负
        if(x<0){
            return false;
        }else if(left%10 == 0 && left!=0){
            return false;
            // 判断10这种肯定不是回文，而且用下一步判断还会10变成1而出错
        }
        else{
            while(left>right){
                // 什么时候到中位出来？就是看left是不是还大于右边
                right = left%10+right*10;
                if(left==right){
                    break;
                }
                left /= 10;
            }
            if (left == right)
                return true;
            else
                return false;
        }
    }
    @Test
    void test(){
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(1001));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


