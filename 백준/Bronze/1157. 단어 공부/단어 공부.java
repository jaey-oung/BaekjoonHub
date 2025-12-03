import java.util.Scanner;

class Main {
    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26]; // 알파벳 개수를 저장할 배열

        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'A']++; // 대문자만 처리하면 됨
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase(); // 입력된 영단어를 대문자로 변환
        int[] count = getAlphabetCount(str); // 각 알파벳 출현 빈도 계산
        int maxCount = -1; // 최대 빈도수
        char maxAlphabet = '?'; // 결과값

        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) { // 더 큰 빈도수 발견
                maxCount = count[i];
                maxAlphabet = (char)('A' + i); // 해당 알파벳을 대문자로 저장
            } else if (count[i] == maxCount) // 최댓값과 동일한 빈도수 발견
                maxAlphabet = '?'; // 중복이므로 ? 저장
        }
        System.out.println(maxAlphabet);
    }
}