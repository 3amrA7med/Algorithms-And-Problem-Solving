package com.playground.array.two_pointers.easy;

/**
 * 125. Valid Palindrome
 */
public class ValidPalindrome {
    public void run() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * 2ms Beats 99.78%
     * 42.16mb Beats 69.08%
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while(l <= r) {
            while(l < chars.length && notAChar(chars[l])) l++;
            while(r >= 0 && notAChar(chars[r])) r--;

            if(l>r) break;
            if(Character.toLowerCase(chars[l++]) != Character.toLowerCase(chars[r--])) return false;
        }

        return true;
    }

    private boolean notAChar(char c) {
        return (c - 'a' < 0 || c - 'a' >= 26) && (c - 'A' < 0 || c - 'A' >= 26) && (c - '0' < 0 || c - '0' > 9);
    }


    /**
     * 15ms Beats 45.88%
     * 44.19mb Beats 27.75%
     * @param s
     * @return
     */
    public boolean isPalindrome3(String s) {
        String cleanS = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] chars = cleanS.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while(l <= r)
            if(chars[l++] != chars[r--]) return false;

        return true;
    }
}
