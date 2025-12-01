import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine(); // 문서 입력
        String word = sc.nextLine(); // 검색할 단어 입력

        int count = 0; // 등장 횟수
        int startIndex = 0; // 검색 시작 위치

        while (true) {
            int findIndex = doc.indexOf(word, startIndex); // startIndex부터 word 찾기

            if (findIndex < 0) // 더 이상 찾을 수 없으면
                break;
            count++; // 등장 횟수 증가
            startIndex = findIndex + word.length(); // 찾은 위치 + 단어 길이만큼 이동
        }
        System.out.println(count);
    }
}