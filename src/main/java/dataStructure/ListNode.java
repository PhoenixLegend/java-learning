package dataStructure;

import javax.swing.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

//    @Override
//    public String toString() {
//        String retStr = "Contents:\n";
//        ListNode current = this;
//        while (current != null) {
//            retStr += current.val + "\n";
//            current = current.next;
//
//        }
//
//        return retStr;
//    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next  = new ListNode(3);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(2);
//        l2.next.next  = new ListNode(3);
//
//        System.out.println(addTwoNumbers(l1,l2).toString());

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        while(l1 != null && l2 != null){
            boolean carry = false;
            // 相加，如果有进位就加一
            int sum = l1.val + l2.val + (carry? 0:1);
            // 重新判断下一位是否需要进位
            carry = sum >= 10;
            ListNode node = new ListNode(carry? sum/10:sum);
            // listnode的增加节点操作
            if(temp == null){
                temp = node;
                result = temp;
                // 这里java由于没有指针所有不好理解。用下面的打印可以看出，result和temp其实调用
                // 的是同一个地址，所以相当于把temp最开始的节点位置给了result，所以后面不管temp
                // 怎么变化，或者增加节点，result都会随之变化（做一下内存分析）
                //System.out.println(temp + "   " + result);
            }else{
                temp.next = node; // 加一组，temp.next 也是一个listnode
                temp = temp.next;// 移位
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        return result;
    }
}
