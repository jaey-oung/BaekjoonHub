import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowCount = sc.nextInt(); // 성의 세로 크기
        int colCount = sc.nextInt(); // 성의 가로 크기

        char[][] castle = new char[rowCount][colCount]; // 성의 상태

        for (int r = 0; r < rowCount; r++)
            castle[r] = sc.next().toCharArray(); // 각 행의 상태 입력

        boolean[] rowHasGuard = new boolean[rowCount]; // 각 행의 경비원이 있는지 여부
        boolean[] colHasGuard = new boolean[colCount]; // 각 열의 경비원이 있는지 여부

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (castle[r][c] == 'X') { // 경비원 발견
                    rowHasGuard[r] = true; // 해당 행에 경비원이 있음
                    colHasGuard[c] = true; // 해당 열에 경비원이 있음
                }
            }
        }

        int missingRows = rowCount; // 경비원이 없는 행의 개수
        int missingCols = colCount; // 경비원이 없는 열의 개수

        for (int r = 0; r < rowCount; r++) {
            if (rowHasGuard[r]) // 해당 행에 경비원이 있으면
                missingRows--; // 필요한 행 개수 감소
        }

        for (int c = 0; c < colCount; c++) {
            if (colHasGuard[c]) // 해당 열에 경비원이 있으면
                missingCols--; // 필요한 열 개수 감소
        }

        System.out.println(Math.max(missingRows, missingCols)); // 둘 중 큰 값
    }
}