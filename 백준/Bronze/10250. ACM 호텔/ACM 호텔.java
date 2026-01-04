import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int roomNumber = calculateRoomNumber(H, N);
            sb.append(roomNumber).append('\n');
        }
        System.out.print(sb);
    }

    // N번째 손님의 방 번호 계산
    private static int calculateRoomNumber(int height, int guestNumber) {
        int distance = (guestNumber - 1) / height + 1;
        int floor = (guestNumber - 1) % height + 1;

        return floor * 100 + distance;
    }
}