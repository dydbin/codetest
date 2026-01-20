package 정수론;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 정수론_1747 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int i = N;
        while(true) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
    // 팰린드롬 확인
    static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 소수 확인
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
