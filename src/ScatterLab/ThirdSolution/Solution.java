package ScatterLab.ThirdSolution;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
    public static int solution(int N, int M) {
        List<Integer> primes = getPrimes(N);
        int count = 0;
        int start = 0, end = 0, sum = 0;

        while (true) {
            if (sum >= M) {
                sum -= primes.get(start);
                start++;
            } else if (end == primes.size()) {
                break;
            } else {
                sum += primes.get(end);
                end++;
            }
            if (sum == M) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        int N1 = 20, M1 = 36;
        int N2 = 100, M2 = 83;
        int N3 = 12, M3 = 10;

        System.out.println(solution(N1, M1)); // 출력: 2
        System.out.println(solution(N2, M2)); // 출력: 3
        System.out.println(solution(N3, M3)); // 출력: 1
    }
}

