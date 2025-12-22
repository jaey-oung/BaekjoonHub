import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sequenceSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[sequenceSize];

        for (int i = 0; i < sequenceSize; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        int targetSum = Integer.parseInt(br.readLine());
        boolean[] exists = new boolean[1000001]; // 숫자 존재 여부

        for (int i = 0; i < sequenceSize; i++)
            exists[numbers[i]] = true;

        int pairCount = 0;

        for (int i = 1; i <= (targetSum - 1) / 2; i++) {
            int pairValue = targetSum - i;

            if (i <= 1000000 && pairValue <= 1000000 && exists[i] && exists[pairValue])
                pairCount++;
        }

        bw.write(pairCount + "\n");
        bw.flush();
    }
}