import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(chars.length);

        if (numRows == 1) {
            return s;
        }

        if (s.length() <= numRows) {
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            int n = i;
            if (i == 0 || i == numRows - 1) {
                while (n <= s.length() - 1) {
                    sb.append(chars[n]);
                    n = n + 2 * (numRows - 1);
                }
            } else {
                while (n <= s.length() - 1) {
                    sb.append(chars[n]);
                    n = (numRows - i - 1) * 2 + n;
                    if (n <= s.length() - 1) {
                        sb.append(chars[n]);
                        n = n + 2 * i;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("am",1));
    }
}
