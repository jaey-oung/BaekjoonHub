import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt(); // 테스트 케이스 개수

        while (testCaseCount-- > 0) { // 각 테스트 케이스 처리
            int caseId = sc.nextInt(); // 테스트 케이스 번호
            int[] heights = new int[20]; // 학생들의 키
            int backStepCount = 0; // 뒤로 물러난 총 횟수

            for (int i = 0; i < 20; i++) {
                heights[i] = sc.nextInt(); // i번째 학생의 키 입력

                for (int j = 0; j < i; j++) { // 이미 줄 선 학생들 확인
                    if (heights[j] > heights[i]) // 자기보다 키가 큰 학생이면
                        backStepCount++; // 물러난 횟수 증가
                }
            }
            System.out.println(caseId + " " + backStepCount);
        }
    }
}