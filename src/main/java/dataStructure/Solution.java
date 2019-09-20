package dataStructure;

import org.junit.jupiter.api.Test;
class Solution {
    public String longestPalindrome(String s) {
        String maxLen = ""; // 最长至少是1
        boolean PalindromeBox[][] = new boolean[s.length()][s.length()];
        if (s.length() < 2) {
            return s;
        }else if(s.length()==2){
            if(isPalindrome(s)){return s;}
            else{return s.substring(1);}
        } else {
            for (int i = 0; i < s.length(); i++) {
                PalindromeBox[i][i] = true;
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(j)==s.charAt(i) && (i- j < 2 || PalindromeBox[i + 1][j - 1])){
                        maxLen = maxLen.length() >= i-j+1? maxLen : s.substring(j, i+1);
                    }
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
