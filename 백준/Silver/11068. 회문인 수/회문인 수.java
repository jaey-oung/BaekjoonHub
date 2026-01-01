import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int number = Integer.parseInt(br.readLine());
            boolean found = false;

            for (int base = 2; base <= 64; base++) {
                int[] digits = convertToBase(number, base);
                
                if (isPalindrome(digits)) {
                    found = true;
                    break;
                }
            }
            sb.append(found ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static int[] convertToBase(int number, int base) {
        int length = 0;
        int temp = number;

        while (temp > 0) {
            temp /= base;
            length++;
        }

        int[] digits = new int[length];
        int index = 0;

        while (number > 0) {
            digits[index++] = number % base;
            number /= base;
        }
        return digits;
    }

    private static boolean isPalindrome(int[] digits) {
        int left = 0;
        int right = digits.length - 1;

        while (left < right) {
            if (digits[left] != digits[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}