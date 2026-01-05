import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String commands = br.readLine();

        // 수직/수평 방향으로 지나간 점 기록
        boolean[][] vertical = new boolean[N][N];
        boolean[][] horizontal = new boolean[N][N];

        processCommands(N, commands, vertical, horizontal);
        System.out.print(buildBoard(N, vertical, horizontal));
    }

    // 로봇 팔 이동 명령 수행 및 경로 기록
    private static void processCommands(int size, String commands, boolean[][] vertical, boolean[][] horizontal) {
        int row = 0;
        int col = 0;

        for (int i = 0; i < commands.length(); i++) {
            char cmd = commands.charAt(i);

            if (cmd == 'U' && row > 0) {
                vertical[row][col] = vertical[row - 1][col] = true;
                row--;
            } else if (cmd == 'D' && row < size - 1) {
                vertical[row][col] = vertical[row + 1][col] = true;
                row++;
            } else if (cmd == 'L' && col > 0) {
                horizontal[row][col] = horizontal[row][col - 1] = true;
                col--;
            } else if (cmd == 'R' && col < size - 1) {
                horizontal[row][col] = horizontal[row][col + 1] = true;
                col++;
            }
        }
    }

    // 보드 문자열 생성
    private static String buildBoard(int size, boolean[][] vertical, boolean[][] horizontal) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(getSymbol(vertical[i][j], horizontal[i][j]));
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    // 지나간 방향에 따른 심볼 반환
    private static char getSymbol(boolean vertical, boolean horizontal) {
        if (vertical && horizontal) {
            return '+';
        }

        if (vertical) {
            return '|';
        }

        if (horizontal) {
            return '-';
        }
        return '.';
    }
}