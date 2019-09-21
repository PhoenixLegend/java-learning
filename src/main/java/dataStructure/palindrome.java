package dataStructure;

import org.junit.jupiter.api.Test;
class palindrome {
    public String longestPalindrome(String s) {
        String maxLen = ""; // 最长至少是1
        // using to store palindrome if it is true or false
        boolean[][] PalindromeBox = new boolean[s.length()][s.length()];
//        if (s.length() < 2) {
//            return s;
//        }else if(s.length()==2){
//            if(isPalindrome(s)){return s;}
//            else{return s.substring(1);}
//        } else {
        // i +1才会知道 i ，所以我们只需要倒着遍历
            for (int i = s.length()-1; i >= 0; i--) {
                for (int j = i; j <s.length(); j++) {
                    // we are checking if the length of string is less than 2 or the substring is a true palindrome
                    if (s.charAt(j)==s.charAt(i) && (j-i<2 || PalindromeBox[i + 1][j - 1])){
                        PalindromeBox[i][j] = true;
                        // you start with single char is surely a true palindrome, so you can redo it just like a fbnaqic problem.
                        maxLen = maxLen.length() >= j-i+1? maxLen : s.substring(i, j+1);
                    }
                }
            }
        return maxLen;
        }



    public boolean isPalindrome(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        return s.equals(reverse);
    }
    @Test
    public void test(){
        System.out.println(longestPalindrome("dsadsdasdasd"));
//        String a = "aaa";
//        System.out.println(a.substring(0,3));
    }

}
