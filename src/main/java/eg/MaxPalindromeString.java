package eg;

/**
 * Created by jiguang on 2018/9/7.
 */

public class MaxPalindromeString {
    static int getMaxPalindromeString(String s) {
        return getMaxPalindromeString(s.toCharArray());
    }

    static int getMaxPalindromeString(char[] chars) {
        int length = chars.length;
        if (length > 1) {
            if (chars[0] == chars[length-1]) {
                char[] chars1 = new char[length - 2];
                System.arraycopy(chars, 1, chars1, 0, length - 2);
                return getMaxPalindromeString(chars1) + 2;
            } else {
                char[] chars2 = new char[length - 1];
                char[] chars3 = new char[length - 1];
                System.arraycopy(chars, 0, chars2, 0, length - 1);
                System.arraycopy(chars, 1, chars3, 0, length - 1);
                return Integer.max(getMaxPalindromeString(chars2), getMaxPalindromeString(chars3));
            }
        } else {
            return length;
        }
    }

    public static void main(String[] args) {
        System.out.println(getMaxPalindromeString("adcbbcda"));
    }
}
