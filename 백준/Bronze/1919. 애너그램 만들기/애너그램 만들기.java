import java.util.Scanner;

class Main {
    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26]; // 알파벳 개수를 저장할 배열

        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'a']++; // 해당 알파벳의 인덱스 위치에 개수 증가
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int ans = 0;

        int[] countA = getAlphabetCount(a); // 각 알파벳 출현 빈도 계산
        int[] countB = getAlphabetCount(b);

        for (int i = 0; i < 26; i++)
            ans += Math.abs(countA[i] - countB[i]); // 절댓값으로 차이 계산
        System.out.println(ans);
    }
}