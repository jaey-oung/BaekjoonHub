import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        System.out.println(convert(N, B));
    }

    private static String convert(int number, int base) {
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            int remainder = number % base;
            sb.append(toDigit(remainder));
            number /= base;
        }

        return sb.reverse().toString();
    }

    private static char toDigit(int value) {
        if (value < 10) {
            return (char) ('0' + value);
        } else {
            return (char) ('A' + value - 10);
        }
    }
}