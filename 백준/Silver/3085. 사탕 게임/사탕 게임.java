import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxCandy = 0;

        // 모든 칸에 대해 인접한 칸과 교환 시도
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 오른쪽 칸과 교환
                if (j + 1 < N) {
                    swap(board, i, j, i, j + 1);
                    maxCandy = Math.max(maxCandy, getMaxCandy(board));
                    swap(board, i, j, i, j + 1);
                }

                // 아래 칸과 교환
                if (i + 1 < N) {
                    swap(board, i, j, i + 1, j);
                    maxCandy = Math.max(maxCandy, getMaxCandy(board));
                    swap(board, i, j, i + 1, j);
                }
            }
        }
        System.out.println(maxCandy);
    }

    // 두 위치의 사탕 교환
    private static void swap(char[][] board, int r1, int c1, int r2, int c2) {
        char temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    // 보드에서 가장 긴 연속 사탕 개수 반환
    private static int getMaxCandy(char[][] board) {
        int N = board.length;
        int max = 1;

        // 각 행에서 가로 방향 연속 체크
        for (int r = 0; r < N; r++) {
            int count = 1;

            for (int c = 1; c < N; c++) {
                if (board[r][c] == board[r][c - 1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        // 각 열에서 세로 방향 연속 체크
        for (int c = 0; c < N; c++) {
            int count = 1;

            for (int r = 1; r < N; r++) {
                if (board[r][c] == board[r - 1][c]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}