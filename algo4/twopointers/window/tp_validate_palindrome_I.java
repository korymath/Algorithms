package window;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 *
 * For example,
 *
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/valid-palindrome/}
 *
 */
public class tp_validate_palindrome_I
{
    public boolean isPalindrome(String s)
    {
        int n = s.length();

        for (int l = 0, r = n - 1; l < r; ++l, --r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
        }

        return true;
    }
}
