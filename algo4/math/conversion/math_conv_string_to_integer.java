package conversion;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint:
 *
 * Carefully consider all possible input cases. If you want a challenge, please do not see below and
 * ask yourself what are the possible input cases.
 *
 * Notes:
 *
 * It is intended for this problem to be specified vaguely (ie, no given input specs). You are
 * responsible to gather all the input requirements up front.
 *
 * Requirements for atoi:
 *
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if
 * no such sequence exists because either str is empty or it contains only whitespace characters, no
 * conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out
 * of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/string-to-integer-atoi/}
 *
 */
public class math_conv_string_to_integer
{
    public int myAtoi(String str)
    {
        int i = 0;
        int n = str.length();

        if (n == 0) {
            return 0;
        }

        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        int result = 0;
        for (; i < n && Character.isDigit(str.charAt(i)); i++) {
            int digit = (int) (str.charAt(i) - '0');

            if (sign > 0 && result > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MAX_VALUE;
            } else if (sign < 0 && result < (Integer.MIN_VALUE + digit) / 10) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + sign * digit;
        }

        return result;
    }
}
