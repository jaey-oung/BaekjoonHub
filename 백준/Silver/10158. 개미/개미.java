import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(); // 격자 가로 길이
        int H = sc.nextInt(); // 격자 세로 길이
        int P = sc.nextInt(); // 개미의 초기 x 좌표
        int Q = sc.nextInt(); // 개미의 초기 y 좌표
        int T = sc.nextInt(); // 이동 시간

        int currentX = (P + T) % (2 * W); // x축 위치
        int currentY = (Q + T) % (2 * H); // y축 위치

        if (currentX > W) // 반사된 경우
            currentX = 2 * W - currentX; // 대칭 위치로 변환

        if (currentY > H) // 반사된 경우
            currentY = 2 * H - currentY; // 대칭 위치로 변환

        System.out.println(currentX + " " + currentY);
    }
}