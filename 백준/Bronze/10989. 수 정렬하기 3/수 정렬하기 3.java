import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberCount = Integer.parseInt(br.readLine());
        int[] frequency = new int[10001]; // 계수 정렬용 빈도수 배열 (1~10000)

        for (int i = 0; i < numberCount; i++)
            frequency[Integer.parseInt(br.readLine())]++;

        for (int i = 1; i <= 10000; i++)
            while (frequency[i]-- > 0)
                bw.write(i + "\n");

        bw.flush();
    }
}