import java.util.*;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abadd"));
    }
}


//    int lengthOfS = s.length();
//        char[] chars = s.toCharArray();
//        List<Character> list = new ArrayList<>(lengthOfS);
//
//        String tempMax = "";
//        int minindex = 0;
//        int maxindex = s.length() - 1;
//
//
//        if (lengthOfS == 1) {
//            return s;
//        }
//
//        if (lengthOfS == 2) {
//            if (chars[0] == chars[1]) {
//                return s;
//            } else {
//                return s.substring(1);
//            }
//        }
//
//        if (chars[minindex] == chars[maxindex]) {
//            return s;
//        }
//
//        for (int i = 1; i <= lengthOfS; i++) {
//            if (i % 2 == 1) {
//                if (list.contains(chars[minindex])) {
//                    int index = list.indexOf(chars[minindex]);
//                    if (index % 2 == 0) {
//                        tempMax = tempMax.length() > ((minindex - index) / 2) + 1 ? tempMax : s.substring(index / 2, minindex + 1);
//                        list.add(chars[minindex]);
//                        minindex++;
//                    } else {
//                        return s.substring(minindex,lengthOfS - index / 2);
//                    }
//                } else {
//                    list.add(chars[minindex]);
//                    minindex++;
//                }
//            } else {
//                if (list.contains(chars[maxindex])) {
//                    int index = list.indexOf(chars[maxindex]);
//                    if (index % 2 == 1) {
//                        tempMax = tempMax.length() > (lengthOfS - index / 2) - maxindex ? tempMax : s.substring(maxindex, lengthOfS - index / 2);
//                        list.add(chars[maxindex]);
//                        maxindex--;
//                    } else {
//                        return s.substring(index / 2, maxindex + 1);
//                    }
//                } else {
//                    list.add(chars[maxindex]);
//                    maxindex--;
//                }
//            }
//        }
//        return tempMax;