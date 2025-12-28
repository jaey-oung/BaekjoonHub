import java.io.*;

class Main {
    static boolean[] isEurekaNumber = new boolean[1001];

    public static void preprocess() {
        int[] triangularNumbers = new int[50];
        int triangularNumberCount = 0;

        for (int i = 1; ; i++) {
            int triangularNumber = i * (i + 1) / 2;

            if (triangularNumber >= 1000)
                break;

            triangularNumbers[triangularNumberCount++] = triangularNumber;
        }

        boolean[] isSumOfTriangularNumber = new boolean[1000];

        for (int i = 0; i < triangularNumberCount; i++) {
            for (int j = 0; j < triangularNumberCount; j++) {
                int sum = triangularNumbers[i] + triangularNumbers[j];

                if (sum < 1000)
                    isSumOfTriangularNumber[sum] = true;
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (!isSumOfTriangularNumber[i])
                continue;

            for (int j = 0; j < triangularNumberCount; j++) {
                int sum = i + triangularNumbers[j];

                if (sum <= 1000)
                    isEurekaNumber[sum] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(br.readLine());

        preprocess();

        while (testCaseCount-- > 0) {
            int target = Integer.parseInt(br.readLine());

            bw.write((isEurekaNumber[target] ? "1" : "0") + "\n");
        }
        bw.flush();
    }
}