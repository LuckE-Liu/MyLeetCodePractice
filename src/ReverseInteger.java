import java.math.BigDecimal;
import java.util.List;

public class ReverseInteger {
    public int reverse1(int x) {
        String intergerString = Integer.toString(x);
        char[] intergerArray = intergerString.toCharArray();
        StringBuilder sb = new StringBuilder(intergerString.length());

        for (int i = intergerString.length() - 1; i >=0; i--) {
            if (intergerArray[i] == '-') {
                continue;
            }
            if ((int)intergerArray[i] == 0) {
                continue;
            } else {
                sb.append(intergerArray[i]);
            }
        }

        int result = Long.parseLong(sb.toString()) > Integer.MAX_VALUE ? 0 : Integer.parseInt(sb.toString());
        if (intergerArray[0] == '-') {
            result = result * -1;
        }

        return result;
    }

    public int reverse2(int x) {
        int output = 0;

        while (true) {
            if (x == 0) {
                return x;
            }

            output = output * 10 + x % 10;

            if ((x /= 10) == 0) {
                return output;
            }

            if (output > 214748364 || output < -214748364) {
                return 0;
            }
        }
    }

}
