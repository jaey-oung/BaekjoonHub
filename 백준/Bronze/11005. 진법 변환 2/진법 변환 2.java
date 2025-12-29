import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static char getDigitChar(int digit) {
        if (digit < 10)
            return (char) ('0' + digit);
        else
            return (char) ('A' + (digit - 10));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int decimalNumber = Integer.parseInt(st.nextToken());
        int targetBase = Integer.parseInt(st.nextToken());
        StringBuilder result = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % targetBase;
            result.append(getDigitChar(remainder));
            decimalNumber /= targetBase;
        }

        bw.write(result.reverse() + "\n");
        bw.flush();
    }
}