package arrays;

public class string {

       public static void main(String[] args) {
           StringBuilder sb_16 = new StringBuilder(); //默认初始长度为16
           StringBuilder sb_32 = new StringBuilder(32); //初始长度为32
           StringBuilder sb = new StringBuilder("abcd"); //默认长度为4 + 16，后边其他都是\u0000 null填充

           sb.append(1).append("tr");
           // 因为.append会return this 所以可以使用方法链
           System.out.println(sb);

    }

}
