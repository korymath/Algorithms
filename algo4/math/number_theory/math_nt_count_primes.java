package number_theory;

public class math_nt_count_primes
{
    public int countPrimes(int n)
    {
        int count = 0;
        boolean[] used = new boolean[n];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!used[i - 1]) {
                int temp = i * i;

                while (temp < n) {
                    used[temp - 1] = true;
                    temp += i;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!used[i - 1]) {
                count++;
            }
        }

        return count;
    }
}
