package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * ==========================
 * A valid IP address consists of exactly four integers separated by single dots.
 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245",
 * "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that
 * can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s.
 * You may return the valid IP addresses in any order.
 * ======================================
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res;
        restoreIpAddressesBt(s, s.length(), 0, "", 0, res);
        return res;
    }

    public void restoreIpAddressesBt(String s, int stringSize,int index, String ip, int ipIndex, List<String> res) {
        if(ipIndex == 3) {
            if(partIsValid(s.substring(index, stringSize)))
                res.add(ip + s.substring(index, stringSize));
        }

        for(int i = index; i < index + 3; i++) {
            if(i < stringSize && partIsValid(s.substring(index, i + 1)))
                restoreIpAddressesBt(s, stringSize, i + 1, ip + s.substring(index, i + 1) + ".", ipIndex + 1, res);
        }
    }

    public boolean partIsValid(String s) {
        int size = s.length();
        if(
            size == 0                       ||
            size > 1 && s.charAt(0) == '0'  ||
            size > 3                        ||
            Integer.parseInt(s) > 255
        ) return false;
        return true;
    }
}
