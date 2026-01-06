import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] wheel = new char[N];

        Arrays.fill(wheel, '?');

        int position = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int step = Integer.parseInt(st.nextToken());
            char alphabet = st.nextToken().charAt(0);

            position = ((position - step) % N + N) % N;

            if (wheel[position] == '?') {
                wheel[position] = alphabet;
            } else if (wheel[position] != alphabet) {
                System.out.println("!");
                return;
            }
        }

        if (!isValid(wheel, N)) {
            System.out.println("!");
            return;
        }

        printWheel(wheel, position, N);
    }

    // 중복 글자 검사
    private static boolean isValid(char[] wheel, int size) {
        boolean[] isUsed = new boolean[26];

        for (int i = 0; i < size; i++) {
            if (wheel[i] == '?') {
                continue;
            }

            if (isUsed[wheel[i] - 'A']) {
                return false;
            }
            isUsed[wheel[i] - 'A'] = true;
        }
        return true;
    }

    // 마지막 위치부터 시계방향 출력
    private static void printWheel(char[] wheel, int startPosition, int size) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(wheel[(startPosition + i) % size]);
        }
        System.out.print(sb);
    }
}